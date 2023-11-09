package main.java.products;

import main.java.Supermarket;
import main.java.staff.SupervisorEmployee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Combo extends Supermarket {
    private static final Logger LOGGER = LogManager.getLogger(Combo.class);


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
        this.cerealProduct = new CerealProduct("Default", 0, 0, "Default", null, 0);
        this.cleaningProduct = new CleaningProduct("Default", 0, 0, "Default", null, 0);
        this.appleProduct = new AppleProduct("Default", 0, 0, "Default", null, 0);
        this.meatProduct = new MeatProduct("Default", 0, 0, "Default", null, 0);
    }

    // Constructor for the class
    public Combo(String comboName, Integer comboID, MeatProduct meatProduct, CerealProduct cerealProduct, AppleProduct appleProduct, CleaningProduct cleaningProduct){
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
        LOGGER.info("This combo has: " + appleProduct.getNameProduct() + " " + cleaningProduct.getNameProduct() + " " + meatProduct.getNameProduct() + " " + cerealProduct.getNameProduct());
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Combo combo)) return false;
        return Objects.equals(getAppleProduct(), combo.getAppleProduct()) && Objects.equals(getCleaningProduct(), combo.getCleaningProduct()) && Objects.equals(getMeatProduct(), combo.getMeatProduct()) && Objects.equals(getCerealProduct(), combo.getCerealProduct()) && Objects.equals(getComboID(), combo.getComboID()) && Objects.equals(getComboName(), combo.getComboName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAppleProduct(), getCleaningProduct(), getMeatProduct(), getCerealProduct(), getComboID(), getComboName());
    }

    @Override
    public String toString() {
        return "Combo{" + '\n' +
                "appleProduct: " + appleProduct + '\n' +
                "cleaningProduct: " + cleaningProduct + '\n' +
                "meatProduct: " + meatProduct + '\n' +
                "cerealProduct: " + cerealProduct + '\n' +
                "comboID: " + comboID + '\n' +
                "comboName: " + comboName +
                '}';
    }
}
