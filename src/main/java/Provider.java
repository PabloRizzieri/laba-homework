package main.java;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Provider {
    private static final Logger LOGGER = LogManager.getLogger(Provider.class);

    // Final variable
    private final String providerName = "Coca Cola";

    static String deliverDay = "Monday";


    // Constructor default for the class
    public Provider(){}


    static {
        LOGGER.info("Merchandise arriving");
    }

    public final void deliverMerchandise(){
        LOGGER.info("Merchandise delivered");
    }

    public static void deliverSchedule(){
        LOGGER.info("The merchandise will be delivered at " + deliverDay);
    }
}
