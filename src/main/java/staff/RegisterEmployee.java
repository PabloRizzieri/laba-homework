package main.java.staff;

import main.java.interfaces.Printeable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RegisterEmployee extends Person implements Printeable {
    private static final Logger LOGGER = LogManager.getLogger(RegisterEmployee.class);
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
        LOGGER.info(firstName + " " + lastName);
    }

    // Using the interface
    @Override
    public void printDetails(){
        LOGGER.info("Name: " + firstName + "\n" + "Last name: " + lastName + "\n" + "Age: " + personAge);
    }
}
