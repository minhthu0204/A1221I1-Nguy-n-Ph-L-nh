package FuramaResort.models;

public class Contract {
    private String contractNumber;
    private int bookingID;
    private int deposit;
    private int totalPaymentAmount;
    private int customerID;

    public Contract(String contractNumber, int bookingID, int deposit, int totalPaymentAmount, int customerID) {
        this.contractNumber = contractNumber;
        this.bookingID = bookingID;
        this.deposit = deposit;
        this.totalPaymentAmount = totalPaymentAmount;
        this.customerID = customerID;
    }

    public Contract() {
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getTotalPaymentAmount() {
        return totalPaymentAmount;
    }

    public void setTotalPaymentAmount(int totalPaymentAmount) {
        this.totalPaymentAmount = totalPaymentAmount;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
}
