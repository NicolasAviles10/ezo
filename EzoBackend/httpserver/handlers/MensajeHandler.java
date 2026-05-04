package httpserver.handlers;

import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;

public class MensajeHandler extends BaseHandler {
    private static final String BASE_PATH = "/api/mensajes";

    @Override
    protected void handleRequest(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod().toUpperCase();
        String id = getPathId(exchange, BASE_PATH);
        switch (method) {
            case "GET"  -> sendOk(exchange, id == null
                ? "[{\"mensaje\":\"Lista de mensajes — conectar BD\"}]"
                : "{\"mensaje\":\"Mensaje " + id + " — conectar BD\"}");
            case "POST" -> { String b = readBody(exchange);
                sendCreated(exchange, "{\"mensaje\":\"Mensaje enviado — conectar BD\",\"recibido\":" + b + "}"); }
            default     -> sendMethodNotAllowed(exchange);
        }
    }
}
