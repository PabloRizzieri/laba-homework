package main;

public final class Provider {

    // Final variable
    private final String providerName = "Coca Cola";

    static String deliverDay = "Monday";


    // Constructor default for the class
    public Provider(){}


    static {
        System.out.println("Merchandise arriving");
    }

    public final void deliverMerchandise(){
        System.out.println("Merchandise delivered");
    }

    public static void deliverSchedule(){
        System.out.println("The merchandise will be delivered at " + deliverDay);
    }
}
