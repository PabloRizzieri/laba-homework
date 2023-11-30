package customLambdas;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import products.AppleProduct;
import products.CerealProduct;


import java.util.function.BinaryOperator;


public class LambdaProductSum {
    private static final Logger LOGGER = LogManager.getLogger(LambdaProductSum.class);

    public static void main(String[] args) {
        AppleProduct appleProduct = new AppleProduct("Apple", 25, 50, "Fruit", false, 39);
        CerealProduct cerealProduct = new CerealProduct("Honey Graham", 35, 99, "Cereals", true, 0);

        // Lambda function to sum the prices of two products
        BinaryOperator<Integer> sumPricesLambda = (product1, product2) -> product1 + product2;

        // Applying the lambda function to calculate the sum of prices
        int totalPrices = sumPricesLambda.apply(appleProduct.getPrice(), cerealProduct.getPrice());

        LOGGER.info(appleProduct.getPrice());
        LOGGER.info(cerealProduct.getPrice());

        LOGGER.info("Total Price of Products: $" + totalPrices);
    }
}

