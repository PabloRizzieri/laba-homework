package main.homework_november_02_2023.staff;

public class DepositEmployee extends Person {

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


}
