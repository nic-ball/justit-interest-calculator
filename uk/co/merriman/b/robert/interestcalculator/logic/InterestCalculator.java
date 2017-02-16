package uk.co.merriman.b.robert.interestcalculator.logic;

/**
 *
 * Created by robert.merriman on 14/02/2017.
 */
public class InterestCalculator {

    /**
     * Calculates the interest per period, total added interest and the total loan to pay back
     * from the input values in the Interest values class.
     *
     * @param values Container for input values and where the output values are appended
     * @return Class containing the original input and the newly calculated outputs
     */
    public InterestValues calculate(InterestValues values) {
        values.setInterestPerPeriod(values.getLoanAmount() * (values.getInterestRate() / 100));
        values.setPaymentPerPeriod(values.getInterestPerPeriod() + values.getLoanAmount() / values.getTimeBorrowed());
        values.setTotalAddedInterest(values.getInterestPerPeriod() * values.getTimeBorrowed());
        values.setTotalLoanPayment(values.getTotalAddedInterest() + values.getLoanAmount());

        return values;
    }

}
