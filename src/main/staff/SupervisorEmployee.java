package main.staff;


import main.interfaces.Printeable;

public class SupervisorEmployee extends Person implements Printeable {
    // Default constructor
    public SupervisorEmployee(){}

    // Constructor using the parameters of the father class
    public SupervisorEmployee(String firstName, String lastName, Integer personAge){
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
