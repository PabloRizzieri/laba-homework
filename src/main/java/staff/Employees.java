package staff;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import interfaces.Printeable;
import products.Supermarket;

public class Employees extends Supermarket implements Printeable {
    private static final Logger LOGGER = LogManager.getLogger(Employees.class);
    private CleaningEmployee cleaningEmployee;
    private DepositEmployee depositEmployee;
    private RegisterEmployee registerEmployee;
    private SupervisorEmployee supervisorEmployee;
    private String employeeWorkingDays;

    //Default constructor
    public Employees(){
        this.employeeWorkingDays = "Default";
        this.cleaningEmployee = new CleaningEmployee("Default", "Default", 0);
        this.supervisorEmployee = new SupervisorEmployee("Default", "Default", 0);
        this.depositEmployee = new DepositEmployee("Default", "Default", 0);
        this.registerEmployee = new RegisterEmployee("Default", "Default", 0);
    }


    //Constructor for the class
    public Employees(String employeeWorkingDays, String name, String location, CleaningEmployee cleaningEmployee, DepositEmployee depositEmployee, RegisterEmployee registerEmployee, SupervisorEmployee supervisorEmployee){
        this.employeeWorkingDays = employeeWorkingDays;
        this.cleaningEmployee = cleaningEmployee;
        this.registerEmployee = registerEmployee;
        this.supervisorEmployee = supervisorEmployee;
        this.depositEmployee = depositEmployee;
    }

    @Override
    public void printInfo(){
        super.printInfo();
        // Info about the com.solvd.staff of the supermarket
        LOGGER.info("The actual com.solvd.staff is " + supervisorEmployee.getFirstName() + " " + registerEmployee.getFirstName() + " " + depositEmployee.getFirstName() + " " + cleaningEmployee.getFirstName());
    }


    //Getter and Setter of the employeeWorkingDays
    public String getEmployeeWorkingDays(){ return employeeWorkingDays; }
    public void setEmployeeWorkingDays(String employeeWorkingDays) {this.employeeWorkingDays = employeeWorkingDays; }



    //Getter and Setter of the Cleaning
    public CleaningEmployee getCleaningEmployee() {return cleaningEmployee;}
    public void setCleaningEmployee(CleaningEmployee cleaningEmployee) {this.cleaningEmployee = cleaningEmployee;}


    //Getter and Setter of the Deposit
    public DepositEmployee getDepositEmployee() {return depositEmployee;}
    public void setDepositEmployee(DepositEmployee depositEmployee) {this.depositEmployee = depositEmployee;}


    //Getter and Setter of the Register
    public RegisterEmployee getRegisterEmployee() {return registerEmployee;}
    public void setRegisterEmployee(RegisterEmployee registerEmployee) {this.registerEmployee = registerEmployee;}


    //Getter and Setter of the Supervisor
    public SupervisorEmployee getSupervisorEmployee() {return supervisorEmployee;}
    public void setSupervisorEmployee(SupervisorEmployee supervisorEmployee) {this.supervisorEmployee = supervisorEmployee;}



    public static Set<Person> createStaff(Person... person){
        return new HashSet<>(Arrays.asList(person));
    };

    @Override
    public void printDetails() {
        String staff = "The employees are:\n" +
                "Cleaning : " + cleaningEmployee.getFirstName() + "\n" +
                "Register : " + registerEmployee.getFirstName() + "\n" +
                "Deposit : " + depositEmployee.getFirstName() + "\n" +
                "Supervisor: " + supervisorEmployee.getFirstName();
        LOGGER.info(staff);
    }

    @Override
    public String toString() {
        return "Employees{" + '\n' +
                "Cleaning: " + cleaningEmployee + '\n' +
                "Deposit: " + depositEmployee + '\n' +
                "Register: " + registerEmployee + '\n' +
                "Supervisor: " + supervisorEmployee + '\n' +
                "And the working days are: " + employeeWorkingDays +
                '}';
    }
}
