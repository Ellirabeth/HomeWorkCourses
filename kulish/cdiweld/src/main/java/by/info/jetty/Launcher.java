package by.info.jetty;

import javax.naming.InitialContext;
import javax.naming.Reference;

//import org.eclipse.jetty.plus.jndi.Resource;
//import org.eclipse.jetty.server.Server;
//import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Simple jetty launcher, which launches the webapplication from the local
 * resources and reuses the projects classpath.
 *
 * @author jos
 */
public class Launcher {

//    /** run under root context */
//    private static String contextPath = "/";
//    /** location where resources should be provided from for VAADIN resources */
//    private static String resourceBase = "src/main/webapp";
//    /** port to listen on */
//    private static int httpPort = 8081;
//
//    private static String[] __dftConfigurationClasses =
//            {
//                    "org.eclipse.jetty.webapp.WebInfConfiguration",
//                    "org.eclipse.jetty.webapp.WebXmlConfiguration",
//                    "org.eclipse.jetty.webapp.MetaInfConfiguration",
//                    "org.eclipse.jetty.webapp.FragmentConfiguration",
//                    "org.eclipse.jetty.plus.webapp.EnvConfiguration",
//                    "org.eclipse.jetty.webapp.JettyWebXmlConfiguration"
//            } ;
//
//    /**
//     * Start the server, and keep waiting.
//     */
//    public static void main(String[] args) throws Exception {
//
//        System.setProperty("java.naming.factory.url","org.eclipse.jetty.jndi");
//        System.setProperty("java.naming.factory.initial","org.eclipse.jetty.jndi.InitialContextFactory");
//
//        InitialContext ctx = new InitialContext();
//        ctx.createSubcontext("java:comp");
//
//        Server server = new Server(httpPort);
//        WebAppContext webapp = new WebAppContext();
//        webapp.setConfigurationClasses(__dftConfigurationClasses);
//
//        webapp.setDescriptor("src/main/webapp/WEB-INF/0web.xml0");
//        webapp.setContextPath(contextPath);
//        webapp.setResourceBase(resourceBase);
//        webapp.setClassLoader(Thread.currentThread().getContextClassLoader());
//
//        server.setHandler(webapp);
//        server.start();
//
//        new Resource("BeanManager", new Reference("javax.enterprise.inject.spi.BeanMnanager",
//                "org.jboss.weld.resources.ManagerObjectFactory", null));
//
//        server.join();
//    }
}