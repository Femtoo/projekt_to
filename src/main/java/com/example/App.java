package com.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        DeliveryManController dmc = new DeliveryManController();
        dmc.create("proba", "proba", 100202);
    }
}
