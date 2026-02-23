package org.example;

import java.sql.*;

public class DatabaseConnection {

    private static final String URL = "jdbc:sqlite:my_database.db";
    private static Connection connection;

    private DatabaseConnection() throws ClassNotFoundException {

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("SQLite JDBC driver not found", e);
        }
    }


    public static Connection getConnection() throws SQLException {
        
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL);
            init();
        }
        return connection;
    }

    private static void init() throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS users (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    email TEXT NOT NULL UNIQUE
                );
                """;
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        }
    }
}
