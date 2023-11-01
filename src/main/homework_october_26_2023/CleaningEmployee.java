package main.homework_october_26_2023;

public class CleaningEmployee {
    private Integer salary;
    private String name;

    public CleaningEmployee(Integer salary, String name){
        this.name = name;
        this.salary = salary;
    }

    //Getter and setter of the salary

    public Integer getSalary() {return salary;}
    public void setSalary(Integer salary) {this.salary = salary;}

    //Getter and setter of name
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
