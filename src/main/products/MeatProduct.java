package main.products;

public class MeatProduct extends Product {
    //Default constructor
    public MeatProduct(){};

    //New constructor using the inheritance to access the protected fields of Product
    public MeatProduct (String nameProduct, Integer productPrice, Integer productID, String productBranch, Boolean hasDiscount){
        this.nameProduct  = nameProduct;
        this.productPrice = productPrice;
        this.productID = productID;
        this.productBranch = productBranch;
        this.hasDiscount = hasDiscount;
    }
}
