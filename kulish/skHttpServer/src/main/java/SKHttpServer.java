import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @author ashraf
 *
 */
@SuppressWarnings("restriction")
public class SKHttpServer {

    private HttpServer httpServer;

    /**
     * Instantiates a new simple http server.
     *
     * @param port the port
     * @param handler the handler
     */
    public SKHttpServer(int port, HttpHandler handler) {
        try {
            //Create HttpServer which is listening on the given port
            httpServer = HttpServer.create(new InetSocketAddress(port), 0);
            //Create a new context for the given context and handler
            httpServer.createContext("/", handler);
            //Create a default executor
            httpServer.setExecutor(null);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Start.
     */
    public void start() {
        this.httpServer.start();
    }

}