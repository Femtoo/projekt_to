package com.example;

import java.util.ArrayList;
import java.util.List;

import com.example.models.DeliveryMan;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        DeliveryManController dmc = new DeliveryManController();
        // List<DeliveryMan> dms = new ArrayList<>();
        // dms = dmc.readAll();
        //DeliveryMan dm = dmc.read(100512);
        //System.out.println(dm.getName() + " " + dm.getLast_name());
        //System.out.print(dms.get(0));
        //System.out.print(dmc.update("proba2", "proba2", 100202));
        //dmc.update("proba2", "proba2", 100202);
        dmc.delete(100202);
    }
}
