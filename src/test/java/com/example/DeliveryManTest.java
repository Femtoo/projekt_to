package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.example.controllers.DeliveryManController;
import com.example.models.DeliveryMan;

public class DeliveryManTest {
    DeliveryManController deliveryManController;

    @Before
    public void before() {
        deliveryManController = new DeliveryManController();
    }

    // DELIVERYMAN TESTS
    @Test
    public void shouldCorrectlyBehaveOnCreate() {
        // given
        DeliveryMan dMan = new DeliveryMan("Feliks", "Majewski", 100);

        // when
        boolean result = deliveryManController.create(dMan);

        // then
        assertTrue(result);
    }

    @Test
    public void shouldCorrectlyBehaveOnCreateCase2() {
        // given
        DeliveryMan dMan = new DeliveryMan("Atanazy", "Hajduk", 101);

        // when
        boolean result = deliveryManController.create(dMan);

        // then
        assertTrue(result);
    }

    @Test
    public void shouldCorrectlyBehaveOnCreateWhenAddedNull() {
        // given
        DeliveryMan dMan = new DeliveryMan(null, "Zwoliński", 102);

        // when
        boolean result = deliveryManController.create(dMan);

        // then
        assertFalse(result);
    }

    @Test
    public void shouldCorrectlyBehaveOnCreateWhenAddedNegativeIndex() {
        // given
        DeliveryMan dMan = new DeliveryMan("Feliks", "Zwoliński", -1);

        // when
        boolean result = deliveryManController.create(dMan);

        // then
        assertFalse(result);
    }

    @Test
    public void shouldCorrectlyBehaveOnRead() {
        // given
        DeliveryMan dMan = new DeliveryMan("Gilbert", "Bogusz", 103);
        deliveryManController.create(dMan);

        // when
        DeliveryMan result = deliveryManController.read(103);

        // then
        assertNotNull(result);
    }

    @Test
    public void shouldCorrectlyBehaveOnReadCase2() {
        // given
        DeliveryMan dMan = new DeliveryMan("Maksymilian", "Cebula", 104);
        deliveryManController.create(dMan);

        // when
        DeliveryMan result = deliveryManController.read(104);

        // then
        assertNotNull(result);
    }

    @Test
    public void shouldCorrectlyBehaveOnReadWhenNotInDataBase() {
        // given

        // when
        DeliveryMan result = deliveryManController.read(1000);

        // then
        assertNull(result);
    }

    @Test
    public void shouldCorrectlyBehaveOnUpdate() {
        // given
        DeliveryMan dMan = new DeliveryMan("Cecyliusz", "Kapusta", 105);
        deliveryManController.create(dMan);
        DeliveryMan dManChanged = new DeliveryMan("Eugeniusz", "Gruszka", 105);

        // when
        boolean result = deliveryManController.update(105, dManChanged);
        DeliveryMan dManUpdated = deliveryManController.read(105);

        // then
        assertTrue(result);
        assertEquals("Eugeniusz", dManUpdated.getName());
        assertEquals("Gruszka", dManUpdated.getLast_name());
    }

    @Test
    public void shouldCorrectlyBehaveOnUpdateCase2() {
        // given
        DeliveryMan dMan = new DeliveryMan("Gilbert", "Zając", 106);
        deliveryManController.create(dMan);
        DeliveryMan dManChanged = new DeliveryMan("Gabriel", "Czech", 106);

        // when
        boolean result = deliveryManController.update(106, dManChanged);
        DeliveryMan dManUpdated = deliveryManController.read(106);

        // then
        assertTrue(result);
        assertEquals("Gabriel", dManUpdated.getName());
        assertEquals("Czech", dManUpdated.getLast_name());
    }

    @Test
    public void shouldCorrectlyBehaveOnUpdateWhenNull() {
        // given

        // when
        boolean result = deliveryManController.update(107, null);

        // then
        assertFalse(result);
    }

    @Test
    public void shouldCorrectlyBehaveOnUpdateWhenNotInDB() {
        // given
        DeliveryMan dMan = new DeliveryMan("Karol", "Sowiński", 108);

        // when
        boolean result = deliveryManController.update(1000, dMan);

        // then
        assertFalse(result);
    }

    @Test
    public void shouldCorrectlyBehaveOnDelete() {
        // given
        DeliveryMan dMan = new DeliveryMan("Ernest", "Staniszewski", 109);
        deliveryManController.create(dMan);

        // when
        boolean result = deliveryManController.delete(109);

        // then
        assertTrue(result);
    }

    @Test
    public void shouldCorrectlyBehaveOnDeleteCase2() {
        // given
        DeliveryMan dMan = new DeliveryMan("Karol", "Ossowski", 110);
        deliveryManController.create(dMan);

        // when
        boolean result = deliveryManController.delete(110);

        // then
        assertTrue(result);
    }

    @Test
    public void shouldCorrectlyBehaveOnDeleteWhenNotInDB() {
        // given
        DeliveryMan dMan = new DeliveryMan("Apollo", "Skowronek", 111);
        deliveryManController.create(dMan);

        // when
        boolean result = deliveryManController.delete(1000);

        // then
        assertFalse(result);
    }

    @After
    public void clear() {
        for (int i = 100; i < 112; i++) {
            deliveryManController.delete(i);
        }
    }

}
