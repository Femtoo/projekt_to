package com.example.controllers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.example.ConnectionProvider;
import com.example.interfaces.IPackageController;
import com.example.models.Package;

public class PackageController implements IPackageController{

    public boolean create(Package pack){
        String sql = "INSERT INTO package(package_nr,sender,receiver,address,incoming_date,pick_up_delivery_man_id,delivering_delivery_man_id,sorting_department_id) " +
            "VALUES(?,?,?,?,?,?,?,?)";

        if(validate(pack.getPick_up_delivery_man_id(), pack.getDelivering_delivery_man_id(), pack.getSorting_department_id()) == false){
            return false;
        }
        if(!validate(pack.getPackage_nr()) == false){
            return false;
        }

        try (Connection connection = ConnectionProvider.connect();
        PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, pack.getPackage_nr());
            statement.setString(2, pack.getSender());
            statement.setString(3, pack.getReceiver());
            statement.setString(4, pack.getAddress());
            statement.setLong(5, pack.getIncoming_date());
            statement.setInt(6, pack.getPick_up_delivery_man_id());
            statement.setInt(7, pack.getDelivering_delivery_man_id());
            statement.setInt(8, pack.getSorting_department_id());
            statement.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException e) {       
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<Package> list() {
        List<Package> packages = new ArrayList<>();

        String sql = "SELECT package_nr, sender, receiver, address, incoming_date, pick_up_delivery_man_id, delivering_delivery_man_id, sorting_department_id " +
            "FROM package";

        try (Connection connection = ConnectionProvider.connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)){
            
            while (resultSet.next()) {
                packages.add(new Package(
                    resultSet.getInt("package_nr"),
                    resultSet.getString("sender"),
                    resultSet.getString("receiver"),
                    resultSet.getString("address"),
                    resultSet.getLong("incoming_date"),
                    resultSet.getInt("pick_up_delivery_man_id"),
                    resultSet.getInt("delivering_delivery_man_id"),
                    resultSet.getInt("sorting_department_id")
                ));
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return packages;
    }

    public Package read(int package_nr) {
        String sql = "SELECT package_nr, sender, receiver, address, incoming_date, pick_up_delivery_man_id, delivering_delivery_man_id, sorting_department_id " +
            "FROM package " + 
            "WHERE package_nr = ?";

        Package pack = null;

        try (Connection connection = ConnectionProvider.connect();
        PreparedStatement statement  = connection.prepareStatement(sql)){
            
            statement.setInt(1,package_nr);

            ResultSet resultSet  = statement.executeQuery();
            
            if(resultSet.next()) {
                pack = new Package(
                    resultSet.getInt("package_nr"),
                    resultSet.getString("sender"),
                    resultSet.getString("receiver"),
                    resultSet.getString("address"),
                    resultSet.getLong("incoming_date"),
                    resultSet.getInt("pick_up_delivery_man_id"),
                    resultSet.getInt("delivering_delivery_man_id"),
                    resultSet.getInt("sorting_department_id")
                );
            }          
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return pack;
    }

    public boolean update(int package_nr, Package pack) {
        String sql = "UPDATE package " + 
            "SET sender = ?, receiver = ?, address = ?, incoming_date = ?, pick_up_delivery_man_id = ?, delivering_delivery_man_id = ?, sorting_department_id = ? " + 
            "WHERE package_nr = ?";

        if(validate(package_nr) == false) {
            return false;
        }

        try (Connection connection = ConnectionProvider.connect();
        PreparedStatement statement  = connection.prepareStatement(sql)){
            
            statement.setString(1, pack.getSender());
            statement.setString(2, pack.getReceiver());
            statement.setString(3, pack.getAddress());
            statement.setLong(4, pack.getIncoming_date());
            statement.setInt(5, pack.getPick_up_delivery_man_id());
            statement.setInt(6, pack.getDelivering_delivery_man_id());
            statement.setInt(7, pack.getSorting_department_id());
            statement.setInt(8, pack.getPackage_nr());

            statement.executeUpdate();
            connection.close();
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean delete(int package_nr) {
        String sql = "DELETE FROM package " +
            "WHERE package_nr = ?";

        if(validate(package_nr) == false) {
            return false;
        }

        try (Connection connection = ConnectionProvider.connect();
        PreparedStatement statement  = connection.prepareStatement(sql)){
            
            statement.setInt(1,package_nr);

            statement.executeUpdate();
            connection.close();
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean validate(int package_nr){
        if(read(package_nr) == null) {
            return false;
        }
        return true;
    }

    private boolean validate(int pick_up_delivery_man_id, int delivering_delivery_man_id, int sorting_department_id){
        SortingDepartmentController sortingDepartmentController = new SortingDepartmentController();
        DeliveryManController deliveryManController = new DeliveryManController();

        if(sortingDepartmentController.read(sorting_department_id) == null
            || deliveryManController.read(delivering_delivery_man_id) == null
            || deliveryManController.read(pick_up_delivery_man_id) == null){
                return false;
        }
        return true;
    }
}
