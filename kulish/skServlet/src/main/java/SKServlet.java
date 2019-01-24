import io.swagger.config.ConfigFactory;
import io.swagger.config.SwaggerConfig;
import io.swagger.jaxrs.config.BeanConfig;
import model.User;

import javax.enterprise.inject.spi.CDI;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(name = "Get Thread", urlPatterns = {"/app"})
public class SKServlet extends HttpServlet {

//        @Inject
//        ICityService cityService;

    @Override
    public void init() throws ServletException {
//        BeanConfig beanConfig = new BeanConfig();
//        beanConfig.setVersion("1.0.2");
//        beanConfig.setSchemes(new String[]{"http"});
//        beanConfig.setHost("localhost:8002");
//        beanConfig.setBasePath("/api");
//        beanConfig.setResourcePackage("io.swagger.resources");
//        beanConfig.setScan(true);

//        SwaggerConfig swaggerConfig = new SwaggerConfig();
//        ConfigFactory.setConfig(swaggerConfig);
//        swaggerConfig.setBasePath("http://localhost:8002");
//        swaggerConfig.setApiVersion("1.0.0");
//        ScannerFactory.setScanner(new DefaultJaxrsScanner());
//        ClassReaders.setReader(new DefaultJaxrsApiReader());

//        Map<String, String> params = new HashMap<String, String>();
//        params.put("com.sun.jersey.config.property.packages", "io.swagger.jaxrs.json;io.swagger.jaxrs.listing;com.nikhil.sample.rest");
//        serve("/api/*").with(Bootstrap.class, params);
        //        filter("/api/*").through(Bootstrap.class, params);

        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8088");
        beanConfig.setBasePath("/data");
//        beanConfig.setResourcePackage("com.nikhil.sample.rest");
        beanConfig.setScan(true);
//        bind(Bootstrap.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/plain");
        go(response.getWriter(), false);

        //List<City> cities = cityService.getCities();
        //request.setAttribute("cities", cities);

        //RequestDispatcher dispatcher = request.getRequestDispatcher("listCities.jsp");
        //dispatcher.forward(request, response);
//            ServletOutputStream out = response.getOutputStream();
//
//            out.print("This is MyServlet");
    }

    public static void main(String[] args) throws IOException, ServletException {
        //RmiServer rmiServer = RmiServer.getInstance();

//        SKServlet servlet = CDI.current().select(SKServlet.class).get();
        SKServlet servlet = new SKServlet();
        servlet.init();
        servlet.go(System.out, true);
    }

    private void go(Appendable writer, boolean isLocal) throws IOException {
        SKRmiClient client = new SKRmiClient(isLocal);

        User usr = new User();
        usr.setName("admin");
        usr.setPasswd("4444");
        User resUser;
        Thread thread = Thread.currentThread();

        writer.append("Thread=").append(thread.toString()).append(" ").append(thread.getName());
        try {
            resUser = client.addUser(usr);
//            response.setContentType("application/html;charset=UTF-8");

            writer.append("User=").append(resUser.toString());
        } catch (Exception e) {
            writer.append(e.getMessage());
        }
    }
}