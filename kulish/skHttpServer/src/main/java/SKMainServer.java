
public class SKMainServer {

    private static final int PORT = 8088;
    private static SKHttpRequestHandler mainHttpHandler = new SKHttpRequestHandler();

    public static void main(String[] args) throws Exception {

        if (!mainHttpHandler.loadServletMap()) {
            System.out.println("Started is not started. Is not loading ANY servlet");
            return;
        }
        // Create a new SimpleHttpServer
        SKHttpServer simpleHttpServer = new SKHttpServer(PORT, mainHttpHandler);

        // Start the server
        simpleHttpServer.start();
        System.out.println("Server is started and listening on port " + PORT);
    }
}