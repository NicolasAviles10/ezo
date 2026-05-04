package httpserver;

import com.sun.net.httpserver.HttpServer;
import httpserver.handlers.*;

public class Router {

    private static final String BASE = "/api";

    public static void registerRoutes(HttpServer server) {
        server.createContext(BASE + "/usuarios",     new UsuarioHandler());

        server.createContext(BASE + "/articulos",    new ArticuloHandler());

        server.createContext(BASE + "/copias",       new CopiaHandler());

        server.createContext(BASE + "/intercambios", new IntercambioHandler());

        server.createContext(BASE + "/wishlist",     new WishlistHandler());

        server.createContext(BASE + "/mensajes",     new MensajeHandler());

        server.createContext(BASE + "/colecciones",  new ColeccionHandler());

        server.createContext(BASE + "/facturas",     new FacturaHandler());

        System.out.println("[Router] Rutas registradas bajo " + BASE);
    }
}
