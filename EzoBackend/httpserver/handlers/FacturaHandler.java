package httpserver.handlers;

import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;

public class FacturaHandler extends BaseHandler {
    private static final String BASE_PATH = "/api/facturas";

    @Override
    protected void handleRequest(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod().toUpperCase();
        String id = getPathId(exchange, BASE_PATH);
        switch (method) {
            case "GET"  -> sendOk(exchange, id == null
                ? "[{\"mensaje\":\"Lista de facturas — conectar BD\"}]"
                : "{\"mensaje\":\"Factura " + id + " — conectar BD\"}");
            case "POST" -> { String b = readBody(exchange);
                sendCreated(exchange, "{\"mensaje\":\"Factura generada — conectar BD\",\"recibido\":" + b + "}"); }
            default     -> sendMethodNotAllowed(exchange);
        }
    }
}
