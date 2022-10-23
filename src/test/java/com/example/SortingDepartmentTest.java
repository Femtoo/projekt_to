package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.example.controllers.SortingDepartmentController;
import com.example.models.SortingDepartment;

public class SortingDepartmentTest {
    SortingDepartmentController sortingDepartmentController;

    @Before
    public void before() {
        sortingDepartmentController = new SortingDepartmentController();
    }

    // SortingDepartment TESTS
    @Test
    public void shouldCorrectlyBehaveOnCreate() {
        // given
        SortingDepartment sDepartment = new SortingDepartment(100, "ul Polna 2, Warszawa 15-333");

        // when
        boolean result = sortingDepartmentController.create(sDepartment);

        // then
        assertTrue(result);
    }

    @Test
    public void shouldCorrectlyBehaveOnCreateCase2() {
        // given
        SortingDepartment sDepartment = new SortingDepartment(101, "ul Leśna 3, Warszawa 15-333");

        // when
        boolean result = sortingDepartmentController.create(sDepartment);

        // then
        assertTrue(result);
    }

    @Test
    public void shouldCorrectlyBehaveOnCreateWhenAddedNull() {
        // given
        SortingDepartment sDepartment = new SortingDepartment(102, null);

        // when
        boolean result = sortingDepartmentController.create(sDepartment);

        // then
        assertFalse(result);
    }

    @Test
    public void shouldCorrectlyBehaveOnCreateWhenAddedNegativeIndex() {
        // given
        SortingDepartment sDepartment = new SortingDepartment(-103, "ul Słoneczna 4, Warszawa 15-333");

        // when
        boolean result = sortingDepartmentController.create(sDepartment);

        // then
        assertFalse(result);
    }

    @Test
    public void shouldCorrectlyBehaveOnCreateWhenAddedNegativeIndexCase2() {
        // given
        SortingDepartment sDepartment = new SortingDepartment(-111, "ul Szafrańska 4, Warszawa 15-333");

        // when
        boolean result = sortingDepartmentController.create(sDepartment);

        // then
        assertFalse(result);
    }

    @Test
    public void shouldCorrectlyBehaveOnCreateWhenAddedZeroIndex() {
        // given
        SortingDepartment sDepartment = new SortingDepartment(0, "ul Koszykowa 14, Warszawa 15-333");

        // when
        boolean result = sortingDepartmentController.create(sDepartment);

        // then
        assertFalse(result);
    }

    @Test
    public void shouldCorrectlyBehaveOnRead() {
        // given
        SortingDepartment sDepartment = new SortingDepartment(104, "ul Krótka 5, Warszawa 15-333");
        sortingDepartmentController.create(sDepartment);

        // when
        SortingDepartment result = sortingDepartmentController.read(104);

        // then
        assertNotNull(result);
    }

    @Test
    public void shouldCorrectlyBehaveOnReadCase2() {
        // given
        SortingDepartment sDepartment = new SortingDepartment(105, "ul Szkolna 6, Warszawa 15-333");
        sortingDepartmentController.create(sDepartment);

        // when
        SortingDepartment result = sortingDepartmentController.read(105);

        // then
        assertNotNull(result);
    }

    @Test
    public void shouldCorrectlyBehaveOnReadWhenNotInDataBase() {
        // given

        // when
        SortingDepartment result = sortingDepartmentController.read(1000);

        // then
        assertNull(result);
    }

    @Test
    public void shouldCorrectlyBehaveOnUpdate() {
        // given
        SortingDepartment sDepartment = new SortingDepartment(106, "ul Ogrodowa 6, Warszawa 15-333");
        sortingDepartmentController.create(sDepartment);
        SortingDepartment sDepartmentChanged = new SortingDepartment(106, "ul Lipowa 7, Warszawa 15-333");

        // when
        boolean result = sortingDepartmentController.update(106, sDepartmentChanged);
        SortingDepartment sDepartmentUpdated = sortingDepartmentController.read(106);

        // then
        assertTrue(result);
        assertEquals("ul Lipowa 7, Warszawa 15-333", sDepartmentUpdated.getAddress());
    }

    @Test
    public void shouldCorrectlyBehaveOnUpdateCase2() {
        // given
        SortingDepartment sDepartment = new SortingDepartment(107, "ul Łąkowa 8, Warszawa 15-333");
        sortingDepartmentController.create(sDepartment);
        SortingDepartment sDepartmentChanged = new SortingDepartment(107, "ul Brzozowa 9, Warszawa 15-333");

        // when
        boolean result = sortingDepartmentController.update(107, sDepartmentChanged);
        SortingDepartment sDepartmentUpdated = sortingDepartmentController.read(107);

        // then
        assertTrue(result);
        assertEquals("ul Brzozowa 9, Warszawa 15-333", sDepartmentUpdated.getAddress());
    }

    @Test
    public void shouldCorrectlyBehaveOnUpdateWhenNull() {
        // given

        // when
        boolean result = sortingDepartmentController.update(108, null);

        // then
        assertFalse(result);
    }

    @Test
    public void shouldCorrectlyBehaveOnUpdateWhenNotInDB() {
        // given
        SortingDepartment sDepartment = new SortingDepartment(109, "ul Brzozowa 9, Warszawa 15-333");

        // when
        boolean result = sortingDepartmentController.update(1000, sDepartment);

        // then
        assertFalse(result);
    }

    @Test
    public void shouldCorrectlyBehaveOnDelete() {
        // given
        SortingDepartment sDepartment = new SortingDepartment(110, "ul Kwiatowa 10, Warszawa 15-333");
        sortingDepartmentController.create(sDepartment);

        // when
        boolean result = sortingDepartmentController.delete(110);

        // then
        assertTrue(result);
    }

    @Test
    public void shouldCorrectlyBehaveOnDeleteCase2() {
        // given
        SortingDepartment sDepartment = new SortingDepartment(111, "ul Kościelna 11, Warszawa 15-333");
        sortingDepartmentController.create(sDepartment);

        // when
        boolean result = sortingDepartmentController.delete(111);

        // then
        assertTrue(result);
    }

    @Test
    public void shouldCorrectlyBehaveOnDeleteWhenNotInDB() {
        // given
        SortingDepartment sDepartment = new SortingDepartment(112, "ul Sosnowa 12, Warszawa 15-333");
        sortingDepartmentController.create(sDepartment);

        // when
        boolean result = sortingDepartmentController.delete(1000);

        // then
        assertFalse(result);
    }

    @After
    public void clear() {
        for (int i = 100; i < 113; i++) {
            sortingDepartmentController.delete(i);
        }
    }

}
