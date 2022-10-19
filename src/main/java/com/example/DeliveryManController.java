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

    public void create(String name, String last_name, int delivery_man_nr) {
        String sql = "INSERT INTO delivery_man(name,last_name,delivery_man_nr) VALUES(?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, last_name);
            pstmt.setInt(3, delivery_man_nr);
            pstmt.executeUpdate();
            System.out.println("Succesfully added to db");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public DeliveryMan read() {

        return null;
    }

    public void update() {

    }

    public void delete() {

    }
}
