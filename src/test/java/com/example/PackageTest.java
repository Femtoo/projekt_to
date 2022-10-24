package com.example;

import com.example.controllers.DeliveryManController;
import com.example.controllers.PackageController;
import com.example.controllers.SortingDepartmentController;
import com.example.models.DeliveryMan;
import com.example.models.Package;
import com.example.models.SortingDepartment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PackageTest {

    private PackageController packageController;
    private SortingDepartmentController sortingDepartmentController;
    private DeliveryManController deliveryManController;

    @Before
    public void before() {
        packageController = new PackageController();
        sortingDepartmentController = new SortingDepartmentController();
        deliveryManController = new DeliveryManController();
        SortingDepartment sDepartment1 = new SortingDepartment(100, "ul Polna 2, Warszawa 15-333");
        SortingDepartment sDepartment2 = new SortingDepartment(101, "ul Polna 2, Warszawa 15-333");
        DeliveryMan dMan1 = new DeliveryMan("Feliks", "Majewski", 100);
        DeliveryMan dMan2 = new DeliveryMan("Atanazy", "Hajduk", 101);
        sortingDepartmentController.create(sDepartment1);
        sortingDepartmentController.create(sDepartment2);
        deliveryManController.create(dMan1);
        deliveryManController.create(dMan2);
    }

    @Test
    public void should_ReturnTrue_WhenCreatingPackageWithValidData() {
        // given
        Package p = new Package(100, "Kamil", "Lukasz", "Ul. Polna 12", 201020023, 100, 101, 100);

        // when
        boolean result = packageController.create(p);

        // then
        assertTrue(result);
    }

    @Test
    public void should_ReturnTrue_WhenCreatingPackageWithValidData2() {
        // given
        Package p = new Package(101, "Kamil", "Lukasz", "Ul. Polna 12", 201020023, 100, 101, 100);

        // when
        boolean result = packageController.create(p);

        // then
        assertTrue(result);
    }

    @Test
    public void should_ReturnFalse_WhenCreatingPackageWithNonExistingPickUpDeliveryMan() {
        // given
        Package p = new Package(1, "Kamil", "Lukasz", "Ul. Polna 12", 201020023, 50, 101, 100);

        // when
        boolean result = packageController.create(p);

        // then
        assertFalse(result);
    }

    @Test
    public void should_ReturnFalse_WhenCreatingPackageWithPackageNrLessThan1() {
        // given
        Package p = new Package(0, "Kamil", "Lukasz", "Ul. Polna 12", 201020023, 50, 101, 100);

        // when
        boolean result = packageController.create(p);

        // then
        assertFalse(result);
    }

    @Test
    public void should_ReturnFalse_WhenCreatingPackageWithNonExistingDeliveringDeliveryMan() {
        // given
        Package p = new Package(1, "Kamil", "Lukasz", "Ul. Polna 12", 201020023, 100, 5, 100);

        // when
        boolean result = packageController.create(p);

        // then
        assertFalse(result);
    }

    @Test
    public void should_ReturnFalse_WhenCreatingPackageWithNullSender() {
        // given
        Package p = new Package(1, null, "Lukasz", "Ul. Polna 12", 201020023, 100, 5, 100);

        // when
        boolean result = packageController.create(p);

        // then
        assertFalse(result);
    }

    @Test
    public void should_ReturnFalse_WhenCreatingPackageWithNullReceiver() {
        // given
        Package p = new Package(1, "Kamil", null, "Ul. Polna 12", 201020023, 100, 5, 100);

        // when
        boolean result = packageController.create(p);

        // then
        assertFalse(result);
    }

    @Test
    public void should_ReturnFalse_WhenCreatingPackageWithNonExistingSortingDepartment() {
        // given
        Package p = new Package(1, "Kamil", null, "Ul. Polna 12", 201020023, 100, 5, 88);

        // when
        boolean result = packageController.create(p);

        // then
        assertFalse(result);
    }

    @Test
    public void should_ReturnFalse_WhenCreatingPackageWithAlreadyExistingPackageNumber() {
        // given
        Package p = new Package(1, "Kamil", "Tomasz", "Ul. Polna 12", 201020023, 100, 101, 100);
        Package p2 = new Package(1, "Jacek", "Kamil", "Ul. Polna 12", 201020023, 100, 101, 100);

        // when
        packageController.create(p);
        boolean result = packageController.create(p2);

        // then
        assertFalse(result);
    }

    @Test
    public void should_NotReturnNull_WhenReadingExistingPackage() {
        // given
        Package p = new Package(11, "Kamil", "Tomasz", "Ul. Polna 12", 201020023, 100, 101, 100);
        packageController.create(p);

        // when
        Package res = packageController.read(11);

        // then
        assertNotNull(res);
    }

    @Test
    public void should_ReturnNull_WhenReadingNonExistingPackage() {
        // given

        // when
        Package res = packageController.read(44);

        // then
        assertNull(res);
    }

    @Test
    public void should_ReturnTrue_WhenDeletingExistingPackage() {
        // given
        Package p = new Package(1, "Kamil", "Tomasz", "Ul. Polna 12", 201020023, 100, 101, 100);
        packageController.create(p);

        // when
        boolean res = packageController.delete(1);

        // then
        assertTrue(res);
    }

    @Test
    public void should_ReturnFalse_WhenDeletingNonExistingPackage() {
        // given
        Package p = new Package(1, "Kamil", "Tomasz", "Ul. Polna 12", 201020023, 100, 101, 100);
        packageController.create(p);

        // when
        boolean res = packageController.delete(5);

        // then
        assertFalse(res);
    }

    @Test
    public void should_ReturnFalse_WhenPackageIsNull() {
        //given

        // when
        boolean res = packageController.update(100, null);

        assertFalse(res);
    }

    @Test
    public void should_ReturnFalse_WhenPackageDoesNotExistsInDb() {
        //given
        Package p = new Package(1, "Kamil", "Tomasz", "Ul. Debowa 32", 201020023, 100, 101, 100);

        // when
        boolean res = packageController.update(13, null);

        assertFalse(res);
    }

    @Test
    public void should_ReturnTrue_WhenUpdatingWithCorrectData() {
        //given
        Package p = new Package(1, "Kamil", "Tomasz", "Ul. Debowa 32", 20102023, 100, 101, 100);
        packageController.create(p);
        Package pNew = new Package(1, "Piotr", "Tomasz", "Ul. Waflowa 15", 25102023, 100, 101, 100);

        // when
        boolean res = packageController.update(1, pNew);
        Package after = packageController.read(1);

        // then
        assertTrue(res);
        assertEquals("Ul. Waflowa 15", after.getAddress());
        assertEquals(25102023, after.getIncoming_date());
        assertEquals("Piotr", after.getSender());
    }

    @After
    public void after() {
        for (int i = 100; i < 102; i++) {
            sortingDepartmentController.delete(i);
            deliveryManController.delete(i);
            packageController.delete(i);
        }
    }
}
