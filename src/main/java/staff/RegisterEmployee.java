package main.java.staff;

import main.interfaces.Printeable;
import main.interfaces.Registrable;

public class RegisterEmployee extends Person implements Printeable {
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
    public void printDetails(){
        System.out.println("Name: " + firstName + "\n" + "Last name: " + lastName + "\n" + "Age: " + personAge);
    }
}
