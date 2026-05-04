package httpserver.handlers;

import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;

public class ColeccionHandler extends BaseHandler {
    private static final String BASE_PATH = "/api/colecciones";

    @Override
    protected void handleRequest(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod().toUpperCase();
        String id = getPathId(exchange, BASE_PATH);
        switch (method) {
            case "GET"    -> sendOk(exchange, id == null
                ? "[{\"mensaje\":\"Lista de colecciones — conectar BD\"}]"
                : "{\"mensaje\":\"Colección " + id + " — conectar BD\"}");
            case "POST"   -> { String b = readBody(exchange);
                sendCreated(exchange, "{\"mensaje\":\"Colección creada — conectar BD\",\"recibido\":" + b + "}"); }
            case "PUT"    -> { if (id == null) { sendError(exchange, 400, "Se requiere ID"); return; }
                sendOk(exchange, "{\"mensaje\":\"Colección " + id + " actualizada — conectar BD\"}"); }
            case "DELETE" -> { if (id == null) { sendError(exchange, 400, "Se requiere ID"); return; }
                sendOk(exchange, "{\"mensaje\":\"Colección " + id + " eliminada — conectar BD\"}"); }
            default       -> sendMethodNotAllowed(exchange);
        }
    }
}
