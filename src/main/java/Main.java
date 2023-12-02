import java.lang.reflect.*;
import java.util.*;
import java.util.stream.Collectors;

import custom.CustomLinkedList;
import customLambdas.CustomLambdaOne;
import customLambdas.CustomLambdaThree;
import customLambdas.CustomLambdaTwo;
import enums.BrandsCategory;
import enums.Suppliers;
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
        RegisterEmployee registerEmployee = new RegisterEmployee("Pablo", "Rodriguez", 22);
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
        Combo actualCombo = new Combo("Healthy", meatProduct, cerealProduct, appleProduct1, cleaningProduct);
        Combo actualCombo1 = new Combo("Unhealthy", meatProduct, cerealProduct, appleProduct1, cleaningProduct);
        Combo actualCombo2 = new Combo("Energic", meatProduct, cerealProduct, appleProduct2, cleaningProduct);
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
        MeatProvider meatProvider = new MeatProvider("Meat San Carlos");
        FruitProvider fruitProvider = new FruitProvider("Fruits Martinez");
        TreeMap<Integer, Provider> providers = Provider.createProvidersCollection(meatProvider, fruitProvider);
        providers.values().forEach(provider -> LOGGER.info("Provider name: " + provider.getProviderName()));

        // Testing new Combo methods to get the details of the combo and create a LinkedList of combos
        LOGGER.info(actualCombo.getName(1));
        LOGGER.info(actualCombo1.getId("Healthy"));
        LOGGER.info(actualCombo1.getName(2));
        LOGGER.info(actualCombo.toString());
        LOGGER.info(listCombo.get(1));

        // Testing access to the comboDetails HashMap to obtain the key and the value
        LOGGER.info(actualCombo1.getComboDetails().values() + " " + actualCombo1.getComboDetails().keySet());

        // Testing the new method on the Combo class to create a LinkedList with all the combos provided on the parameters
        LinkedList<Combo> allCombos = Combo.createComboList("Variety", actualCombo1, actualCombo);

        // Testing custom linked list
        CustomLinkedList<Combo> comboTest = new CustomLinkedList<>();
        comboTest.addToBeginning(actualCombo1);
        comboTest.addToBeginning(actualCombo);
        comboTest.addToBeginning(actualCombo2);
        comboTest.size();
        comboTest.isEmpty();


        //Testing the logic under the sortAlphabetically method
        CustomLinkedList<Person> personTest = new CustomLinkedList<>();
        personTest.addToBeginning(depositEmployee);
        personTest.addToBeginning(cleaningEmployee);
        personTest.addToBeginning(registerEmployee);

        LOGGER.info("HERE TEST WITHOUT THE SORT");

        personTest.printList();
        personTest.sort(Comparator.comparing(Person::getFirstName));

        LOGGER.info("TEST WITH THE SORT");
        personTest.printList();
        LOGGER.info(allCombos.get(0).getComboDetails());

        //Testing the staff2 created with the createStaff method
        LOGGER.info(staff2);
        LOGGER.info(staff2.contains("Rizzieri"));
        LOGGER.info(staff2.contains("Marianito"));


        //Testing Custom Lambdas
        CustomLambdaOne<Integer> printInteger = value -> System.out.println("Integer value: " + value);
        printInteger.apply(42);

        CustomLambdaTwo<Integer> intEqualityChecker = (valueOne, valueTwo) -> valueOne.equals(valueTwo);
        boolean intResult = intEqualityChecker.areEqual(58,62);
        System.out.println("Are integer equals? " + intResult);

        CustomLambdaThree<String, String> stringTransformer = value -> value.replaceAll("", " ");
        String transformedString = stringTransformer.transform("Hello World");
        System.out.println("Transformed String: " + transformedString);

        // Streaming testing with terminal operation
        staff2.stream()
                .map(Person::getFirstName)
                .forEach(System.out::println);

        // Stream example with a non-terminal operation (filter)
        staff2.stream()
                .filter(person -> person.getPersonAge() > 18)
                .map(Person::getLastName)
                .forEach(System.out::println);


        // Stream example with a terminal operation (collect)
        List<String> lastNameOfTheOlderEmployee = staff2.stream()
                .filter(person -> person.getPersonAge() > 30)
                .map(Person::getLastName)
                .collect(Collectors.toList());

        System.out.println("Older employee " + lastNameOfTheOlderEmployee);

        // Stream example with other list and using differents methods such as count and peek
        long transformedProductsCount = listCombo.stream()
                .map(product -> new AppleProduct(product.getNameProduct(), product.getProductID(), (int) (product.getProductPrice() * 1.2), product.getProductBranch(), product.getHasDiscount(), product.getStock()))
                .peek(transformedProduct -> System.out.println("Transformed Product " + transformedProduct))
                .count();

        System.out.println("Number of transformed products " + transformedProductsCount);

        // Stream example with a non-terminal operation (distinct)
        List<Product> distinctProducts = listCombo.stream()
                .distinct() // Non-terminal operation to remove duplicates based on equals/hashCode
                .peek(product -> System.out.println("Distinct Product: " + product))
                .toList(); // Terminal operation to collect into a new List

        // Display the distinct products
        System.out.println("\nDistinct Products:");
        distinctProducts.forEach(System.out::println);

        // Stream example with a terminal operation (sum)
        double totalOriginalPrice = listCombo.stream()
                .mapToDouble(Product::getProductPrice)// Extracting prices as doubles
                .sum(); // Terminal operation to calculate the sum

        // Display the total original price
        System.out.println("\nTotal Combo Price: $" + totalOriginalPrice);

        // Stream example with a TreeMap
        List<String> transformedProviderNames = providers.entrySet().stream()
                .map(entry -> entry.getKey() + " - " + entry.getValue().getProviderName())
                .collect(Collectors.toList());

        System.out.println("\nTransformed Provider Names: ");
        transformedProviderNames.forEach(System.out::println);


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


        // Using the second way to handle exceptions
        checkValidAge(cleaningEmployee);
        checkValidName(registerEmployee);

        // Reflection testing
        Class<?> appleProduct = AppleProduct.class;

        // Extract information about fields
        LOGGER.info("Fields: ");
        Field[] fields = appleProduct.getDeclaredFields();
        for (Field field : fields){
            LOGGER.info("Name: " + field.getName());
            LOGGER.info("Type" + field.getType());
            LOGGER.info("Modifiers: " + Modifier.toString(field.getModifiers()));
            System.out.println("Finish");
        }

        //Extract information about constructor
        LOGGER.info("Constructors: ");
        Constructor<?>[] constructors = appleProduct.getConstructors();
        for (Constructor<?> constructor : constructors){
            LOGGER.info("Name: " + constructor.getName());
            LOGGER.info("Modifiers: " + Modifier.toString(constructor.getModifiers()));

            //Extract info about the constructor parameters
            Parameter[] parameters = constructor.getParameters();
            LOGGER.info("Parameters: " + Arrays.toString(parameters));
            System.out.println("Finish 2");
        }

        //Extract information about methods
        Method[] methods = appleProduct.getMethods();
        for (Method method : methods){
            LOGGER.info("Name: " + method.getName());
            LOGGER.info("Return type: " + method.getReturnType());
            LOGGER.info("Modifiers: " + Modifier.toString(method.getModifiers()));

            //Extract the method parameters
            Parameter[] parameters = method.getParameters();
            LOGGER.info("Method Parameters: " + Arrays.toString(parameters));
            System.out.println("Finish 3");
        }

        // Creating an object and calling a method inside of it
        try {
            // Create an instance of MyClass using reflection
            Object reflectAppleProduct = appleProduct.getDeclaredConstructor().newInstance();

            // Get a method
            Method print = appleProduct.getDeclaredMethod("mirrorMethod", String.class);

            // Call the method on the created instance
            print.invoke(reflectAppleProduct, "REFLECTION");

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    /// Creating methods to handle exceptions with the throws clause
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
