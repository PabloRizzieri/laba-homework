package main.homework_october_26_2023;

public class RegisterEmployee{
    private Integer salary;
    private String name;

    //Constructor for the class
    public RegisterEmployee(Integer salary, String name){

        this.salary = salary;
        this.name = name;
    }

    //Getter and Setter for the salary property
    public void setSalary(Integer salary){ this.salary = salary; }
    public Integer getSalary() { return salary; }

    //Getter and setter of name
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
