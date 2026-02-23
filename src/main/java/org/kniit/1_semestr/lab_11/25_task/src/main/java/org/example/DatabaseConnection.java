package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
        }
        return connection;
    }
    private static final String CREATE_TABLE_SQL =
            "CREATE TABLE IF NOT EXISTS files (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "file_name TEXT NOT NULL," +
                    "file_binary BLOB NOT NULL" +
                    ")";

    public static void init() {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(CREATE_TABLE_SQL);

        } catch (Exception e) {
            throw new RuntimeException("Ошибка инициализации БД", e);
        }
    }
}
