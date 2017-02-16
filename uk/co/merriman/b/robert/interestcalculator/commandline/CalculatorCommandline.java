package uk.co.merriman.b.robert.interestcalculator.commandline;

import uk.co.merriman.b.robert.interestcalculator.logic.InterestCalculator;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by robert.merriman on 16/02/2017.
 */
public class CalculatorCommandline
{

    public static void main(String[] args) {
        new CalculatorCommandline(); // Calls the constructor to start execution
    }

    /**
     * Starts the commandline calculator interface
     */
    public CalculatorCommandline() {
        String doubleError =  "Please enter a valid decimal number."; // Reused error text

        InterestCalculator calculator = new InterestCalculator();
        Scanner input = new Scanner(System.in); // Instantiate Scanner to use System.in for user input


        print("Interest Calculator\n");

        // Get all values needed from the user
        double loanAmount = getInputToDouble(input, "Enter the loan amount (£):", doubleError);
        print(formatGbpWithPrecision(loanAmount));
        double interestRate = getInputToDouble(input, "Enter the interest rate on your loan (%):", doubleError);
        print(interestRate + "%");
        double monthsBorrowed = getInputToDouble(input, "Enter the duration of the loan (months):", doubleError);
        print(monthsBorrowed + " months");

        // Calculate total
        double total = calculator.calculateInterest(loanAmount, interestRate, monthsBorrowed);

        // TODO stop using total and show per month

        // Format the total to GBP with more precision than to the nearest penny and print to the screen
        String formattedTotal = formatGbpWithPrecision(total);
        print("\nYour total loan cost is: " + formattedTotal);
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
