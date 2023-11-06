package main.homework_november_02_2023;

import main.homework_november_02_2023.products.*;
import main.homework_november_02_2023.staff.*;

public class Main {
    public static void main(String[] args) {
        // Creating instances of every class
        CleaningEmployee cleaningEmployee = new CleaningEmployee("Agustin", "Rizzieri", 18);
        RegisterEmployee registerEmployee = new RegisterEmployee("Pablo", "Cardozo", 22);
        DepositEmployee depositEmployee = new DepositEmployee("Matias", "Morales", 25);
        SupervisorEmployee supervisorEmployee = new SupervisorEmployee("Micaela", "Gonzalez", 42);
        AppleProduct appleProduct1 = new AppleProduct("Apple Pie", 25, 50, "Bakery", false);
        AppleProduct appleProduct2 = new AppleProduct("Apple", 25, 50, "Fruit", false);
        CerealProduct cerealProduct = new CerealProduct("Honey Graham", 12, 99, "Cereals", true);
        MeatProduct meatProduct = new MeatProduct("Fish", 99, 1542, "Meats", true);
        CleaningProduct cleaningProduct = new CleaningProduct("Soap", 34, 781, "Cleaning", false);

        //Creating instances of the subclasses that Supermarket has
        Employees staff = new Employees("Monday to Friday", "Vea","Buenos Aires", cleaningEmployee, depositEmployee, registerEmployee, supervisorEmployee);
        Combo actualCombo = new Combo("Vea", "Buenos Aires", "Mixed Combo", 22, meatProduct, cerealProduct, appleProduct1, cleaningProduct);

        //Using the default constructors
        Employees defaultStaff = new Employees();
        Combo defaultCombo = new Combo();

        // Printing specific data about the classes
        System.out.println(actualCombo.getComboName());
        System.out.println(staff.getCleaningEmployee().getFirstName());
        System.out.println("The name of the deposit employee is " + staff.getDepositEmployee().getFirstName());


        staff.printInfo();

        defaultCombo.printInfo();

        // Utilizing the override method of the parent class
        appleProduct1.printProductInfo();
        cleaningProduct.printProductInfo();
        registerEmployee.getFullName();


        // Testing the hash-equal method override in the Product and Person class
        boolean areEqualProducts = appleProduct1.equals(appleProduct2);
        System.out.println("Are the apple products equal? " + (areEqualProducts ? "Yes" : "no"));

        boolean areEqualPerson = registerEmployee.equals(depositEmployee);
        System.out.println("They are the same person? " + (areEqualPerson ? "Yes" : "No"));


        // Testing toString method
        System.out.println(depositEmployee.toString());
        System.out.println(appleProduct1.toString());
        System.out.println(actualCombo.toString());


        // Utilizing the new methods of the final Provider class
        Provider provider = new Provider();
        provider.deliverMerchandise();
        provider.deliverSchedule();

    }
}
