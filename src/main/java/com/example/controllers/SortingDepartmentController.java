package com.example.controllers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.example.ConnectionProvider;
import com.example.interfaces.ISortingDepartmentController;
import com.example.models.SortingDepartment;

public class SortingDepartmentController implements ISortingDepartmentController{

    public boolean create(SortingDepartment sortingDepartment){
        String sql = "INSERT INTO sorting_department(department_nr, address) " +
            "VALUES(?,?)";

        if(!validate(sortingDepartment.getDepartment_nr()) == false){
            return false;
        }
        if (sortingDepartment.getDepartment_nr() <= 0) {
            return false;
        }

        try (Connection connection = ConnectionProvider.connect();
        PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, sortingDepartment.getDepartment_nr());
            statement.setString(2, sortingDepartment.getAddress());
            statement.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException e) {       
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<SortingDepartment> list() {
        List<SortingDepartment> sortingDepartments = new ArrayList<>();

        String sql = "SELECT department_nr, address " +
            "FROM sorting_department";

        try (Connection connection = ConnectionProvider.connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)){

            while (resultSet.next()) {
                sortingDepartments.add(new SortingDepartment(
                    resultSet.getInt("department_nr"),
                    resultSet.getString("address")
                ));
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return sortingDepartments;
    }

    public SortingDepartment read(int department_nr) {
        String sql = "SELECT  department_nr, address " +
            "FROM sorting_department " + 
            "WHERE department_nr = ?";

        SortingDepartment sortingDepartment = null;

        try (Connection connection = ConnectionProvider.connect();
        PreparedStatement statement  = connection.prepareStatement(sql)){
            
            statement.setInt(1,department_nr);
            ResultSet resultSet  = statement.executeQuery();
            
            if(resultSet.next()) {
                sortingDepartment = new SortingDepartment(
                    resultSet.getInt("department_nr"),
                    resultSet.getString("address")
                );
            }          
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return sortingDepartment;
    }

    public boolean update(int department_nr, SortingDepartment sortingDepartment) {
        String sql = "UPDATE sorting_department " + 
            "SET department_nr = ?, address = ? " + 
            "WHERE department_nr = ?";

        if(validate(department_nr) == false) {
            return false;
        }

        try (Connection connection = ConnectionProvider.connect();
        PreparedStatement statement  = connection.prepareStatement(sql)){
            
            statement.setInt(1, sortingDepartment.getDepartment_nr());
            statement.setString(2, sortingDepartment.getAddress());
            statement.setInt(3, department_nr);

            statement.executeUpdate();
            connection.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean delete(int department_nr) {
        String sql = "DELETE FROM sorting_department " +
            "WHERE department_nr = ?";

        if(validate(department_nr) == false) {
            return false;
        }

        try (Connection connection = ConnectionProvider.connect();
        PreparedStatement statement  = connection.prepareStatement(sql)){
            
            statement.setInt(1,department_nr);

            statement.executeUpdate();
            connection.close();
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean validate(int department_nr){
        if(read(department_nr) == null) {
            return false;
        }
        return true;
    }
}
