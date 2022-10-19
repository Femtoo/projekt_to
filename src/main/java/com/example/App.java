package com.example;
import java.util.List;

import com.example.controllers.DeliveryManController;
import com.example.controllers.PackageController;
import com.example.controllers.SortingDepartmentController;
import com.example.models.DeliveryMan;
import com.example.models.Package;
import com.example.models.SortingDepartment;

public class App 
{
    public static void main( String[] args )
    {
        DeliveryManController deliveryManController = new DeliveryManController();
        
        List<DeliveryMan> deliveryMans = deliveryManController.list();
        if(deliveryMans.size() != 0) System.out.println("git");
        if(deliveryManController.create(new DeliveryMan("asd", "asd", 93458))) System.out.println("git");
        if(deliveryManController.update(93458, new DeliveryMan("asdasd", "asdasd", 93458))) System.out.println("git");
        if(deliveryManController.delete(93458)) System.out.println("git"); 

        PackageController packageController = new PackageController();

        List<Package> packages = packageController.list();
        if(packages.size() != 0) System.out.println("git");
        if(packageController.create(new Package(567567, "asd", "asd", "asd", System.currentTimeMillis(), 1, 1, 1))) System.out.println("git");
        if(packageController.update(567567, new Package(567567, "asasdd", "adsasd", "asdsad", System.currentTimeMillis(), 1, 1, 1))) System.out.println("git");
        if(packageController.delete(567567)) System.out.println("git"); 

        SortingDepartmentController sortingDepartmentController = new SortingDepartmentController();

        List<SortingDepartment> sortingDepartments = sortingDepartmentController.list();
        if(sortingDepartments.size() != 0) System.out.println("git");
        if(sortingDepartmentController.create(new SortingDepartment(56657765, "pqwoe"))) System.out.println("git");
        if(sortingDepartmentController.update(56657765, new SortingDepartment(56657765, "pqwqeqwoe"))) System.out.println("git");
        if(sortingDepartmentController.delete(56657765)) System.out.println("git"); 
    }
}
