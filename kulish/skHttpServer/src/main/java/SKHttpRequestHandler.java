import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.reflections.Reflections;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

//source: https://code-examples.net/ru/q/38f28d
public class SKHttpRequestHandler implements HttpHandler {
    private Map<String, HttpServlet> list = new HashMap<>();

    public boolean loadServletMap() throws InstantiationException, IllegalAccessException, ServletException {
        boolean wasLoad = false;
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Reflections reflections = new Reflections(systemClassLoader);
        //reflections.getSubTypesOf()
        Set<Class<? extends HttpServlet>> constructorsAnnotatedWith = reflections.getSubTypesOf(HttpServlet.class);
        HttpServlet httpServlet = null;
        for (Class<?> cnt : constructorsAnnotatedWith) {
            WebServlet annotation = cnt.getAnnotation(WebServlet.class);
            if (annotation != null) {
                String path = annotation.urlPatterns()[0];
                if (path != null) {
                    httpServlet = list.get(path);
                    if (httpServlet == null) {
                        HttpServlet wsInstance = (HttpServlet) cnt.newInstance();
                        wsInstance.init();
                        list.put(path, wsInstance);
                        wasLoad = true;
                    }
                }
            }
        }
        return wasLoad;
    }

    private final class RequestWrapper extends HttpServletRequestWrapper {
        private final HttpExchange ex;
        private final Map<String, String[]> postData;
        private final ServletInputStream is;
        private final Map<String, Object> attributes = new HashMap<>();

        private RequestWrapper(HttpServletRequest request, HttpExchange ex, Map<String, String[]> postData, ServletInputStream is) {
            super(request);
            this.ex = ex;
            this.postData = postData;
            this.is = is;
        }

        @Override
        public String getHeader(String name) {
            return ex.getRequestHeaders().getFirst(name);
        }

        @Override
        public Enumeration<String> getHeaders(String name) {
            return new Vector<String>(ex.getRequestHeaders().get(name)).elements();
        }

        @Override
        public Enumeration<String> getHeaderNames() {
            return new Vector<String>(ex.getRequestHeaders().keySet()).elements();
        }

        @Override
        public Object getAttribute(String name) {
            return attributes.get(name);
        }

        @Override
        public void setAttribute(String name, Object o) {
            this.attributes.put(name, o);
        }

        @Override
        public Enumeration<String> getAttributeNames() {
            return new Vector<String>(attributes.keySet()).elements();
        }

        @Override
        public String getMethod() {
            return ex.getRequestMethod();
        }

        @Override
        public ServletInputStream getInputStream() throws IOException {
            return is;
        }

        @Override
        public BufferedReader getReader() throws IOException {
            return new BufferedReader(new InputStreamReader(getInputStream()));
        }

        @Override
        public String getPathInfo() {
            return ex.getRequestURI().getPath();
        }

        @Override
        public String getParameter(String name) {
            String[] arr = postData.get(name);
            return arr != null ? (arr.length > 1 ? Arrays.toString(arr) : arr[0]) : null;
        }

        @Override
        public Map<String, String[]> getParameterMap() {
            return postData;
        }

        @Override
        public Enumeration<String> getParameterNames() {
            return new Vector<String>(postData.keySet()).elements();
        }
    }

    private final class ResponseWrapper extends HttpServletResponseWrapper {
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        final ServletOutputStream servletOutputStream = new ServletOutputStream() {

            @Override
            public void write(int b) throws IOException {
                outputStream.write(b);
            }
        };

        private final HttpExchange ex;
        private final PrintWriter printWriter;
        private int status = HttpServletResponse.SC_OK;

        private ResponseWrapper(HttpServletResponse response, HttpExchange ex) {
            super(response);
            this.ex = ex;
            printWriter = new PrintWriter(servletOutputStream);
        }

        @Override
        public void setContentType(String type) {
            ex.getResponseHeaders().add("Content-Type", type);
        }

        @Override
        public void setHeader(String name, String value) {
            ex.getResponseHeaders().add(name, value);
        }

        @Override
        public javax.servlet.ServletOutputStream getOutputStream() throws IOException {
            return servletOutputStream;
        }

        @Override
        public void setContentLength(int len) {
            ex.getResponseHeaders().add("Content-Length", len + "");
        }

        @Override
        public void setStatus(int status) {
            this.status = status;
        }

        @Override
        public void sendError(int sc, String msg) throws IOException {
            this.status = sc;
            if (msg != null) {
                printWriter.write(msg);
            }
        }

        @Override
        public void sendError(int sc) throws IOException {
            sendError(sc, null);
        }

        @Override
        public PrintWriter getWriter() throws IOException {
            return printWriter;
        }

        public void complete() throws IOException {
            try {
                printWriter.flush();
                ex.sendResponseHeaders(status, outputStream.size());
                if (outputStream.size() > 0) {
                    ex.getResponseBody().write(outputStream.toByteArray());
                }
                ex.getResponseBody().flush();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                ex.close();
            }
        }
    }

    public SKHttpRequestHandler() {
    }

    @SuppressWarnings("deprecation")
    @Override
    public void handle(final HttpExchange ex) throws IOException {
        byte[] inBytes = getBytes(ex.getRequestBody());
        ex.getRequestBody().close();
        final ByteArrayInputStream newInput = new ByteArrayInputStream(inBytes);
        final ServletInputStream is = new ServletInputStream() {

            @Override
            public int read() throws IOException {
                return newInput.read();
            }
        };

        Map<String, String[]> parsePostData = new HashMap<>();

        try {
            parsePostData.putAll(HttpUtils.parseQueryString(ex.getRequestURI().getQuery()));

            // check if any postdata to parse
            parsePostData.putAll(HttpUtils.parsePostData(inBytes.length, is));
        } catch (IllegalArgumentException e) {
            // no postData - just reset inputstream
            newInput.reset();
        }
        final Map<String, String[]> postData = parsePostData;

        RequestWrapper req = new RequestWrapper(createUnimplementAdapter(HttpServletRequest.class), ex, postData, is);

        ResponseWrapper resp = new ResponseWrapper(createUnimplementAdapter(HttpServletResponse.class), ex);

        try {
            String path = ex.getRequestURI().getPath();
            if(list.containsKey(path)) {
                list.get(path).service(req, resp);
            } else {
                System.out.println("nooo333");
            }
//            if (servlet == null) {
//                servlet = new SKServlet();
//            }
//            servlet.service(req, resp);
            resp.complete();
        } catch (ServletException e) {
            throw new IOException(e);
        }
    }

    private static byte[] getBytes(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        while (true) {
            int r = in.read(buffer);
            if (r == -1)
                break;
            out.write(buffer, 0, r);
        }
        return out.toByteArray();
    }

    @SuppressWarnings("unchecked")
    private static <T> T createUnimplementAdapter(Class<T> httpServletApi) {
        class UnimplementedHandler implements InvocationHandler {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                throw new UnsupportedOperationException("Not implemented: " + method + ", args=" + Arrays.toString(args));
            }
        }

        return (T) Proxy.newProxyInstance(UnimplementedHandler.class.getClassLoader(),
                new Class<?>[]{httpServletApi},
                new UnimplementedHandler());
    }
}


//public class SKHttpRequestHandler implements HttpHandler {
//
//    private static final String F_NAME = "fname";
//    private static final String L_NAME = "lname";
//
//    private static final int PARAM_NAME_IDX = 0;
//    private static final int PARAM_VALUE_IDX = 1;
//
//    private static final int HTTP_OK_STATUS = 200;
//
//    private static final String AND_DELIMITER = "&";
//    private static final String EQUAL_DELIMITER = "=";
//
//    public void handle(HttpExchange t) throws IOException {
//
//        //Create a response form the request query parameters
//        URI uri = t.getRequestURI();
//        String response = createResponseFromQueryParams(uri);
//        System.out.println("Response: " + response);
//        //Set the response header status and length
//        t.sendResponseHeaders(HTTP_OK_STATUS, response.getBytes().length);
//
//        SKServlet skServlet = new SKServlet();
//        skServlet.doGet(t.);
//        //Write the response string
//        OutputStream os = t.getResponseBody();
//        os.write(response.getBytes());
//        os.close();
//    }
//
//    /**
//     * Creates the response from query params.
//     *
//     * @param uri the uri
//     * @return the string
//     */
//    private String createResponseFromQueryParams(URI uri) {
//
//        String fName = "";
//        String lName = "";
//        //Get the request query
//        String query = uri.getQuery();
//        if (query != null) {
//            System.out.println("Query: " + query);
//            String[] queryParams = query.split(AND_DELIMITER);
//            if (queryParams.length > 0) {
//                for (String qParam : queryParams) {
//                    String[] param = qParam.split(EQUAL_DELIMITER);
//                    if (param.length > 0) {
//                        for (int i = 0; i < param.length; i++) {
//                            if (F_NAME.equalsIgnoreCase(param[PARAM_NAME_IDX])) {
//                                fName = param[PARAM_VALUE_IDX];
//                            }
//                            if (L_NAME.equalsIgnoreCase(param[PARAM_NAME_IDX])) {
//                                lName = param[PARAM_VALUE_IDX];
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        return "Hello, " + fName + " " + lName;
//    }
//}
