package functions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

public class LambdaSupplierExample {
    private static final Logger LOGGER = LogManager.getLogger(LambdaSupplierExample.class);
    public static void main(String[] args) {
        Supplier<Double> randomNumber = () -> Math.random();
        LOGGER.info(randomNumber.get()); // Output: Random double value
    }
}
