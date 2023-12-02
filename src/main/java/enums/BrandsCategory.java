package enums;

public enum BrandsCategory {
    CATEGORY_ONE("M1", BrandsNames.NAME_ONE),
    CATEGORY_TWO("C1", BrandsNames.NAME_FOUR),
    CATEGORY_THREE("F1", BrandsNames.NAME_TWO),
    CATEGORY_FOUR("D1", BrandsNames.NAME_THREE);

    private final String SECTOR;
    private final BrandsNames BRAND_NAME;

    BrandsCategory(String SECTOR, BrandsNames BRAND_NAME){
        this.SECTOR = SECTOR;
        this.BRAND_NAME = BRAND_NAME;
    }

    public String getSECTOR(){return SECTOR;}
    public BrandsNames getBRAND_NAME(){return BRAND_NAME;}

    public void printBrandInfo(){
        System.out.println("SECTOR: " + SECTOR);
        System.out.println("BRAND NAME: " + BRAND_NAME.getNAME());
    }
}
