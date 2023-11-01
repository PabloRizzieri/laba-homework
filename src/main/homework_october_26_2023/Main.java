package main.homework_october_26_2023;

public class Main {
    public static void main(String[] args) {
        // Creating instances of every class
        CleaningEmployee cleaningEmployee = new CleaningEmployee(200, "Agustin");
        RegisterEmployee registerEmployee = new RegisterEmployee(250, "Pablo");
        DepositEmployee depositEmployee = new DepositEmployee(300, "Matias");
        SupervisorEmployee supervisorEmployee = new SupervisorEmployee(500, "Micaela");
        AppleProduct appleProduct = new AppleProduct("Apple Pie");
        CerealProduct cerealProduct = new CerealProduct("Honey Graham");
        MeatProduct meatProduct = new MeatProduct("Fish");
        CleaningProduct cleaningProduct = new CleaningProduct("Soap");

        //Creating instances of the subclasses that Supermarket has
        Employees staff = new Employees("Monday to Friday", "Vea","Buenos Aires", cleaningEmployee, depositEmployee, registerEmployee, supervisorEmployee);
        Combo actualCombo = new Combo("Vea", "Buenos Aires", "Mixed Combo", 22, meatProduct, cerealProduct, appleProduct, cleaningProduct);

        //Using the default constructors
        Employees defaultStaff = new Employees();
        Combo defaultCombo = new Combo();

        // Printing specific data about the classes
        System.out.println(actualCombo.getComboName());
        System.out.println(staff.getCleaningEmployee().getName());
        System.out.println(staff.getDepositEmployee().getSalary());
        staff.printInfo();

        defaultCombo.printInfo();
    }
}
