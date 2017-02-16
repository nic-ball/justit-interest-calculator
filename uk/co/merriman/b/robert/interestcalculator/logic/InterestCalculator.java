package uk.co.merriman.b.robert.interestcalculator.logic;

/**
 *
 * Created by robert.merriman on 14/02/2017.
 */
public class InterestCalculator
{
    /**
     * Calculates the total interest from the given parameters
     *
     * @param loanAmount Original loan amount
     * @param interestRate Rate of interest, usually monthly or yearly
     * @param timeBorrowed Time the loan with last until it is paid off
     * @return The calculated total
     */
    public double calculateInterest(double loanAmount, double interestRate, double timeBorrowed) {
        return loanAmount + loanAmount * interestRate * timeBorrowed;
    }

}
