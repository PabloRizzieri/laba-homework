package customLambdas;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import products.AppleProduct;
import products.CerealProduct;
import products.Product;

import java.util.function.Consumer;

public class LambdaProductInfo {
    private static final Logger LOGGER = LogManager.getLogger(LambdaProductInfo.class);

    public static void main(String[] args) {
        AppleProduct appleProduct = new AppleProduct("Apple", 25, 50, "Fruit", false, 39);
        CerealProduct cerealProduct = new CerealProduct("Honey Graham", 35, 99, "Cereals", true, 0);

        Consumer<Product> productInfoLambda = p -> {
            LOGGER.info("Product ID: " + p.getProductID());
            LOGGER.info("Name: " + p.getNameProduct());
            LOGGER.info("Price: $" + p.getPrice());
            LOGGER.info("Stock: " + p.getStock());
            LOGGER.info("Branch: " + p.getProductBranch());

            if (p.getHasDiscount()) {
                System.out.println("This product has a discount!");
            } else {
                System.out.println("No discount available for this product.");
            }

            LOGGER.info("----------------------");
        };

        productInfoLambda.accept(appleProduct);
        productInfoLambda.accept(cerealProduct);
    }
}
