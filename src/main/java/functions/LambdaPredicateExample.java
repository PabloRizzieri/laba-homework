package functions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Predicate;

public class LambdaPredicateExample {
    private static final Logger LOGGER = LogManager.getLogger(LambdaPredicateExample.class);
    public static void main(String[] args) {
        Predicate<Integer> isEven = num -> num % 2 == 0;
        LOGGER.info(isEven.test(4)); // Output: true
        LOGGER.info(isEven.test(5)); // Output: false
    }
}
