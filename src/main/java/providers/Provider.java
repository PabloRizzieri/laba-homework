package main.java.providers;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Provider {
    private static final Logger LOGGER = LogManager.getLogger(Provider.class);


    // Final variable
    private String providerName;
    static String deliverDay = "Monday";


    // Constructor for the class
    public Provider(String providerName){
        this.providerName = providerName;
    }

    /*
     STATIC BLOCK
     static {
       LOGGER.info("Merchandise arriving");
    }
    */

    public static TreeMap<Integer, Provider> createProvidersCollection(Provider... providers){
        TreeMap<Integer, Provider> providerTreeMap = new TreeMap<>();
        int providerId = 1;  // You can use a more sophisticated logic to generate provider IDs

        for (Provider provider : providers) {
            providerTreeMap.put(providerId++, provider);
        }

        return providerTreeMap;

    }

    public final void deliverMerchandise(){
        LOGGER.info("Merchandise delivered");
    }

    public static void deliverSchedule(){
        LOGGER.info("The merchandise will be delivered at " + deliverDay);
    }


    // GETTER AND SETTER of the parameters
    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
}
