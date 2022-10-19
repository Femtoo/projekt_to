package com.example;

import com.example.models.DeliveryMan;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeliveryManController {

    public boolean create(String name, String last_name, int delivery_man_nr) {
        String sql = "INSERT INTO delivery_man(name,last_name,delivery_man_nr) VALUES(?,?,?)";

        DeliveryMan deliveryMan = new DeliveryMan(name, last_name, delivery_man_nr);

        try (Connection conn = ConnectionProvider.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, deliveryMan.getName());
            pstmt.setString(2, deliveryMan.getLast_name());
            pstmt.setInt(3, deliveryMan.getDelivery_man_nr());
            pstmt.executeUpdate();
            //System.out.println("Succesfully added to db");
            conn.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        
    }

    public List<DeliveryMan> readAll() {
        List<DeliveryMan> deliveryMans = new ArrayList<>();

        String sql = "SELECT name, last_name, delivery_man_nr FROM delivery_man";

        try (Connection conn = ConnectionProvider.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                deliveryMans.add(new DeliveryMan(rs.getString("name"),
                                                rs.getString("last_name"),
                                                rs.getInt("delivery_man_nr")));
                //System.out.println(rs.getString("name") + " " + rs.getString("last_name") + " " + rs.getInt("delivery_man_nr"));
                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return deliveryMans;
    }

    public DeliveryMan read(int id) {

        String sql = "SELECT name, last_name, delivery_man_nr FROM delivery_man WHERE delivery_man_nr = ?";
        DeliveryMan dm = null;

        try (Connection conn = ConnectionProvider.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){
            
            // set the value
            pstmt.setInt(1,id);
            //
            ResultSet rs  = pstmt.executeQuery();
            
            if(rs.next()) {
                dm = new DeliveryMan(rs.getString("name"), 
                                rs.getString("last_name"), 
                                rs.getInt("delivery_man_nr"));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dm;
    }

    public boolean update(String name, String last_name, int delivery_man_nr) {

        String sql = "UPDATE delivery_man SET name = ?, last_name = ? WHERE delivery_man_nr = ?";
        DeliveryMan dm = new DeliveryMan(name, last_name, delivery_man_nr);

        if(read(delivery_man_nr) == null) {
            return false;
        }

        try (Connection conn = ConnectionProvider.connect();

            PreparedStatement pstmt  = conn.prepareStatement(sql)){
            
            // set the value
            pstmt.setString(1,dm.getName());
            pstmt.setString(2,dm.getLast_name());
            pstmt.setInt(3,dm.getDelivery_man_nr());
            //
            pstmt.executeUpdate();
            
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean delete(int delivery_man_nr) {

        String sql = "DELETE FROM delivery_man WHERE delivery_man_nr = ?";

        if(read(delivery_man_nr) == null) {
            return false;
        }

        try (Connection conn = ConnectionProvider.connect();

            PreparedStatement pstmt  = conn.prepareStatement(sql)){
            
            // set the value
            
            pstmt.setInt(1,delivery_man_nr);
            //
            pstmt.executeUpdate();
            
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
