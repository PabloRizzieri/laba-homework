package main.java.products;

import main.java.staff.SupervisorEmployee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MeatProduct extends Product {
    private static final Logger LOGGER = LogManager.getLogger(MeatProduct.class);
    //Default constructor
    public MeatProduct(){};

    //New constructor using the inheritance to access the protected fields of Product
    public MeatProduct (String nameProduct, Integer productPrice, Integer productID, String productBranch, Boolean hasDiscount, Integer stock){
        super(nameProduct, productBranch, productID, productPrice, hasDiscount, stock);
    }


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
        return (int) (productPrice * 1.8);
    }
}
