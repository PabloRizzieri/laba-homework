package main.sorts;

public class UserInfo {
    public static void main(String[] args) {
        printData(args[0], args[1], args[2]);
    }

    public static void printData(String name, String age, String city){
        System.out.println("The user name is: " + name + " and his age is: " + age + " and he lives in: " + city);
    }

}
