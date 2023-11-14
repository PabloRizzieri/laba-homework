package main.java.providers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class DrinksProvider extends Provider{
    private static final Logger LOGGER = LogManager.getLogger(DrinksProvider.class);
    public DrinksProvider(String name){
        super(name);
    }

    static {
        LOGGER.info("Drinks arriving");
    }
}
