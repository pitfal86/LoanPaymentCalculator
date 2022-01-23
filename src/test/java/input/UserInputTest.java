package input;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.AppConstants;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class UserInputTest {
    private UserInput userInputPositiveScenarioOne;

    @BeforeEach
    void setUp() {
        // positive scenarios
        this.userInputPositiveScenarioOne = new UserInput("300000", "5.5", "30000", "30");
    }

    @Test
    void getLoanAmountPositiveScenarioOne() {
        // simulate input
        String userInput = String.format("300000%s5.5%s30000%s30",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        // invoke class
        UserInput newUserInput = new UserInput();

        // grab values from user
        String[] lines = baos.toString().split(System.lineSeparator());
        String userDisplayLoanAmount = lines[0];
        String userDisplayLoanInterestPercent = lines[1];
        String userDisplayLoanDownPayment = lines[2];
        String userDisplayLoanTermYears = lines[3];

        // assign test data
        BigDecimal testData = new BigDecimal(300000).setScale(2, RoundingMode.DOWN);

        // assert output displayed to user
        assertEquals(AppConstants.ENTER_LOAN_AMOUNT, userDisplayLoanAmount);
        assertEquals(AppConstants.ENTER_LOAN_INTEREST_PERCENT, userDisplayLoanInterestPercent);
        assertEquals(AppConstants.ENTER_LOAN_DOWN_PAYMENT, userDisplayLoanDownPayment);
        assertEquals(AppConstants.ENTER_LOAN_TERM_YEARS, userDisplayLoanTermYears);
        // assert value assigned correctly using default constructor
        assertEquals(newUserInput.getLoanAmount(), testData);
        // assert value assigned correctly using multi parameter constructor
        assertEquals(this.userInputPositiveScenarioOne.getLoanAmount(), testData);
    }

    @Test
    void getLoanAmountNegativeScenarioOne() {
        // simulate input
        String userInput = String.format("a4%s300000%s5.5%s30000%s30",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        // invoke class
        UserInput newUserInput = new UserInput();

        // grab values from user
        String[] lines = baos.toString().split(System.lineSeparator());
        String userDisplayLoanAmount = lines[0];
        String userError = lines[1];
        String userDisplayLoanInterestPercent = lines[2];
        String userDisplayLoanDownPayment = lines[3];
        String userDisplayLoanTermYears = lines[4];

        // assign test data
        BigDecimal testData = new BigDecimal(300000).setScale(2, RoundingMode.DOWN);

        // assert output displayed to user
        assertEquals(AppConstants.ENTER_LOAN_AMOUNT, userDisplayLoanAmount);
        assertEquals(AppConstants.INVALID_DOUBLE, userError);
        assertEquals(AppConstants.ENTER_LOAN_INTEREST_PERCENT, userDisplayLoanInterestPercent);
        assertEquals(AppConstants.ENTER_LOAN_DOWN_PAYMENT, userDisplayLoanDownPayment);
        assertEquals(AppConstants.ENTER_LOAN_TERM_YEARS, userDisplayLoanTermYears);
        // assert value assigned correctly using default constructor
        assertEquals(newUserInput.getLoanAmount(), testData);
        // assert value assigned correctly using multi parameter constructor
        assertEquals(this.userInputPositiveScenarioOne.getLoanAmount(), testData);
    }

    @Test
    void getLoanInterestPositiveScenarioOne() {
        // simulate user input
        String userInput = String.format("300000%s5.5%s30000%s30",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        // invoke class
        UserInput newUserInput = new UserInput();

        // grab values from system
        String[] lines = baos.toString().split(System.lineSeparator());
        String userDisplayLoanAmount = lines[0];
        String userDisplayLoanInterestPercent = lines[1];
        String userDisplayLoanDownPayment = lines[2];
        String userDisplayLoanTermYears = lines[3];

        // assign test data
        BigDecimal testData = new BigDecimal("5.5").setScale(2, RoundingMode.DOWN);
        // assert output displayed to user
        assertEquals(AppConstants.ENTER_LOAN_AMOUNT, userDisplayLoanAmount);
        assertEquals(AppConstants.ENTER_LOAN_INTEREST_PERCENT, userDisplayLoanInterestPercent);
        assertEquals(AppConstants.ENTER_LOAN_DOWN_PAYMENT, userDisplayLoanDownPayment);
        assertEquals(AppConstants.ENTER_LOAN_TERM_YEARS, userDisplayLoanTermYears);
        // assert value assigned correctly using default constructor
        assertEquals(newUserInput.getLoanInterest(), testData);
        // assert value assigned correctly using multi parameter constructor
        assertEquals(this.userInputPositiveScenarioOne.getLoanInterest(), testData);
    }

    @Test
    void getLoanInterestNegativeScenarioOne() {
        // simulate user input
        String userInput = String.format("300000%sa4%s5.5%s30000%s30",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        // invoke class
        UserInput newUserInput = new UserInput();

        // grab values from system
        String[] lines = baos.toString().split(System.lineSeparator());
        String userDisplayLoanAmount = lines[0];
        String userDisplayLoanInterestPercent = lines[1];
        String userDisplayError = lines[2];
        String userDisplayLoanDownPayment = lines[3];
        String userDisplayLoanTermYears = lines[4];

        // assign test data
        BigDecimal testData = new BigDecimal("5.5").setScale(2, RoundingMode.DOWN);
        // assert output displayed to user
        assertEquals(AppConstants.ENTER_LOAN_AMOUNT, userDisplayLoanAmount);
        assertEquals(AppConstants.ENTER_LOAN_INTEREST_PERCENT, userDisplayLoanInterestPercent);
        assertEquals(AppConstants.INVALID_DOUBLE, userDisplayError);
        assertEquals(AppConstants.ENTER_LOAN_DOWN_PAYMENT, userDisplayLoanDownPayment);
        assertEquals(AppConstants.ENTER_LOAN_TERM_YEARS, userDisplayLoanTermYears);
        // assert value assigned correctly using default constructor
        assertEquals(newUserInput.getLoanInterest(), testData);
        // assert value assigned correctly using multi parameter constructor
        assertEquals(this.userInputPositiveScenarioOne.getLoanInterest(), testData);
    }

    @Test
    void getLoanDownPaymentPositiveScenarioOne() {
        // simulate user input
        String userInput = String.format("300000%s5.5%s30000%s30",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        // invoke class
        UserInput newUserInput = new UserInput();

        // grab values from system
        String[] lines = baos.toString().split(System.lineSeparator());
        String userDisplayLoanAmount = lines[0];
        String userDisplayLoanInterestPercent = lines[1];
        String userDisplayLoanDownPayment = lines[2];
        String userDisplayLoanTermYears = lines[3];

        // assign test data
        BigDecimal testData = new BigDecimal("30000").setScale(2, RoundingMode.DOWN);
        // assert output displayed to user
        assertEquals(AppConstants.ENTER_LOAN_AMOUNT, userDisplayLoanAmount);
        assertEquals(AppConstants.ENTER_LOAN_INTEREST_PERCENT, userDisplayLoanInterestPercent);
        assertEquals(AppConstants.ENTER_LOAN_DOWN_PAYMENT, userDisplayLoanDownPayment);
        assertEquals(AppConstants.ENTER_LOAN_TERM_YEARS, userDisplayLoanTermYears);
        // assert value assigned correctly using default constructor
        assertEquals(newUserInput.getLoanDownPayment(), testData);
        // assert value assigned correctly using multi parameter constructor
        assertEquals(this.userInputPositiveScenarioOne.getLoanDownPayment(), testData);
    }

    @Test
    void getLoanDownPaymentNegativeScenarioOne() {
        // simulate user input
        String userInput = String.format("300000%s5.5%sa4%s30000%s30",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        // invoke class
        UserInput newUserInput = new UserInput();

        // grab values from system
        String[] lines = baos.toString().split(System.lineSeparator());
        String userDisplayLoanAmount = lines[0];
        String userDisplayLoanInterestPercent = lines[1];
        String userDisplayLoanDownPayment = lines[2];
        String userDisplayError = lines[3];
        String userDisplayLoanTermYears = lines[4];

        // assign test data
        BigDecimal testData = new BigDecimal("30000").setScale(2, RoundingMode.DOWN);
        // assert output displayed to user
        assertEquals(AppConstants.ENTER_LOAN_AMOUNT, userDisplayLoanAmount);
        assertEquals(AppConstants.ENTER_LOAN_INTEREST_PERCENT, userDisplayLoanInterestPercent);
        assertEquals(AppConstants.ENTER_LOAN_DOWN_PAYMENT, userDisplayLoanDownPayment);
        assertEquals(AppConstants.INVALID_DOUBLE, userDisplayError);
        assertEquals(AppConstants.ENTER_LOAN_TERM_YEARS, userDisplayLoanTermYears);
        // assert value assigned correctly using default constructor
        assertEquals(newUserInput.getLoanDownPayment(), testData);
        // assert value assigned correctly using multi parameter constructor
        assertEquals(this.userInputPositiveScenarioOne.getLoanDownPayment(), testData);
    }

    @Test
    void getLoanTermPositiveScenarioOne() {
        // simulate user input
        String userInput = String.format("300000%s5.5%s30000%s30",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        // invoke class
        UserInput newUserInput = new UserInput();

        // grab values from system
        String[] lines = baos.toString().split(System.lineSeparator());
        String userDisplayLoanAmount = lines[0];
        String userDisplayLoanInterestPercent = lines[1];
        String userDisplayLoanDownPayment = lines[2];
        String userDisplayLoanTermYears = lines[3];

        // assign test data
        Integer testData = 30;
        // assert output displayed to user
        assertEquals(AppConstants.ENTER_LOAN_AMOUNT, userDisplayLoanAmount);
        assertEquals(AppConstants.ENTER_LOAN_INTEREST_PERCENT, userDisplayLoanInterestPercent);
        assertEquals(AppConstants.ENTER_LOAN_DOWN_PAYMENT, userDisplayLoanDownPayment);
        assertEquals(AppConstants.ENTER_LOAN_TERM_YEARS, userDisplayLoanTermYears);
        // assert value assigned correctly using default constructor
        assertEquals(newUserInput.getLoanTerm(), testData);
        // assert value assigned correctly using multi parameter constructor
        assertEquals(this.userInputPositiveScenarioOne.getLoanTerm(), testData);
    }

    @Test
    void getLoanTermNegativeScenarioOne() {
        // simulate user input
        String userInput = String.format("300000%s5.5%s30000%sa4%s30",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        // invoke class
        UserInput newUserInput = new UserInput();

        // grab values from system
        String[] lines = baos.toString().split(System.lineSeparator());
        String userDisplayLoanAmount = lines[0];
        String userDisplayLoanInterestPercent = lines[1];
        String userDisplayLoanDownPayment = lines[2];
        String userDisplayLoanTermYears = lines[3];
        String userDisplayError = lines[4];

        // assign test data
        Integer testData = 30;
        // assert output displayed to user
        assertEquals(AppConstants.ENTER_LOAN_AMOUNT, userDisplayLoanAmount);
        assertEquals(AppConstants.ENTER_LOAN_INTEREST_PERCENT, userDisplayLoanInterestPercent);
        assertEquals(AppConstants.ENTER_LOAN_DOWN_PAYMENT, userDisplayLoanDownPayment);
        assertEquals(AppConstants.ENTER_LOAN_TERM_YEARS, userDisplayLoanTermYears);
        assertEquals(AppConstants.INVALID_INTEGER, userDisplayError);
        // assert value assigned correctly using default constructor
        assertEquals(newUserInput.getLoanTerm(), testData);
        // assert value assigned correctly using multi parameter constructor
        assertEquals(this.userInputPositiveScenarioOne.getLoanTerm(), testData);
    }
}