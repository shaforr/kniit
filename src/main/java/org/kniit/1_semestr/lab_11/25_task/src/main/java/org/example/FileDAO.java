package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FileDAO {


    public void saveFile(File file) throws SQLException, IOException {

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO files (file_name, file_binary) VALUES (?, ?)");
             FileInputStream fis = new FileInputStream(file)) {

            ps.setString(1, file.getName());
            ps.setBytes(2, fis.readAllBytes());

            ps.executeUpdate();
        }
    }
}
