package com.example;

import com.example.models.DeliveryMan;
import java.sql.*;

public class DeliveryManController {
    
    // public static void connect() {
    //     Connection conn = null;
    //     try {
    //         // db parameters
    //         String url = "jdbc:sqlite:db/sorting_dep.sqlite";
    //         // create a connection to the database
    //         conn = DriverManager.getConnection(url);
            
    //         System.out.println("Connection to SQLite has been established.");
            
    //     } catch (SQLException e) {
    //         System.out.println(e.getMessage());
    //     } finally {
    //         try {
    //             if (conn != null) {
    //                 conn.close();
    //             }
    //         } catch (SQLException ex) {
    //             System.out.println(ex.getMessage());
    //         }
    //     }
    // }

    private Connection connect() {
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

    public void create() {

    }

    public DeliveryMan read() {

        return null;
    }

    public void update() {

    }

    public void delete() {

    }
}
