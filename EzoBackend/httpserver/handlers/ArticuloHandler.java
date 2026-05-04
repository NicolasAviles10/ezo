package httpserver.handlers;

import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.util.Map;


public class ArticuloHandler extends BaseHandler {

    private static final String BASE_PATH = "/api/articulos";

    @Override
    protected void handleRequest(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod().toUpperCase();
        String id = getPathId(exchange, BASE_PATH);

        switch (method) {
            case "GET"    -> handleGet(exchange, id);
            case "POST"   -> handlePost(exchange);
            case "PUT"    -> handlePut(exchange, id);
            case "DELETE" -> handleDelete(exchange, id);
            default       -> sendMethodNotAllowed(exchange);
        }
    }

    private void handleGet(HttpExchange exchange, String id) throws IOException {
        if (id == null) {
            Map<String, String> params = getQueryParams(exchange);
            // TODO: ArticuloDAO.getAll(params)
            sendOk(exchange, "[{\"mensaje\":\"Lista de artículos — conectar BD\",\"filtros\":" + params.toString() + "}]");
        } else {
            // TODO: ArticuloDAO.getById(id)
            sendOk(exchange, "{\"mensaje\":\"Artículo " + id + " — conectar BD\"}");
        }
    }

    private void handlePost(HttpExchange exchange) throws IOException {
        String body = readBody(exchange);
        if (body.isBlank()) { sendError(exchange, 400, "El body no puede estar vacío"); return; }
        // TODO: ArticuloDAO.create(body)
        sendCreated(exchange, "{\"mensaje\":\"Artículo creado — conectar BD\",\"recibido\":" + body + "}");
    }

    private void handlePut(HttpExchange exchange, String id) throws IOException {
        if (id == null) { sendError(exchange, 400, "Se requiere un ID"); return; }
        String body = readBody(exchange);
        // TODO: ArticuloDAO.update(id, body)
        sendOk(exchange, "{\"mensaje\":\"Artículo " + id + " actualizado — conectar BD\"}");
    }

    private void handleDelete(HttpExchange exchange, String id) throws IOException {
        if (id == null) { sendError(exchange, 400, "Se requiere un ID"); return; }
        // TODO: ArticuloDAO.delete(id)
        sendOk(exchange, "{\"mensaje\":\"Artículo " + id + " eliminado — conectar BD\"}");
    }
}
