package main.homework_november_02_2023;

public class Supermarket {
    private String name;
    private String location;

    // Default constructor for the class
    public Supermarket(){
        this.name = "default";
        this.location = "default";

    }

    //Constructor for the Supermarket class
    public Supermarket(String name, String location){
        this.name = name;
        this.location = location;
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





}
