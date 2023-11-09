package main.staff;

import main.interfaces.Printeable;
import main.interfaces.Stockeable;

public class DepositEmployee extends Person implements Printeable {

    // Default constructor
    public DepositEmployee(){}

    // Constructor using the parameters of the father class
    public DepositEmployee(String firstName, String lastName, Integer personAge){
        this.firstName = firstName;
        this.lastName = lastName;
        this.personAge = personAge;
    }

    // Overriding an abstract method
    @Override
    void getFullName() {
        System.out.println(firstName + " " + lastName);
    }

    // Using the interface
    @Override
    public void printDetails(){
        System.out.println("Name: " + firstName + "\n" + "Last name: " + lastName + "\n" + "Age: " + personAge);
    }


}
