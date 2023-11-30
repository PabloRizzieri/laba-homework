package functions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Function;

public class LambdaFunctionExample {
    private static final Logger LOGGER = LogManager.getLogger(LambdaFunctionExample.class);
    public static void main(String[] args) {
        Function<Integer, String> intToString = num -> "Number: " + num;
        LOGGER.info(intToString.apply(42)); // Output: Number: 42
    }
}