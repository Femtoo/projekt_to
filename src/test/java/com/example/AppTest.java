package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.example.controllers.DeliveryManController;
import com.example.models.DeliveryMan;

public class AppTest 
{
    DeliveryManController deliveryManController;

    @Before
    public void before(){
        deliveryManController = new DeliveryManController();
    }

    // DELIVERYMAN TESTS
    @Test
    public void shouldCorrectlyBehaveOnCreate()
    {
        // given
        DeliveryMan dMan = new DeliveryMan("Jacek", "dddd", -2);

        // when
        boolean result = deliveryManController.create(dMan);

        // then
        assertTrue(result);
    }

    @Test
    public void shouldCorrectlyBehaveOnCreateWhenAddedNull()
    {
        // given
        DeliveryMan dMan = new DeliveryMan(null, "dddd", -2);

        // when
        boolean result = deliveryManController.create(dMan);

        // then
        assertFalse(result);
    }

    @Test
    public void shouldCorrectlyBehaveOnRead()
    {
        // given
        DeliveryMan dMan = new DeliveryMan("Jacek", "dddd", 5);
        deliveryManController.create(dMan);

        // when
        DeliveryMan result = deliveryManController.read(5);

        // then
        assertNotNull(result);
    }

    @Test
    public void shouldCorrectlyBehaveOnReadWhenNotInDataBase()
    {
        // given
        

        // when
        DeliveryMan result = deliveryManController.read(-5);

        // then
        assertNull(result);
    }

    @Test
    public void shouldCorrectlyBehaveOnUpdate()
    {
        // given
        DeliveryMan dMan = new DeliveryMan("Karol", "AAA", 6);
        deliveryManController.create(dMan);
        DeliveryMan dManChanged = new DeliveryMan("Kamil", "DDDD", 6);

        // when
        boolean result = deliveryManController.update(6, dManChanged);
        DeliveryMan dManUpdated = deliveryManController.read(6);

        // then
        assertTrue(result);
        assertEquals("Kamil", dManUpdated.getName());
        assertEquals("DDDD", dManUpdated.getLast_name());
    }

    @Test
    public void shouldCorrectlyBehaveOnUpdateWhenNull()
    {
        // given

        // when
        boolean result = deliveryManController.update(6,null);

        // then
        assertFalse(result);
    }

    @Test
    public void shouldCorrectlyBehaveOnUpdateWhenNotInDB()
    {
        // given
        DeliveryMan dMan = new DeliveryMan("Karol", "AAA", 6);

        // when
        boolean result = deliveryManController.update(-3,dMan);

        // then
        assertFalse(result);
    }

    @Test
    public void shouldCorrectlyBehaveOnDelete()
    {
        // given
        DeliveryMan dMan = new DeliveryMan("Karol", "AAA", 6);
        deliveryManController.create(dMan);

        // when
        boolean result = deliveryManController.delete(6);

        // then
        assertTrue(result);
    }

    @Test
    public void shouldCorrectlyBehaveOnDeleteWhenNotInDB()
    {
        // given
        DeliveryMan dMan = new DeliveryMan("Karol", "AAA", 6);
        deliveryManController.create(dMan);

        // when
        boolean result = deliveryManController.delete(-7);

        // then
        assertFalse(result);
    }


}
