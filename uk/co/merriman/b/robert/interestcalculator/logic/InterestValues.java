package uk.co.merriman.b.robert.interestcalculator.logic;

/**
 * Created by robert.merriman on 16/02/2017.
 */
public class InterestValues {

    // Input vars
    private double loanAmount;
    private double interestRate;
    private double timeBorrowed;

    // Output vars
    private double interestPerPeriod;
    private double paymentPerPeriod;
    private double totalAddedInterest;
    private double totalLoanPayment;

    // Constructor for input
    public InterestValues(double loanAmount, double interestRate, double timeBorrowed) {
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.timeBorrowed = timeBorrowed;
    }

    // Getters for input
    public double getLoanAmount() {
        return loanAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double getTimeBorrowed() {
        return timeBorrowed;
    }


    public double getInterestPerPeriod() {
        return interestPerPeriod;
    }
    void setInterestPerPeriod(double interestPerPeriod) {
        this.interestPerPeriod = interestPerPeriod;
    }

    public double getPaymentPerPeriod() {
        return paymentPerPeriod;
    }

    void setPaymentPerPeriod(double paymentPerPeriod) {
        this.paymentPerPeriod = paymentPerPeriod;
    }

    public double getTotalAddedInterest() {
        return totalAddedInterest;
    }
    void setTotalAddedInterest(double totalAddedInterest) {
        this.totalAddedInterest = totalAddedInterest;
    }

    public double getTotalLoanPayment() {
        return totalLoanPayment;
    }
    void setTotalLoanPayment(double totalLoanPayment) {
        this.totalLoanPayment = totalLoanPayment;
    }
}
