package enums;

public enum PaymentMethods {
    CREDIT_CARD("Credit Card", CostsRatesAndFees.FEE_LEVEL_THREE),
    DEBIT_CARD("Debit Card", CostsRatesAndFees.FEE_LEVEL_TWO),
    CASH("Cash", CostsRatesAndFees.FEE_LEVEL_ONE),
    MOBILE_PAYMENT("Mobile Payment", CostsRatesAndFees.FEE_LEVEL_FOUR);

    private final String DESCRIPTION;
    private final CostsRatesAndFees costsRatesAndFees;

    PaymentMethods(String DESCRIPTION, CostsRatesAndFees costsRatesAndFees){
        this.DESCRIPTION = DESCRIPTION;
        this.costsRatesAndFees = costsRatesAndFees;
    }

    public String getDESCRIPTION(){ return DESCRIPTION; }

    public CostsRatesAndFees getTransactionFee(){ return costsRatesAndFees; }

    public double calculateTransactionFee(double purchaseAmount, CostsRatesAndFees costsRatesAndFees){
        double payFee = costsRatesAndFees.getFEE();
        return payFee * purchaseAmount;
    }
}
