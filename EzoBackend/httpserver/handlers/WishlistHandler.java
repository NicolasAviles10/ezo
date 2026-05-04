package httpserver.handlers;

import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;

public class WishlistHandler extends BaseHandler {
    private static final String BASE_PATH = "/api/wishlist";

    @Override
    protected void handleRequest(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod().toUpperCase();
        String id = getPathId(exchange, BASE_PATH);
        switch (method) {
            case "GET"    -> sendOk(exchange, id == null
                ? "[{\"mensaje\":\"Lista de wishlist — conectar BD\"}]"
                : "{\"mensaje\":\"Wishlist " + id + " — conectar BD\"}");
            case "POST"   -> { String b = readBody(exchange);
                sendCreated(exchange, "{\"mensaje\":\"Item añadido a wishlist — conectar BD\",\"recibido\":" + b + "}"); }
            case "DELETE" -> { if (id == null) { sendError(exchange, 400, "Se requiere ID"); return; }
                sendOk(exchange, "{\"mensaje\":\"Item " + id + " eliminado de wishlist — conectar BD\"}"); }
            default       -> sendMethodNotAllowed(exchange);
        }
    }
}
