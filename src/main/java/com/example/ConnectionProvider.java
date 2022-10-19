package com.example;

import java.sql.*;

public class ConnectionProvider {
    
    public static Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:db/sorting_dep.sqlite";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
