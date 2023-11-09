package main.java;

import main.products.Combo;
import main.staff.Employees;

public class Supermarket {
    private String name;
    private String location;

    private Employees staff;
    private Combo products;

    // Default constructor for the class
    public Supermarket(){
        this.name = "default";
        this.location = "default";
        this.products = null;
        this.staff = null;

    }

    //Constructor for the Supermarket class
    public Supermarket(String name, String location, Employees staff, Combo products){
        this.name = name;
        this.location = location;
        this.staff = staff;
        this.products = products;
    }

    //Method to print the class information
    public void printInfo(){
        System.out.println("The name of the supermarket is " + name + " " + "The location is " + location);
    }


    // Getter and Setter of the location property
    public void setLocation(String location){ this.location = location; }
    public String getLocation(){ return location; }

    // Getter and Setter of the name property
    public void setName(String name){ this.name = name; }
    public String getName (){ return name; }


    // Getter and Setter of the staff property
    public Employees getStaff() {
        return staff;
    }

    public void setStaff(Employees staff) {
        this.staff = staff;
    }


    // Getter and Setter of the products property
    public Combo getProducts() {
        return products;
    }

    public void setProducts(Combo products) {
        this.products = products;
    }





}
