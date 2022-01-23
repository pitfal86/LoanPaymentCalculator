package calculator;

import utils.AppConstants;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LoanRepaymentSummary {
    // class properties for user
    private BigDecimal monthlyPayment;
    private BigDecimal totalInterest;
    private BigDecimal totalPayment;
    // class properties for formula
    private int totalPaymentPeriods;
    private BigDecimal principalAmount;

    // constructor
    public LoanRepaymentSummary(
            BigDecimal loanAmount,
            BigDecimal loanInterest,
            BigDecimal loanDownPayment,
            Integer loanTerm) {
        setMonthlyPayment(loanInterest, loanAmount, loanDownPayment, loanTerm);
        setTotalPayment();
        setTotalInterest();
    }

    // monthly payment setter
    private void setMonthlyPayment(BigDecimal loanInterest, BigDecimal loanAmount, BigDecimal loanDownPayment, Integer loanTerm) {
        // *****Amortized calculation******
        // Change percent to decimal
        BigDecimal loanInterestConvert = loanInterest.divide(BigDecimal.valueOf(100), AppConstants.MAX_DECIMAL_POINTS, RoundingMode.CEILING);
        // Calculate interest rate per pay period
        BigDecimal interestRatePerPayPeriod = loanInterestConvert.divide(BigDecimal.valueOf(12), AppConstants.MAX_DECIMAL_POINTS, RoundingMode.CEILING);
        // Calculate and set total number of pay periods
        this.totalPaymentPeriods = loanTerm * 12;
        // Calculate decimal of interest rate plus 1
        BigDecimal ratePlusOne = interestRatePerPayPeriod.add(BigDecimal.valueOf(1));
        // Calculate rate plus one to the power of total number of pay periods
        BigDecimal rateToPowerPayPeriods = ratePlusOne.pow(this.totalPaymentPeriods);
        // Calculate interest rate multiplied by rate to power pay periods
        BigDecimal rateTimesRateToPowerPeriods = interestRatePerPayPeriod.multiply(rateToPowerPayPeriods);
        // Calculate rate to power pay periods minus 1
        BigDecimal rateToPowerPayPeriodMinusOne = rateToPowerPayPeriods.subtract(BigDecimal.valueOf(1));
        // Calculate sum left side of equation divided by sum right of equation
        BigDecimal sumLeftDivideBySumRight = rateTimesRateToPowerPeriods.divide(rateToPowerPayPeriodMinusOne, AppConstants.MAX_DECIMAL_POINTS, RoundingMode.CEILING);
        // Calculate principal amount by subtracting loan amount from down payment
        this.principalAmount = loanAmount.subtract(loanDownPayment);
        // Calculate monthly payment by multiplying principal by final sum amortized equation
        this.monthlyPayment = sumLeftDivideBySumRight.multiply(principalAmount).setScale(2, RoundingMode.DOWN);
    }
    // *******

    // total payment setter
    private void setTotalPayment () {
        this.totalPayment = this.monthlyPayment.multiply(BigDecimal.valueOf(this.totalPaymentPeriods)).setScale(2, RoundingMode.DOWN);
    }
    // *******

    // total interest setter
    private void setTotalInterest() {
        this.totalInterest = this.totalPayment.subtract(this.principalAmount).setScale(2, RoundingMode.DOWN);
    }
    // *******

    // json returned value to user
    @Override
    public String toString() {
        return "{" +
                "monthlyPayment=" + monthlyPayment +
                ", totalInterest=" + totalInterest +
                ", totalPayment=" + totalPayment +
                '}';
    }
}
