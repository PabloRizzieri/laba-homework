package main.homework_october_26_2023;

public class SupervisorEmployee extends Person{
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
}
