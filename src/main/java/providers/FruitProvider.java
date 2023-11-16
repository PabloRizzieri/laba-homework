package providers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class FruitProvider extends Provider{

    private static final Logger LOGGER = LogManager.getLogger(FruitProvider.class);
    public FruitProvider(String name){
        super(name);
    }

    static {
        LOGGER.info("Fruits arriving");
    }
}
