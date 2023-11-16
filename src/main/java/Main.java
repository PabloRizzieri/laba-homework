import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import custom.CustomLinkedList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exceptions.InvalidBranchException;
import exceptions.InvalidIDException;
import exceptions.InvalidPersonNameException;
import exceptions.NoAgeException;
import exceptions.NoPriceException;
import exceptions.NoStockException;
import products.AppleProduct;
import products.CerealProduct;
import products.CleaningProduct;
import products.Combo;
import products.MeatProduct;
import products.Product;
import products.Supermarket;
import providers.FruitProvider;
import providers.MeatProvider;
import providers.Provider;
import staff.CleaningEmployee;
import staff.DepositEmployee;
import staff.Employees;
import staff.Person;
import staff.RegisterEmployee;
import staff.SupervisorEmployee;

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

        //Creating instances of the subclasses that products.Supermarket has
        Set<Person> staff2 = Employees.createStaff(registerEmployee, supervisorEmployee, depositEmployee, cleaningEmployee);
        Employees staff = new Employees("Monday to Friday", "Vea","Buenos Aires", cleaningEmployee, depositEmployee, registerEmployee, supervisorEmployee);
        Combo actualCombo = new Combo("Variadito", meatProduct, cerealProduct, appleProduct1, cleaningProduct);
        Combo actualCombo1 = new Combo("Variadito1", meatProduct, cerealProduct, appleProduct1, cleaningProduct);
        List<Product> listCombo = Combo.createCombo("Variadito2", meatProduct, cerealProduct, appleProduct2, cleaningProduct);


        // Testing new usage and creation of products.Supermarket
        Supermarket supermarket = new Supermarket("VEA", "RESISTENCIA", staff, actualCombo);
        LOGGER.info("The PRODUCTS OF THE MARKET ARE: " + supermarket.getStaff());



        //Using the default constructors
        Employees defaultStaff = new Employees();
        Combo defaultCombo = new Combo();

        // Printing specific data about the classes
        LOGGER.info(staff.getCleaningEmployee().getFirstName());
        LOGGER.info("The name of the deposit employee is " + staff.getDepositEmployee().getFirstName());
        staff.printInfo();
        staff.printDetails();
        cleaningEmployee.printDetails();

        // defaultCombo.printInfo(); Testing printInfo method

        // Utilizing the override method of the parent class
        appleProduct1.printProductInfo();
        cleaningProduct.printProductInfo();
        registerEmployee.getFullName();


        // Testing the hash-equal method override in the Product and Person class
        boolean areEqualProducts = appleProduct1.equals(appleProduct2);
        LOGGER.info("Are the apple com.solvd.products equal? " + (areEqualProducts ? "Yes" : "no"));

        boolean areEqualPerson = registerEmployee.equals(depositEmployee);
        LOGGER.info("They are the same person? " + (areEqualPerson ? "Yes" : "No"));


        // Testing toString method
        LOGGER.info(depositEmployee.toString());
        LOGGER.info(appleProduct1.toString());
        LOGGER.info(actualCombo1.toString());


        /* Utilizing the new methods of the final Provider class
        *   Provider provider = new Provider();
            provider.deliverMerchandise();
            Provider.deliverSchedule();
        * */



        // Testing Providers method to create a TreeMap and then printing the values of the new Treemap
        MeatProvider meatProvider = new MeatProvider("Carnes San Carlos");
        FruitProvider fruitProvider = new FruitProvider("Frutas Martinez");
        TreeMap<Integer, Provider> providers = Provider.createProvidersCollection(meatProvider, fruitProvider);
        providers.values().forEach(provider -> LOGGER.info("Provider name: " + provider.getProviderName()));

        // Testing new Combo methods to get the details of the combo and create a LinkedList of combos
        LOGGER.info(actualCombo.getName(1));
        LOGGER.info(actualCombo1.getId("Variadito1"));
        LOGGER.info(actualCombo1.getName(2));
        LOGGER.info(actualCombo.toString());
        LOGGER.info(listCombo.get(1));

        // Testing access to the comboDetails HashMap to obtain the key and the value
        LOGGER.info(actualCombo1.getComboDetails().values() + " " + actualCombo1.getComboDetails().keySet());

        // Testing the new method on the Combo class to create a LinkedList with all the combos provided on the parameters
        LinkedList<Combo> allCombos = Combo.createComboList("Variaditos", actualCombo1, actualCombo);

        // Testing custom linked list
        CustomLinkedList<Combo> comboTest = new CustomLinkedList<>();
        comboTest.addToBeginning(actualCombo);
        comboTest.addToBeginning(actualCombo1);
        LOGGER.info("ACAAAAAAAAAAAA");
        comboTest.printList();


        LOGGER.info(allCombos.get(0).getComboDetails());

        //Testing the staff2 created with the createStaff method
        LOGGER.info(staff2);
        LOGGER.info(staff2.contains("Rizzieri"));
        LOGGER.info(staff2.contains("Marianito"));

        // Testing a loop for print specific data about the objects inside the HashSet
        for (Person employee : staff2) {
            // Check the person type and realize a casting
            if (employee instanceof CleaningEmployee) {
                CleaningEmployee cleaningEmployeeTest = (CleaningEmployee) employee;
                LOGGER.info("Name of the cleaning employee: " + cleaningEmployeeTest.getFirstName());
                // Can get any other attributes that I need here
            } else if (employee instanceof RegisterEmployee) {
                RegisterEmployee employeeRegister = (RegisterEmployee) employee;
                LOGGER.info("Name of the register: " + employeeRegister.getFirstName());
                // Can get any other attributes that I need here
            }
        }





        //Handling Exceptions with try-catch block
        try {
            appleProduct1.validateProductID();
        } catch (InvalidIDException e){
            LOGGER.info("Caught an exception: " + e.getMessage());
            e.printStackTrace();
        }

        try {
            meatProduct.validateBranch();
        } catch (InvalidBranchException e){
            LOGGER.info("Caught an exception: " + e.getMessage());
            e.printStackTrace();
        }

        try {
            cerealProduct.validatePrice();
        } catch (NoPriceException | NoStockException e){
            LOGGER.info("Caught an exception: " + e.getMessage());
            e.printStackTrace();
        }


        // Using the second way to handle com.solvd.exceptions
        checkValidAge(cleaningEmployee);
        checkValidName(registerEmployee);

    }

    /// Creating methods to handle com.solvd.exceptions with the throws clause
    private static void checkValidAge(Person person){
        try {
            person.checkPersonAge();
        } catch (NoAgeException e){
            LOGGER.info("INVALID AGE");
            e.printStackTrace();
        }
    }

    private static void checkValidName(Person person){
        try {
            person.checkPersonName();
        } catch (InvalidPersonNameException e){
            LOGGER.info("INVALID NAME");
            e.printStackTrace();
        }
    }

}
