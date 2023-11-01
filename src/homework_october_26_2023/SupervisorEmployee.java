package homework_october_26_2023;

public class SupervisorEmployee {
    private Integer salary;
    private String name;

    //Constructor of the class
    public SupervisorEmployee(Integer salary, String name) {
        this.salary = salary;
        this.name = name;
    }

    //Getter and Setter of the salary
    public Integer getSalary() {return salary;}
    public void setSalary(Integer salary) {this.salary = salary;}

    //Getter and setter of name
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
