package main.java;

import main.java.exceptions.*;
import main.java.products.*;
import main.java.staff.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);



    public static void main(String[] args) {
        System.setProperty("log4j.configurationFile", "src/resources/log4j2.properties");
        // Creating instances of every class
        CleaningEmployee cleaningEmployee = new CleaningEmployee("Agustin", "Rizzieri", -2);
        RegisterEmployee registerEmployee = new RegisterEmployee("Pablo", null, 22);
        DepositEmployee depositEmployee = new DepositEmployee("Matias", "Morales", 25);
        SupervisorEmployee supervisorEmployee = new SupervisorEmployee("Micaela", "Gonzalez", 42);
        AppleProduct appleProduct1 = new AppleProduct("Apple Pie", 25, 25, "Bakery", false, 25);
        AppleProduct appleProduct2 = new AppleProduct("Apple", 25, 50, "Fruit", false, 39);
        CerealProduct cerealProduct = new CerealProduct("Honey Graham", 35, 99, "Cereals", true, 0);
        MeatProduct meatProduct = new MeatProduct("Fish", 99, 1542, null, true, -5);
        CleaningProduct cleaningProduct = new CleaningProduct("Soap", 34, 781, "Cleaning", false, 10);

        //Creating instances of the subclasses that Supermarket has
        Employees staff = new Employees("Monday to Friday", "Vea","Buenos Aires", cleaningEmployee, depositEmployee, registerEmployee, supervisorEmployee);
        Combo actualCombo = new Combo("Mixed Combo", 22, meatProduct, cerealProduct, appleProduct1, cleaningProduct);


        // Testing new usage and creation of Supermarket
        Supermarket supermarket = new Supermarket("VEA", "RESISTENCIA", staff, actualCombo);
        LOGGER.info("The PRODUCTS OF THE MARKET ARE: " + supermarket.getStaff());

        LOGGER.info(meatProduct.getPrice() + " " + meatProduct.isPriceable());

        //Using the default constructors
        Employees defaultStaff = new Employees();
        Combo defaultCombo = new Combo();

        // Printing specific data about the classes
        LOGGER.info(actualCombo.getComboName());
        LOGGER.info(staff.getCleaningEmployee().getFirstName());
        LOGGER.info("The name of the deposit employee is " + staff.getDepositEmployee().getFirstName());


        staff.printInfo();
        staff.printDetails();
        cleaningEmployee.printDetails();

        defaultCombo.printInfo();

        // Utilizing the override method of the parent class
        appleProduct1.printProductInfo();
        cleaningProduct.printProductInfo();
        registerEmployee.getFullName();


        // Testing the hash-equal method override in the Product and Person class
        boolean areEqualProducts = appleProduct1.equals(appleProduct2);
        LOGGER.info("Are the apple products equal? " + (areEqualProducts ? "Yes" : "no"));

        boolean areEqualPerson = registerEmployee.equals(depositEmployee);
        LOGGER.info("They are the same person? " + (areEqualPerson ? "Yes" : "No"));


        // Testing toString method
        LOGGER.info(depositEmployee.toString());
        LOGGER.info(appleProduct1.toString());
        LOGGER.info(actualCombo.toString());


        // Utilizing the new methods of the final Provider class
        Provider provider = new Provider();
        provider.deliverMerchandise();
        Provider.deliverSchedule();


        //Handling Exceptions with try-catch block
        try {
            appleProduct1.validateProductID();
        } catch (InvalidIDException e){
            LOGGER.info("Caught an exception: " + e.getMessage());
        }

        try {
            meatProduct.validateBranch();
        } catch (InvalidBranchException e){
            LOGGER.info("Caught an exception: " + e.getMessage());
        }

        try {
            cerealProduct.validatePrice();
        } catch (NoPriceException e){
            LOGGER.info("Caught an exception: " + e.getMessage());
        }


        // Using the second way to handle exceptions
        checkValidAge(cleaningEmployee);
        checkValidName(registerEmployee);





    }

    /// Creating methods to handle exceptions with the throws clause
    private static void checkValidAge(Person person){
        try {
            person.checkPersonAge();
        } catch (NoAgeException e){
            LOGGER.info("INVALID AGE");
        }
    }

    private static void checkValidName(Person person){
        try {
            person.checkPersonName();
        } catch (InvalidPersonNameException e){
            LOGGER.info("INVALID NAME");
        }
    }

}
