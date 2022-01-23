package input;

import utils.AppConstants;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class UserInput {
    //class properties
    private BigDecimal loanAmount;
    private BigDecimal loanInterest;
    private BigDecimal loanDownPayment;
    private Integer loanYears;
    private final Scanner scanner = new Scanner(System.in);

    // constructor user input
    public UserInput() {
        // ask user for loan amount
        System.out.println(AppConstants.ENTER_LOAN_AMOUNT);
        setLoanAmount(this.scanner.nextLine());

        // ask user for loan interest
        System.out.println(AppConstants.ENTER_LOAN_INTEREST_PERCENT);
        setLoanInterest(this.scanner.nextLine());

        // ask user for loan down payment
        System.out.println(AppConstants.ENTER_LOAN_DOWN_PAYMENT);
        setLoanDownPayment(this.scanner.nextLine());

        // ask user for loan interest
        System.out.println(AppConstants.ENTER_LOAN_TERM_YEARS);
        setLoanTerm(this.scanner.nextLine());

        // end scanner session
        this.scanner.close();
    }

    // constructor file input
    public UserInput(String loanAmount, String loanInterest, String loanDownPayment, String loanYears) {
        setLoanAmount(loanAmount);
        setLoanInterest(loanInterest);
        setLoanDownPayment(loanDownPayment);
        setLoanTerm(loanYears);
    }

    // loan amount getter and setter
    private void setLoanAmount(String loanAmount) {
        // validate loan amount is a number
        if (loanAmount != null && loanAmount.matches("(\\-?\\d*\\.?\\d+)")){
            double validLoanAmount = Double.parseDouble(loanAmount);
            // assign the loan amount and round down
            this.loanAmount = BigDecimal.valueOf(validLoanAmount).setScale(2, RoundingMode.DOWN);
        } else {
            System.out.println(AppConstants.INVALID_DOUBLE);
            setLoanAmount(this.scanner.nextLine());
        }
    }
    public BigDecimal getLoanAmount() {
        return this.loanAmount;
    }
    // ********

    // loan interest getter and setter
    private void setLoanInterest(String loanInterest) {
        // validate loan interest is a number
        if (loanInterest != null && loanInterest.matches("(\\-?\\d*\\.?\\d+)")){
            double validLoanInterest = Double.parseDouble(loanInterest);
            // validate interest is less than 100%
            BigDecimal finalInterestValue = BigDecimal.valueOf(validLoanInterest).setScale(2, RoundingMode.DOWN);
            int compareValue = finalInterestValue.compareTo(BigDecimal.valueOf(AppConstants.MAX_INTEREST_RATE));
            if (compareValue > 0){
                System.out.println(AppConstants.INVALID_INTEREST_RATE);
                setLoanInterest(this.scanner.nextLine());
            } else {
                // assign the loan interest rate and round down
                this.loanInterest = finalInterestValue;
            }
        } else {
            System.out.println(AppConstants.INVALID_DOUBLE);
            setLoanInterest(this.scanner.nextLine());
        }
    }
    public BigDecimal getLoanInterest() {
        return this.loanInterest;
    }
    // ********

    // loan down payment getter and setter
    private void setLoanDownPayment(String loanDownPayment) {
        // validate loan down payment is a number
        if (loanDownPayment != null && loanDownPayment.matches("(\\-?\\d*\\.?\\d+)")){
            double validLoanDownPayment = Double.parseDouble(loanDownPayment);
            // validate down payment is lower than loan amount
            BigDecimal finalDownPaymentAmount = BigDecimal.valueOf(validLoanDownPayment).setScale(2, RoundingMode.DOWN);
            int compareValue = finalDownPaymentAmount.compareTo(this.loanAmount);
            if (compareValue > 0){
                System.out.println(AppConstants.INVALID_DOWN_PAYMENT);
                setLoanDownPayment(this.scanner.nextLine());
            } else {
                // assign the loan payment and round down
                this.loanDownPayment = finalDownPaymentAmount;
            }
        } else {
            System.out.println(AppConstants.INVALID_DOUBLE);
            setLoanDownPayment(this.scanner.nextLine());
        }
    }
    public BigDecimal getLoanDownPayment() {
        return this.loanDownPayment;
    }
    // ********

    // loan term getter and setter
    private void setLoanTerm(String loanTerm) {
        // validate loan amount is a number
        if (loanTerm != null && loanTerm.matches("(\\-?\\d*\\.?\\d+)")){
            // assign the loan amount and round down
            this.loanYears = Integer.valueOf(loanTerm);
        } else {
            System.out.println(AppConstants.INVALID_INTEGER);
            setLoanTerm(this.scanner.nextLine());
        }
    }
    public Integer getLoanTerm() {
        return this.loanYears;
    }
    // ********
}
