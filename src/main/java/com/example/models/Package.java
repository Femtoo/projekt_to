package com.example.models;

public class Package {
    private int package_nr;
    private String sender;
    private String receiver;
    private String address;
    private long incoming_date;
    private int pick_up_delivery_man_id;
    private int delivering_delivery_man_id;
    private int sorting_department_id;
    
    public Package(int package_nr, String sender, String receiver, String address, long incoming_date,
            int pick_up_delivery_man_id, int delivering_delivery_man_id, int sorting_department_id) {
        this.package_nr = package_nr;
        this.sender = sender;
        this.receiver = receiver;
        this.address = address;
        this.incoming_date = incoming_date;
        this.pick_up_delivery_man_id = pick_up_delivery_man_id;
        this.delivering_delivery_man_id = delivering_delivery_man_id;
        this.sorting_department_id = sorting_department_id;
    }
    public int getPackage_nr() {
        return package_nr;
    }
    public void setPackage_nr(int package_nr) {
        this.package_nr = package_nr;
    }
    public String getSender() {
        return sender;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }
    public String getReceiver() {
        return receiver;
    }
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public long getIncoming_date() {
        return incoming_date;
    }
    public void setIncoming_date(long incoming_date) {
        this.incoming_date = incoming_date;
    }
    public int getPick_up_delivery_man_id() {
        return pick_up_delivery_man_id;
    }
    public void setPick_up_delivery_man_id(int pick_up_delivery_man_id) {
        this.pick_up_delivery_man_id = pick_up_delivery_man_id;
    }
    public int getDelivering_delivery_man_id() {
        return delivering_delivery_man_id;
    }
    public void setDelivering_delivery_man_id(int delivering_delivery_man_id) {
        this.delivering_delivery_man_id = delivering_delivery_man_id;
    }
    public int getSorting_department_id() {
        return sorting_department_id;
    }
    public void setSorting_department_id(int sorting_department_id) {
        this.sorting_department_id = sorting_department_id;
    }
    
}
