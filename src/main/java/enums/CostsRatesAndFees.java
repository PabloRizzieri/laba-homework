package enums;

public enum CostsRatesAndFees {
    FEE_LEVEL_ONE(0, 0,0),
    FEE_LEVEL_TWO(0.01, 0,0),
    FEE_LEVEL_THREE(0.025, 0,0),
    FEE_LEVEL_FOUR(0.03, 0,0),

    INTEREST_LEVEL_ONE(0, 0,0),
    INTEREST_LEVEL_TWO(0, 0.10,0),
    INTEREST_LEVEL_THREE(0, 0.20,0),
    INTEREST_LEVEL_FOUR(0, 0.30,0),

    COST_LEVEL_ONE(0,0, 9.99),
    COST_LEVEL_TWO(0,0,15.99),
    COST_LEVEL_THREE(0,0,20),
    COST_LEVEL_FOUR(0,0,25.99);





    private final double FEE;
    private final double INTEREST_RATE;
    private final double COST;

    CostsRatesAndFees(double FEE, double INTEREST_RATE, double COST){
        this.FEE = FEE;
        this.INTEREST_RATE = INTEREST_RATE;
        this.COST = COST;
    }

    public double getFEE(){ return FEE;}
    public double getINTEREST_RATE(){return INTEREST_RATE;}
    public double getCOST(){return COST;}
}
