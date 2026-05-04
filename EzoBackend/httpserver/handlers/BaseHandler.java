package httpserver.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseHandler implements HttpHandler {

    @Override
    public final void handle(HttpExchange exchange) throws IOException {
        if ("OPTIONS".equalsIgnoreCase(exchange.getRequestMethod())) {
            setCorsHeaders(exchange);
            exchange.sendResponseHeaders(204, -1);
            return;
        }
        setCorsHeaders(exchange);
        handleRequest(exchange);
    }

    protected abstract void handleRequest(HttpExchange exchange) throws IOException;


    protected void sendJson(HttpExchange exchange, int statusCode, String json) throws IOException {
        byte[] bytes = json.getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
        exchange.sendResponseHeaders(statusCode, bytes.length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(bytes);
        }
    }

    protected void sendOk(HttpExchange exchange, String json) throws IOException {
        sendJson(exchange, 200, json);
    }

    protected void sendCreated(HttpExchange exchange, String json) throws IOException {
        sendJson(exchange, 201, json);
    }

    protected void sendError(HttpExchange exchange, int code, String mensaje) throws IOException {
        sendJson(exchange, code, "{\"error\":\"" + escaparJson(mensaje) + "\"}");
    }

    protected void sendNotFound(HttpExchange exchange) throws IOException {
        sendError(exchange, 404, "Recurso no encontrado");
    }

    protected void sendMethodNotAllowed(HttpExchange exchange) throws IOException {
        sendError(exchange, 405, "Método no permitido");
    }


    protected String readBody(HttpExchange exchange) throws IOException {
        try (InputStream is = exchange.getRequestBody()) {
            return new String(is.readAllBytes(), StandardCharsets.UTF_8);
        }
    }

    protected Map<String, String> getQueryParams(HttpExchange exchange) {
        Map<String, String> params = new HashMap<>();
        String query = exchange.getRequestURI().getRawQuery();
        if (query != null && !query.isEmpty()) {
            for (String par : query.split("&")) {
                String[] kv = par.split("=", 2);
                if (kv.length == 2) {
                    params.put(kv[0], kv[1]);
                } else {
                    params.put(kv[0], "");
                }
            }
        }
        return params;
    }

    protected String getPathId(HttpExchange exchange, String basePath) {
        String path = exchange.getRequestURI().getPath();
        String suffix = path.substring(basePath.length());
        if (suffix.startsWith("/")) suffix = suffix.substring(1);
        return suffix.isEmpty() ? null : suffix;
    }


    private void setCorsHeaders(HttpExchange exchange) {
        exchange.getResponseHeaders().set("Access-Control-Allow-Origin",  "*");
        exchange.getResponseHeaders().set("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        exchange.getResponseHeaders().set("Access-Control-Allow-Headers", "Content-Type, Authorization");
    }


    private String escaparJson(String text) {
        return text == null ? "" : text.replace("\"", "\\\"");
    }
}
