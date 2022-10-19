package com.example.interfaces;

import java.util.List;

import com.example.models.SortingDepartment;

public interface ISortingDepartmentController {
    boolean create(SortingDepartment sortingDepartment);
    List<SortingDepartment> list();
    SortingDepartment read(int department_nr);
    boolean update(int department_nr, SortingDepartment sortingDepartment);
    boolean delete(int department_nr);
}
