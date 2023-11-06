package main.staff;

import main.interfaces.RegisterTasks;

public class RegisterEmployee extends Person implements RegisterTasks {
    // Default constructor
    public RegisterEmployee(){}

    // Constructor using the parameters of the father class
    public RegisterEmployee(String firstName, String lastName, Integer personAge){
        this.firstName = firstName;
        this.lastName = lastName;
        this.personAge = personAge;
    }


    // Overriding an abstract method
    @Override
    public void getFullName() {
        System.out.println(firstName + " " + lastName);
    }

    // Using the interface
    @Override
    public void registerSales(){
        System.out.println("attending the register");
    }
}
