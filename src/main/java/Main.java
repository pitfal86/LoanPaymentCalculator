import calculator.LoanRepaymentSummary;
import input.UserInput;

public class Main {

    public static void main(String[] args) {
        UserInput userInput = new UserInput();

        LoanRepaymentSummary loanRepaymentSummary = new LoanRepaymentSummary(
                userInput.getLoanAmount(),
                userInput.getLoanInterest(),
                userInput.getLoanDownPayment(),
                userInput.getLoanTerm());
        System.out.println(loanRepaymentSummary);
    }
}
