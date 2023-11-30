package functions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Consumer;

public class LambdaConsumerExample {
    private static final Logger LOGGER = LogManager.getLogger(LambdaConsumerExample.class);
    public static void main(String[] args) {
        Consumer<String> printUpperCase = str -> LOGGER.info(str.toUpperCase());
        printUpperCase.accept("hello world"); // Output: HELLO WORLD
    }
}
