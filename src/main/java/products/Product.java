package products;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exceptions.InvalidBranchException;
import exceptions.InvalidIDException;
import exceptions.NoPriceException;
import exceptions.NoStockException;
import interfaces.Priceable;
import interfaces.Stockeable;


public abstract class Product implements Stockeable, Priceable {

    private static final Logger LOGGER = LogManager.getLogger(Product.class);


    protected Integer productPrice;
    protected Integer productID;
    protected String productBranch;
    protected Boolean hasDiscount;
    protected String nameProduct;
    protected int stock;

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getProductBranch() {
        return productBranch;
    }

    public void setProductBranch(String productBranch) {
        this.productBranch = productBranch;
    }

    public Boolean getHasDiscount() {
        return hasDiscount;
    }

    public void setHasDiscount(Boolean hasDiscount) {
        this.hasDiscount = hasDiscount;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    public Product(){}

    public Product(String nameProduct, String productBranch, Integer productID, Integer productPrice, Boolean hasDiscount, Integer stock){
        this.nameProduct = nameProduct;
        this.productBranch = productBranch;
        this.productID = productID;
        this.productPrice = productPrice;
        this.hasDiscount = hasDiscount;
        this.stock = stock;
    }

    void printProductInfo(){};


    // Creating the hash and equals override for using it on the child classes (in this example makes the com.solvd.products that has the same ID and price get the same hash)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(getProductPrice(), product.getProductPrice()) && Objects.equals(getProductID(), product.getProductID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductPrice(), getProductID());
    }

    @Override
    public String toString() {
        return "Product{" +
                "productPrice:" + productPrice + " - " +
                "productID:" + productID + " - " +
                "productBranch:" + productBranch + " - " +
                "hasDiscount:" + hasDiscount + " - " +
                "nameProduct:'" + nameProduct + "'" + " - " +
                "Stock: " + stock +
                '}';
    }




    @Override
    public boolean isStockeable(){
        return stock > 0;
    }

    @Override
    public boolean isPriceable(){
        return isStockeable();
    }


    public void validateProductID()throws InvalidIDException {
        if (productID < 0){
            throw new InvalidIDException("Invalid product ID");
        }
        LOGGER.info("Product ID valid");
    }

    public void validatePrice() throws NoPriceException, NoStockException {
        if (productPrice <= 0){
            throw new NoPriceException("The product has no price");
        } else if (stock <= 0) {
            throw new NoStockException("The product has no stock so it's not priceable");
        }
        LOGGER.info("The product has a valid price");
    }

    public void validateBranch() throws InvalidBranchException {
        if (productBranch == null){
            throw new InvalidBranchException("Invalid branch");
        }
        LOGGER.info("The product exist on a valid branch");
    }
}
