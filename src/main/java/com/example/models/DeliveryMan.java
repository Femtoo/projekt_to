package com.example.models;

public class DeliveryMan {
    private int id;
    private String name;
    private String last_name;
    private int delivery_man_nr;
    
    public DeliveryMan(int id, String name, String last_name, int delivery_man_nr) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.delivery_man_nr = delivery_man_nr;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public int getDelivery_man_nr() {
        return delivery_man_nr;
    }
    public void setDelivery_man_nr(int delivery_man_nr) {
        this.delivery_man_nr = delivery_man_nr;
    }
}
