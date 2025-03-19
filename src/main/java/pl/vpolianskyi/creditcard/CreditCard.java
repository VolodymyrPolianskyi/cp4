package pl.vpolianskyi.creditcard;

import java.math.BigDecimal;

public class CreditCard {

    public static final int CREDIT_THERSHOLD = 100;
    private final String cardNumber;
    private BigDecimal initialCredit;
    private BigDecimal balance;

    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getNumber() {
        return cardNumber;
    }

    public void assignCredit(BigDecimal initialCredit) {
        if(isCreditBelowThreshold(initialCredit)){
            throw new CreditBelowThresholdException();
        }

        if(isCreditAssigned()){
            throw new CreditCantBeAssignedTwice();
        }

        this.initialCredit = initialCredit;
        this.balance = initialCredit;
    }

    private boolean isCreditAssigned() {
        return this.initialCredit != null;
    }

    private static boolean isCreditBelowThreshold(BigDecimal initialCredit) {
        return BigDecimal.valueOf(CREDIT_THERSHOLD).compareTo(initialCredit) > 0;
    }

    public BigDecimal getInitialCredit() {
        return initialCredit;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void withdraw(BigDecimal amount) {
        if(this.balance.compareTo(amount) >= 0 ){
            this.balance = this.balance.subtract(amount);
        }else {
            throw new NotEnoughException();
        }

    }
}
