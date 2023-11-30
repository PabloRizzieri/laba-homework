package enums;

public enum ShippingMethods {
    STANDARD("Standard Delivery", 9.99),
    EXPRESS("Express Shipping", 18.99),
    SAME_DAY("Same-Day Delivery", 25.99);

    private final String displayName;
    private final double cost;
    private final String trackingNumber;

    ShippingMethods(String displayName, double cost){
        this.displayName = displayName;
        this.cost = cost;
        this.trackingNumber = generateTrackingNumber();
    }

    public String getDisplayName(){return displayName;}
    public double getCost(){return cost;}
    public String getTrackingNumber(){return trackingNumber;}

    private String generateTrackingNumber(){
        return "TN" + hashCode();
    }
}
