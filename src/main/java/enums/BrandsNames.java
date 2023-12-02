package enums;

public enum BrandsNames {
    NAME_ONE("Meat Marker"),
    NAME_TWO("Fresh Fruits"),
    NAME_THREE("Cleaning Essentials"),
    NAME_FOUR("Cereal Corner");

    private final String NAME;

    BrandsNames(String NAME){
        this.NAME = NAME;
    }

    public String getNAME(){return NAME;}
}
