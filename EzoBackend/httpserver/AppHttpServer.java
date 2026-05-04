package httpserver;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;


public class AppHttpServer {

    private final int port;
    private HttpServer server;

    public AppHttpServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        server = HttpServer.create(new InetSocketAddress(port), 0);
        Router.registerRoutes(server);
        server.setExecutor(Executors.newFixedThreadPool(10));
        server.start();
    }
    
    public void stop() {
        if (server != null) {
            server.stop(0);
        }
    }
}
