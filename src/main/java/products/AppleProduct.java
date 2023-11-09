package main.java.products;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AppleProduct extends Product {
    private static final Logger LOGGER = LogManager.getLogger(AppleProduct.class);
    //Default constructor
    public AppleProduct(){};

    //New constructor using the inheritance to access the protected fields of Product
    public AppleProduct (String nameProduct, Integer productPrice, Integer productID, String productBranch, Boolean hasDiscount, Integer stock){
        super(nameProduct, productBranch, productID, productPrice, hasDiscount, stock);
    }


    // Overriding an abstract method
    @Override
    public void printProductInfo(){
        LOGGER.info("This product has the next details " + '\n' +
                 "Name: " + nameProduct + '\n' +
                 "Price: " + productPrice + '\n' +
                 "Stock: " + stock + '\n' +
                 "ID: " + productID + '\n' +
                 "Branch: " + productBranch + '\n' +
                 "Has discount: " + (hasDiscount ? "Yes" : "No"));
    }

    @Override
    public int getPrice(){
        return (int) (productPrice * 1.2);
    }

}
