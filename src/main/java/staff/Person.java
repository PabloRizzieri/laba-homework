package main.java.staff;

import main.java.exceptions.InvalidPersonNameException;
import main.java.exceptions.NoAgeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public abstract class Person {
    private static final Logger LOGGER = LogManager.getLogger(Person.class);


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getPersonAge() {
        return personAge;
    }

    public void setPersonAge(Integer personAge) {
        this.personAge = personAge;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    protected String firstName;
    protected Integer personAge;
    protected String lastName;

    public Person(){
        firstName = "Default";
        personAge = 0;
        lastName = "Default";
    }

    abstract void getFullName();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Objects.equals(getFirstName(), person.getFirstName()) && Objects.equals(getLastName(), person.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName());
    }

    @Override
    public String toString() {
        return "Person {" +'\n'+
                "firstName: " + firstName + '\n' +
                "personAge: " + personAge + '\n' +
                "lastName: '" + lastName + "}";
    }

    public void checkPersonAge() throws NoAgeException{
        if (personAge < 0){
            throw new NoAgeException("The person has an invalid age");
        }
        LOGGER.info("The person has the age: " + personAge);
    }

    public void checkPersonName() throws InvalidPersonNameException{
        if (firstName == null || lastName == null){
            throw new InvalidPersonNameException("The person has an invalid name it doesn't have first or last name");
        }
        LOGGER.info("The person has a valid name");
    }
}
