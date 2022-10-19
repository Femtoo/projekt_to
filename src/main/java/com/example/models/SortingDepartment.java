package com.example.models;

public class SortingDepartment {
    private int department_nr;
    private String address;
    
    public SortingDepartment(int department_nr, String address) {
        this.department_nr = department_nr;
        this.address = address;
    }
    public int getDepartment_nr() {
        return department_nr;
    }
    public void setDepartment_nr(int department_nr) {
        this.department_nr = department_nr;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }   
}
