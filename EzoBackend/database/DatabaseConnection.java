package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {

    private static final String HOST     = "localhost";
    private static final int    DB_PORT  = 5432;
    private static final String DB_NAME  = "eze_db";
    private static final String USER     = "postgres";
    private static final String PASSWORD = "";

    private static final String URL = String.format(
        "jdbc:postgresql://%s:%d/%s", HOST, DB_PORT, DB_NAME
    );

    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("[DB] Conexión a PostgreSQL establecida → " + DB_NAME);
            } catch (ClassNotFoundException e) {
                throw new SQLException(
                    "[DB] Driver PostgreSQL no encontrado. " +
                    "Asegúrate de incluir postgresql-42.x.x.jar en el classpath.", e
                );
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                    System.out.println("[DB] Conexión cerrada.");
                }
            } catch (SQLException e) {
                System.err.println("[DB] Error al cerrar la conexión: " + e.getMessage());
            } finally {
                connection = null;
            }
        }
    }

    public static boolean testConnection() {
        try {
            getConnection();
            return true;
        } catch (SQLException e) {
            System.err.println("[DB] No se pudo conectar: " + e.getMessage());
            return false;
        }
    }

    private DatabaseConnection() {}
}
