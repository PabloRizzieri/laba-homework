package enums;

public enum ClientDebtType {
    CREDIT_CARD_DEBT("Credit Card Debt", 0.25),
    LOAN_DEBT("Loan Debt", 0.16),
    OVERDRAFT("OVERDRAFT", 0.35);

    private final String description;
    private final double interestRate;

    ClientDebtType(String description, double interestRate){
        this.description = description;
        this.interestRate = interestRate;
    }

    public String getDescription() { return description; }
    public double getInterestRate() { return interestRate; }

    public double calculateInterest(double debtAmount){
        return debtAmount * interestRate;
    }
}
