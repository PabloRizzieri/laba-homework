package main.java.staff;

import main.java.interfaces.Printeable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CleaningEmployee extends Person implements Printeable {
    private static final Logger LOGGER = LogManager.getLogger(CleaningEmployee.class);
    // Default constructor
    public CleaningEmployee(){}

    // Constructor using the parameters of the father class
    public CleaningEmployee(String firstName, String lastName, Integer personAge){
        this.firstName = firstName;
        this.lastName = lastName;
        this.personAge = personAge;
    }


    // Overriding an abstract method
    @Override
    void getFullName() {
        LOGGER.info(firstName + " " + lastName);
    }

    // Using the interface
    @Override
    public void printDetails(){
        LOGGER.info("Name: " + firstName + "\n" + "Last name: " + lastName + "\n" + "Age: " + personAge);
    }
}
