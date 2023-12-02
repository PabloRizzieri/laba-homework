package enums;

public enum Suppliers {
    MEAT("Meat Marker", BrandsCategory.CATEGORY_ONE),
    FRUITS("FRESH FRUITS", BrandsCategory.CATEGORY_THREE),
    CLEANING("CLEANING ESSENTIALS", BrandsCategory.CATEGORY_FOUR),
    CEREALS("CEREAL CORNER", BrandsCategory.CATEGORY_TWO);

    private final String displayName;
    private final BrandsCategory categoryCode;

    Suppliers(String displayName, BrandsCategory categoryCode){
        this.displayName = displayName;
        this.categoryCode = categoryCode;
    }

    public String getDisplayName() {return displayName;}

    public BrandsCategory getCategoryCode() {return categoryCode; }

    public void checkBrandCategory(){
        switch (categoryCode){
            case CATEGORY_ONE:
                System.out.println("Managing meat supplies");
                break;
            case CATEGORY_TWO:
                System.out.println("Managing cereals supplies");
                break;
            case CATEGORY_THREE:
                System.out.println("Managing fruits supplies");
                break;
            case CATEGORY_FOUR:
                System.out.println("Managing cleaning supplies");
                break;
            default:
                System.out.println("Unknown supplies");
        }

    }
}
