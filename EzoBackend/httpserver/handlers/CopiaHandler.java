package httpserver.handlers;

import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;


public class CopiaHandler extends BaseHandler {

    private static final String BASE_PATH = "/api/copias";

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
            // TODO: CopiaDAO.getAll() — filtrar por usuario, articulo, estado
            sendOk(exchange, "[{\"mensaje\":\"Lista de copias — conectar BD\"}]");
        } else {
            // TODO: CopiaDAO.getById(id)
            sendOk(exchange, "{\"mensaje\":\"Copia " + id + " — conectar BD\"}");
        }
    }

    private void handlePost(HttpExchange exchange) throws IOException {
        String body = readBody(exchange);
        if (body.isBlank()) { sendError(exchange, 400, "El body no puede estar vacío"); return; }
        // TODO: CopiaDAO.create(body)
        sendCreated(exchange, "{\"mensaje\":\"Copia registrada — conectar BD\",\"recibido\":" + body + "}");
    }

    private void handlePut(HttpExchange exchange, String id) throws IOException {
        if (id == null) { sendError(exchange, 400, "Se requiere un ID"); return; }
        String body = readBody(exchange);
        // TODO: CopiaDAO.update(id, body)
        sendOk(exchange, "{\"mensaje\":\"Copia " + id + " actualizada — conectar BD\"}");
    }

    private void handleDelete(HttpExchange exchange, String id) throws IOException {
        if (id == null) { sendError(exchange, 400, "Se requiere un ID"); return; }
        // TODO: CopiaDAO.delete(id)
        sendOk(exchange, "{\"mensaje\":\"Copia " + id + " eliminada — conectar BD\"}");
    }
}
