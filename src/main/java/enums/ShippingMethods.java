package enums;

public enum ShippingMethods {
    STANDARD("Standard Delivery", CostsRatesAndFees.COST_LEVEL_ONE),
    EXPRESS("Express Shipping", CostsRatesAndFees.COST_LEVEL_TWO),
    SAME_DAY("Same-Day Delivery", CostsRatesAndFees.COST_LEVEL_FOUR);

    private final String DISPLAY_NAME;
    private final CostsRatesAndFees COST;
    private final String TRACKING_NUMBER;

    ShippingMethods(String displayName, CostsRatesAndFees COST){
        this.DISPLAY_NAME = displayName;
        this.COST = COST;
        this.TRACKING_NUMBER = generateTrackingNumber();
    }

    public String getDISPLAY_NAME(){return DISPLAY_NAME;}
    public CostsRatesAndFees getCOST(){return COST;}
    public String getTRACKING_NUMBER(){return TRACKING_NUMBER;}

    public String generateTrackingNumber(){
        return "TN" + hashCode();
    }
}
