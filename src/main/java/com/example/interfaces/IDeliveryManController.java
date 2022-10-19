package com.example.interfaces;

import java.util.List;

import com.example.models.DeliveryMan;

public interface IDeliveryManController {
    boolean create(DeliveryMan deliveryMan);
    List<DeliveryMan> list();
    DeliveryMan read(int delivery_man_nr);
    boolean update(int delivery_man_nr, DeliveryMan deliveryMan);
    boolean delete(int delivery_man_nr);
}
