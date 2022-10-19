package com.example;

import java.sql.*;

public class ConnectionProvider {
    
    public static Connection connect() {
        String url = "jdbc:sqlite:db/sorting_dep.sqlite";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
