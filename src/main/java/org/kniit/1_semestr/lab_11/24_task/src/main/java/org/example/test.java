package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class test {


    public static void main(String[] args) throws Exception {
        Connection c = DriverManager.getConnection("jdbc:sqlite:my_database.db");
        System.out.println("Подключение успешно");
        c.close();
    }
}

