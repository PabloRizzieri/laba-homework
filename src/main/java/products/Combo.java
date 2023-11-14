package main.java.products;

import main.java.Supermarket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Combo extends Supermarket {
    private static final Logger LOGGER = LogManager.getLogger(Combo.class);


    private AppleProduct appleProduct;
    private CleaningProduct cleaningProduct;
    private MeatProduct meatProduct;
    private CerealProduct cerealProduct;
    private HashMap<Integer, String> comboDetails = new HashMap<>();

    private static Integer counter = 0;

    // Default constructor just in case
    public Combo(){
        this.cerealProduct = new CerealProduct("Default", 0, 0, "Default", null, 0);
        this.cleaningProduct = new CleaningProduct("Default", 0, 0, "Default", null, 0);
        this.appleProduct = new AppleProduct("Default", 0, 0, "Default", null, 0);
        this.meatProduct = new MeatProduct("Default", 0, 0, "Default", null, 0);
    }

    // Constructor for the class
    public Combo(String name, MeatProduct meatProduct, CerealProduct cerealProduct, AppleProduct appleProduct, CleaningProduct cleaningProduct){
        counter++;
        this.comboDetails.put(counter, name);
        this.meatProduct = meatProduct;
        this.cerealProduct = cerealProduct;
        this.appleProduct = appleProduct;
        this.cleaningProduct = cleaningProduct;
    }


    @Override
    public void printInfo(){
        super.printInfo();
        //Additional info about the combo
        LOGGER.info("This combo has: " + appleProduct.getNameProduct() + " " + cleaningProduct.getNameProduct() + " " + meatProduct.getNameProduct() + " " + cerealProduct.getNameProduct());
    }

    public static List<Product> createCombo(String name,Product... product){
        return new ArrayList<>(Arrays.asList(product));
    };

    public static LinkedList<Combo> createComboList(String name,Combo... combo){
        return new LinkedList<>(Arrays.asList(combo));
    };

    // Getter and setter of comboDetails
    public HashMap<Integer, String> getComboDetails() {return comboDetails;}
    public void setComboDetails(HashMap<Integer, String> comboDetails) {this.comboDetails = comboDetails;}

    public int getId(String name) {
        // Search ID associated with the name
        for (HashMap.Entry<Integer, String> entry : comboDetails.entrySet()) {
            if (entry.getValue().equals(name)) {
                return entry.getKey();
            }
        }
        // return -1 if the name doesn't exist on the map
        return -1;
    }

    public String getName(int id) {
        // Obtains the name with the associate Id
        return comboDetails.get(id);
    }


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
        return Objects.equals(getAppleProduct(), combo.getAppleProduct()) && Objects.equals(getCleaningProduct(), combo.getCleaningProduct()) && Objects.equals(getMeatProduct(), combo.getMeatProduct()) && Objects.equals(getCerealProduct(), combo.getCerealProduct()) && Objects.equals(getComboDetails(), combo.getComboDetails());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAppleProduct(), getCleaningProduct(), getMeatProduct(), getCerealProduct(), getComboDetails());
    }

    @Override
    public String toString() {
        return "Combo{" + '\n' +
                "appleProduct: " + appleProduct + '\n' +
                "cleaningProduct: " + cleaningProduct + '\n' +
                "meatProduct: " + meatProduct + '\n' +
                "cerealProduct: " + cerealProduct + '\n' +
                "comboId: " + comboDetails.keySet() + '\n' +
                "comboName: " + comboDetails.values() + '\n' +
                '}';
    }
}
