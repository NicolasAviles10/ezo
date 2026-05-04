package httpserver.handlers;

import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;


public class IntercambioHandler extends BaseHandler {

    private static final String BASE_PATH = "/api/intercambios";

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
            // TODO: IntercambioDAO.getAll()
            sendOk(exchange, "[{\"mensaje\":\"Lista de intercambios — conectar BD\"}]");
        } else {
            // TODO: IntercambioDAO.getByIdConDetalle(id)
            sendOk(exchange, "{\"mensaje\":\"Intercambio " + id + " con detalle — conectar BD\"}");
        }
    }

    
    private void handlePost(HttpExchange exchange) throws IOException {
        String body = readBody(exchange);
        if (body.isBlank()) { sendError(exchange, 400, "El body no puede estar vacío"); return; }
        // TODO: IntercambioDAO.create(body)
        sendCreated(exchange, "{\"mensaje\":\"Intercambio creado — conectar BD\",\"recibido\":" + body + "}");
    }

        private void handlePut(HttpExchange exchange, String id) throws IOException {
        if (id == null) { sendError(exchange, 400, "Se requiere el ID del intercambio"); return; }
        String body = readBody(exchange);
        // TODO: IntercambioDAO.updateEstado(id, body)
        sendOk(exchange, "{\"mensaje\":\"Estado del intercambio " + id + " actualizado — conectar BD\"}");
    }

    private void handleDelete(HttpExchange exchange, String id) throws IOException {
        if (id == null) { sendError(exchange, 400, "Se requiere el ID del intercambio"); return; }
        // TODO: IntercambioDAO.cancelar(id)
        sendOk(exchange, "{\"mensaje\":\"Intercambio " + id + " cancelado — conectar BD\"}");
    }
}
