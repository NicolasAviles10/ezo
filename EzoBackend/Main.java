import httpserver.AppHttpServer;

public class Main {

    public static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            AppHttpServer server = new AppHttpServer(PORT);
            server.start();
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║     GameStore Backend iniciado       ║");
            System.out.println("║  http://localhost:" + PORT + "              ║");
            System.out.println("╚══════════════════════════════════════╝");
            System.out.println("\nEndpoints disponibles:");
            System.out.println("  GET/POST   /api/usuarios");
            System.out.println("  GET/POST   /api/articulos");
            System.out.println("  GET/POST   /api/intercambios");
            System.out.println("  GET/POST   /api/copias");
            System.out.println("  GET/POST   /api/wishlist");
            System.out.println("  GET/POST   /api/mensajes");

            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                server.stop();
                System.out.println("Servidor detenido.");
            }));

        } catch (Exception e) {
            System.err.println("Error al iniciar el servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
