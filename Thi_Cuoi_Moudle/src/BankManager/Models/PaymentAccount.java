package BankManager.Models;

public class PaymentAccount extends Account{
    private int cardNumber;
    private double cash;

    public PaymentAccount(int id, String code, String name, String dateOpen, int cardNumber, double cash) {
        super(id, code, name, dateOpen);
        this.cardNumber = cardNumber;
        this.cash = cash;
    }

    public PaymentAccount(int cardNumber, double cash) {
        this.cardNumber = cardNumber;
        this.cash = cash;
    }

    public PaymentAccount() {
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    @Override
    public String toString() {
        return super.toString()+ cardNumber +","+cash;
    }
}
