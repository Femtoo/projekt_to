package com.example.interfaces;

import java.util.List;

import com.example.models.Package;

public interface IPackageController {
    boolean create(Package pack);
    List<Package> list();
    Package read(int package_nr);
    boolean update(int package_nr, Package pack);
    boolean delete(int package_nr);
}
