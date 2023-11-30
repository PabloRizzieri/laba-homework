package enums;

public enum PaymentMethods {
    CREDIT_CARD("Credit Card", 0.05),
    DEBIT_CARD("Debit Card", 0.025),
    CASH("Cash", 0.0),
    MOBILE_PAYMENT("Mobile Payment", 0.03);

    private final String description;
    private final double transactionFee;

    PaymentMethods(String description, double transactionFee){
        this.description = description;
        this.transactionFee = transactionFee;
    }

    public String getDescription(){ return  description; }

    public double getTransactionFee(){ return transactionFee; }

    public double calculateTransactionFee(double purchaseAmount){
        return purchaseAmount * transactionFee;
    }
}
