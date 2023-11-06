package main.homework_october_26_2023;

public class CerealProduct extends Product{
    //Default constructor
    public CerealProduct(){}

    //New constructor using the inheritance to access the protected fields of Product
    public CerealProduct (String nameProduct, Integer productPrice, Integer productID, String productBranch, Boolean hasDiscount){
        this.nameProduct  = nameProduct;
        this.productPrice = productPrice;
        this.productID = productID;
        this.productBranch = productBranch;
        this.hasDiscount = hasDiscount;
    }

    @Override
    void printProductInfo(){
        System.out.println("Has discount:" + (hasDiscount ? "Yes" : "No"));
    }
}
