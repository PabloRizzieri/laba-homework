package main.java.products;

import main.exceptions.InvalidBranchException;
import main.exceptions.InvalidIDException;
import main.exceptions.NoPriceException;

import java.util.Objects;

public abstract class Product {


    protected Integer productPrice;
    protected Integer productID;
    protected String productBranch;
    protected Boolean hasDiscount;
    protected String nameProduct;

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


    public Product(){
        nameProduct = "Default";
        productBranch = "Default";
        productID = 0;
        productPrice = 0;
        hasDiscount = null;
    }

    void printProductInfo(){};


    // Creating the hash and equals override for using it on the child classes (in this example makes the products that has the same ID and price get the same hash)
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
                "productPrice=" + productPrice +
                ", productID=" + productID +
                ", productBranch='" + productBranch + '\'' +
                ", hasDiscount=" + hasDiscount +
                ", nameProduct='" + nameProduct + '\'' +
                '}';
    }

    public void validateProductID()throws InvalidIDException {
        if (productID < 0){
            throw new InvalidIDException("Invalid product ID");
        }
        System.out.println("Product ID valid");
    }

    public void validatePrice() throws NoPriceException{
        if (productPrice <= 0){
            throw new NoPriceException("The product has no price");
        }
        System.out.println("The product has a valid price");
    }

    public void validateBranch() throws InvalidBranchException{
        if (productBranch == null){
            throw new InvalidBranchException("Invalid branch");
        }
        System.out.println("The product exist on a valid branch");
    }
}
