package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class LoanRepaymentSummaryTest {
    private LoanRepaymentSummary loanRepaymentSummary;

    @BeforeEach
    void setUp() {
        // test data
        BigDecimal loanAmount = new BigDecimal("300000").setScale(2, RoundingMode.DOWN);
        BigDecimal loanInterest = new BigDecimal("5.5").setScale(2, RoundingMode.DOWN);
        BigDecimal loanDownPayment = new BigDecimal("30000").setScale(2, RoundingMode.DOWN);
        Integer loanTerm = 30;
        this.loanRepaymentSummary = new LoanRepaymentSummary(loanAmount, loanInterest, loanDownPayment, loanTerm);
    }

    @Test
    void testToString() {
        assertEquals("{monthlyPayment=1536.30, totalInterest=283068.00, totalPayment=553068.00}", loanRepaymentSummary.toString());
    }
}