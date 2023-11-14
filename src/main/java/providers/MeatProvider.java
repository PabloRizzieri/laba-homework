package main.java.providers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class MeatProvider extends Provider{

    private static final Logger LOGGER = LogManager.getLogger(MeatProvider.class);
    public MeatProvider(String name){
        super(name);
    }

    static {
        LOGGER.info("Meat arriving");
    }
}
