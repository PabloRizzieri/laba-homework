package staff;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import interfaces.Printeable;

public class DepositEmployee extends Person implements Printeable {
    private static final Logger LOGGER = LogManager.getLogger(DepositEmployee.class);

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
        LOGGER.info(firstName + " " + lastName);
    }

    // Using the interface
    @Override
    public void printDetails(){
        LOGGER.info("Name: " + firstName + "\n" + "Last name: " + lastName + "\n" + "Age: " + personAge);
    }


}
