package lt.sdacademy.university.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionService {

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                    System.getenv("DB_URL"),
                    System.getenv("DB_USER"),
                    System.getenv("DB_PASSWORD")
                );
            } catch (SQLException exception) {
                throw new RuntimeException(exception);
            }
        }

        return connection;
    }

    private ConnectionService() {
    }
}
