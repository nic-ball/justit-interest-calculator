package uk.co.merriman.b.robert.interestcalculator.commandline;

import uk.co.merriman.b.robert.interestcalculator.logic.InterestCalculator;
import uk.co.merriman.b.robert.interestcalculator.logic.InterestValues;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by robert.merriman on 16/02/2017.
 */
public class CalculatorCommandline {

    public static void main(String[] args) {
        new CalculatorCommandline(); // Calls the constructor to start execution
    }

    /**
     * Starts the commandline calculator interface
     */
    public CalculatorCommandline() {

        print("Interest Calculator\n");

        InterestValues values = gatherInputValues();
        InterestCalculator calculator = new InterestCalculator();

        values = calculator.calculate(values);

        printOutputValues(values);
    }

    /**
     * Gathers all the input values needed by asking the user
     *
     * @return InterestValues wrapper to all required numbers
     */
    private InterestValues gatherInputValues() {
        String doubleError =  "Please enter a valid decimal number."; // Reused error text
        Scanner input = new Scanner(System.in); // Instantiate Scanner to use System.in for user input

        // Get all values needed from the user
        double loanAmount = getInputToDouble(input, "Enter the loan amount (£):", doubleError);
        print(formatGbpWithPrecision(loanAmount) + "\n");
        double interestRate = getInputToDouble(input, "Enter the monthly interest rate on your loan (%):", doubleError);
        print(interestRate + "%\n");
        double monthsBorrowed = getInputToDouble(input, "Enter the duration of the loan (months):", doubleError);
        print(monthsBorrowed + " months\n");

        return new InterestValues(loanAmount, interestRate, monthsBorrowed);

    }

    /**
     * Prints the output values
     *
     * @param values InterestValues wrapper for all calculated interest values
     */
    private void printOutputValues(InterestValues values) {
        print(""); // Spacer

        // Format values to GBP with more precision than to the nearest penny and print to the screen
        String formattedPerPeriod = formatGbpWithPrecision(values.getInterestPerPeriod());
        print("Interest per month: " + formattedPerPeriod);

        String formattedAddedInterest = formatGbpWithPrecision(values.getTotalAddedInterest());
        print("Total added interest to pay: " + formattedAddedInterest);

        String formattedPaymentPerPeriod = formatGbpWithPrecision(values.getPaymentPerPeriod());
        print("Monthly payment: " + formattedPaymentPerPeriod);

        String formattedTotal = formatGbpWithPrecision(values.getTotalLoanPayment());
        print("Total loan cost: " + formattedTotal);
    }


    /**
     * Alias for System.out.println()
     *
     * @param obj Object to print
     */
    private void print(Object obj) {
        System.out.println(obj);
    }

    /**
     * Prompts the user and returns the input
     *
     * @param scanner Input Scanner
     * @param prompt Text to prompt the user with
     * @return Input string
     */
    private String getInput(Scanner scanner, String prompt) {
        System.out.print(prompt); // Print without trailing newline so input is on the same line
        return scanner.nextLine();
    }

    /**
     * Checks if a String is all numeric
     *
     * @param str String to check is numeric
     * @return Boolean if it is numeric or not
     */
    private boolean isNumeric(String str)
    {
        return str.matches("-?\\d+(\\.\\d+)?"); // Matches a number with optional '-' and decimal.
    }

    /**
     * Using getInput and isNumeric, gets user input as a String and keeps prompting them to enter
     * a valid number until they do
     *
     * @param scanner Input Scanner
     * @param prompt Text to prompt the user with
     * @param errorText Text to show the user on unsuccessful conversion
     * @return The input number
     */
    private double getInputToDouble(Scanner scanner, String prompt, String errorText) {

        // Ensure a space at the end of the prompt
        String promptWithSpace = prompt;
        if (prompt.charAt(prompt.length() - 1) != ' ') {
            promptWithSpace = prompt + " ";
        }

        // Get input and cast to number
        String numStr;
        double numD;
        while (true) {
            // Get input string with prompt
            numStr = getInput(scanner, promptWithSpace);

            // If numStr is a number, cast it and break
            // Otherwise print an error and try again
            if (isNumeric(numStr)) {
                numD = Double.parseDouble(numStr);
                break;
            } else {
                print(errorText);
            }
        }

        return numD; // return successfully converted number
    }

    /**
     * Formats an inputted double to look with GBP
     * however it doesn't round after 2dp so you can have more precison
     *
     * @param num Number to format
     * @return Formatted number, including leading '£'
     */
    private String formatGbpWithPrecision(double num) {
        NumberFormat formatter = NumberFormat.getInstance(Locale.UK);
        formatter.setMinimumFractionDigits(2);
        return "£" + formatter.format(num);
    }

}
