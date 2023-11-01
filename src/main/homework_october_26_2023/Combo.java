package main.homework_october_26_2023;

public class Combo extends Supermarket{


    private AppleProduct appleProduct;
    private CleaningProduct cleaningProduct;
    private MeatProduct meatProduct;
    private CerealProduct cerealProduct;
    private Integer comboID;
    private String comboName;

    // Default constructor just in case
    public Combo(){
        this.comboID = 0;
        this.comboName = "Default";
        this.cerealProduct = new CerealProduct("Default");
        this.cleaningProduct = new CleaningProduct("Default");
        this.appleProduct = new AppleProduct("Default");
        this.meatProduct = new MeatProduct("Default");
    }

    // Constructor for the class
    public Combo(String name, String location, String comboName, Integer comboID, MeatProduct meatProduct, CerealProduct cerealProduct, AppleProduct appleProduct, CleaningProduct cleaningProduct){
        super(name, location);
        this.comboID = comboID;
        this.comboName = comboName;
        this.cerealProduct = cerealProduct;
        this.cleaningProduct = cleaningProduct;
        this.meatProduct = meatProduct;
        this.appleProduct = appleProduct;
    }

    @Override
    public void printInfo(){
        super.printInfo();
        //Additional info about the combo
        System.out.println("This combo has: " + appleProduct.getName() + " " + cleaningProduct.getName() + " " + meatProduct.getName() + " " + cerealProduct.getName());
    }

    // Getter and setter of productID
    public Integer getComboID() {return comboID;}
    public void setComboID(Integer comboID) {this.comboID = comboID;}

    //Getter and setter of sectorProduct
    public String getComboName() {return comboName;}
    public void setComboName(String comboName) {this.comboName = comboName;}


    //Getter and setter of Apple
    public AppleProduct getAppleProduct() {return appleProduct;}
    public void setAppleProduct(AppleProduct appleProduct) {this.appleProduct = appleProduct;}


    //Getter and setter of Cleaning
    public CleaningProduct getCleaningProduct() {return cleaningProduct;}
    public void setCleaningProduct(CleaningProduct cleaningProduct) {this.cleaningProduct = cleaningProduct;}


    //Getter and setter of Meat
    public MeatProduct getMeatProduct() {return meatProduct;}
    public void setMeatProduct(MeatProduct meatProduct) {this.meatProduct = meatProduct;}


    //Getter and setter of Cereal
    public CerealProduct getCerealProduct() {return cerealProduct;}
    public void setCerealProduct(CerealProduct cerealProduct) {this.cerealProduct = cerealProduct;}






}
