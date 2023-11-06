package main.homework_november_02_2023.products;

public class AppleProduct extends Product {
    //Default constructor
    public AppleProduct(){};

    //New constructor using the inheritance to access the protected fields of Product
    public AppleProduct (String nameProduct, Integer productPrice, Integer productID, String productBranch, Boolean hasDiscount){
        this.nameProduct  = nameProduct;
        this.productPrice = productPrice;
        this.productID = productID;
        this.productBranch = productBranch;
        this.hasDiscount = hasDiscount;
    }


    // Overriding an abstract method
    @Override
    public void printProductInfo(){
        System.out.println("This product is " + nameProduct);
        System.out.println("The price of the product is " + productPrice);
    }

}
