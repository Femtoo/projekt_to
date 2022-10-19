package com.example.controllers;

import com.example.ConnectionProvider;
import com.example.interfaces.IDeliveryManController;
import com.example.models.DeliveryMan;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeliveryManController implements IDeliveryManController{

    public boolean create(DeliveryMan deliveryMan) {
        String sql = "INSERT INTO delivery_man(name, last_name, delivery_man_nr) " +
            "VALUES(?,?,?)";

        try (Connection connection = ConnectionProvider.connect();
        PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, deliveryMan.getName());
            statement.setString(2, deliveryMan.getLast_name());
            statement.setInt(3, deliveryMan.getDelivery_man_nr());
            statement.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        
    }

    public List<DeliveryMan> list() {
        List<DeliveryMan> deliveryMans = new ArrayList<>();

        String sql = "SELECT name, last_name, delivery_man_nr " + 
            "FROM delivery_man";

        try (Connection connection = ConnectionProvider.connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){
            
            while (resultSet.next()) {
                deliveryMans.add(new DeliveryMan(
                    resultSet.getString("name"),
                    resultSet.getString("last_name"),
                    resultSet.getInt("delivery_man_nr")
                ));     
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return deliveryMans;
    }

    public DeliveryMan read(int delivery_man_nr) {

        String sql = "SELECT name, last_name, delivery_man_nr " +
            "FROM delivery_man WHERE delivery_man_nr = ?";
        DeliveryMan deliveryMan = null;

        try (Connection connection = ConnectionProvider.connect();
             PreparedStatement statement = connection.prepareStatement(sql)){
            
            statement.setInt(1,delivery_man_nr);

            ResultSet resultSet  = statement.executeQuery();
            
            if(resultSet.next()) {
                deliveryMan = new DeliveryMan(resultSet.getString("name"), 
                resultSet.getString("last_name"), 
                resultSet.getInt("delivery_man_nr"));
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return deliveryMan;
    }

    public boolean update(int delivery_man_nr, DeliveryMan deliveryMan) {

        String sql = "UPDATE delivery_man " +
            "SET name = ?, last_name = ? " +
            "WHERE delivery_man_nr = ?";

        if(validate(delivery_man_nr) == false) {
            return false;
        }

        try (Connection connection = ConnectionProvider.connect();

            PreparedStatement statement = connection.prepareStatement(sql)){
            
            statement.setString(1,deliveryMan.getName());
            statement.setString(2,deliveryMan.getLast_name());
            statement.setInt(3,deliveryMan.getDelivery_man_nr());

            statement.executeUpdate();
            connection.close();
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean delete(int delivery_man_nr) {

        String sql = "DELETE FROM delivery_man " +
            "WHERE delivery_man_nr = ?";

        if(validate(delivery_man_nr) == false) {
            return false;
        }

        try (Connection connection = ConnectionProvider.connect();
            PreparedStatement statement  = connection.prepareStatement(sql)){
            
            statement.setInt(1,delivery_man_nr);

            statement.executeUpdate();
            connection.close();
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean validate(int delivery_man_nr){
        if(read(delivery_man_nr) == null) {
            return false;
        }
        return true;
    }
}
