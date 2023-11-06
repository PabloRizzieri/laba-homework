package main.homework_november_02_2023.staff;

import main.homework_november_02_2023.Supermarket;

public class Employees extends Supermarket {
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
        super(name, location);
        this.employeeWorkingDays = employeeWorkingDays;
        this.cleaningEmployee = cleaningEmployee;
        this.registerEmployee = registerEmployee;
        this.supervisorEmployee = supervisorEmployee;
        this.depositEmployee = depositEmployee;
    }

    @Override
    public void printInfo(){
        super.printInfo();
        // Info about the staff of the supermarket
        System.out.println("The actual staff is " + supervisorEmployee.getFirstName() + " " + registerEmployee.getFirstName() + " " + depositEmployee.getFirstName() + " " + cleaningEmployee.getFirstName());
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


}
