package functions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import products.AppleProduct;

import java.util.function.BiFunction;

public class LamdaBiFunctionExample {
        private static final Logger LOGGER = LogManager.getLogger(LamdaBiFunctionExample.class);
        public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
        LOGGER.info(sum.apply(5, 7)); // Output: 12
    }
}
