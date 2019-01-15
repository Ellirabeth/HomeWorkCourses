package by.info.app;

import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.weld.environment.undertow.UndertowContainer;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws ServletException {
//        DeploymentInfo servletBuilder = Servlets.deployment()
//
//                .setClassLoader(Main.class.getClassLoader())
//
//                .setResourceManager(new ClassPathResourceManager(Main.class.getClassLoader()))
//
//                .setContextPath("/")
//
//                .setDeploymentName("test.war")
//
//                .addServlet(Servlets.servlet("hello", HelloWorldServlet.class).addMapping("/*"))
//
//
//                .addListener(Servlets.listener(Listener.class));
//
//
//        DeploymentManager manager = Servlets.defaultContainer().addDeployment(servletBuilder);
//
//        manager.deploy();
//
//
//        HttpHandler servletHandler = manager.start();
//
//        PathHandler path = Handlers.path(Handlers.redirect("/")).addPrefixPath("/", servletHandler);
//
//        Undertow server = Undertow.builder().addHttpListener(8080, "localhost").setHandler(path).build();
//
//        server.start();
    }

    public static class HelloWorldServlet extends HttpServlet {

        @Inject
        BeanManager manager;

        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            resp.setContentType("text/plain");

            resp.getWriter().append("Hello from " + manager);
        }
    }

}