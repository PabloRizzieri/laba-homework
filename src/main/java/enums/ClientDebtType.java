package enums;

public enum ClientDebtType {
    CREDIT_CARD_DEBT("Credit Card Debt", CostsRatesAndFees.INTEREST_LEVEL_TWO),
    LOAN_DEBT("Loan Debt", CostsRatesAndFees.INTEREST_LEVEL_THREE),
    OVERDRAFT("OVERDRAFT", CostsRatesAndFees.INTEREST_LEVEL_FOUR);

    private final String DESCRIPTION;
    private final CostsRatesAndFees interestRate;

    ClientDebtType(String description, CostsRatesAndFees interestRate){
        this.DESCRIPTION = description;
        this.interestRate = interestRate;
    }

    public String getDESCRIPTION() { return DESCRIPTION; }
    public CostsRatesAndFees getInterestRate() { return interestRate; }

    public double calculateInterest(double debtAmount, CostsRatesAndFees interestRate){
        double rate = interestRate.getINTEREST_RATE();
        return debtAmount * rate;
    }
}
