package main.homework_october_26_2023;

public class CleaningProduct extends Product{
    //Default constructor
    public CleaningProduct(){};

    //New constructor using the inheritance to access the protected fields of Product
    public CleaningProduct (String nameProduct, Integer productPrice, Integer productID, String productBranch, Boolean hasDiscount){
        this.nameProduct  = nameProduct;
        this.productPrice = productPrice;
        this.productID = productID;
        this.productBranch = productBranch;
        this.hasDiscount = hasDiscount;
    }

    @Override
    void printProductInfo() {
        System.out.println("The price of this product is " + productPrice);
        System.out.println("It belong to the " + productBranch + " branch");
    }
}
