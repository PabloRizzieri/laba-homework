package enums;

public enum Brands {
    MEAT("MEAT MARKET", "M1"),
    FRUITS("FRESH FRUITS", "F1"),
    CLEANING("CLEANING ESSENTIALS", "C1"),
    CEREALS("CEREAL CORNER", "C2");

    private final String displayName;
    private final String categoryCode;

    Brands(String displayName, String categoryCode){
        this.displayName = displayName;
        this.categoryCode = categoryCode;
    }

    public String getDisplayName() {return displayName;}

    public String getCategoryCode() {return categoryCode; }
}
