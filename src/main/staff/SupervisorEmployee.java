package main.staff;

import main.interfaces.SupervisorTasks;

public class SupervisorEmployee extends Person implements SupervisorTasks {
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
    public void superviseTeam(){
        System.out.println("Supervising team");
    }
}
