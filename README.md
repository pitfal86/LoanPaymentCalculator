#LoanPaymentCalculator
This application is used to take inputs related to a loan and calculate the monthly payments required, the total interest you will pay, and the payment total you will make once the loan is complete.

## Running
```
IntelliJ IDE is preferred for running this application.

Run the application 'Main' (src > main > java > Main) 
method and you will be presented with 4 questions 
(seen below). Amounts must be entered as whole numbers 
or decimals except for yearsthat must only be a 
whole number. You will then get an output in JSON 
format with monthlyPayments, totalInterest,and totalPayment.

EX:
/Library/Java/JavaVirtualMachines/amazon-corretto-11.jdk/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=56153:/Applications/IntelliJ IDEA CE.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Users/thomasarchuleta/IdeaProjects/LoanPaymentCalculator/target/classes Main

Enter loan amount: 
300000
Enter loan interest percent: 
5.5
Enter loan down payment: 
30000
Enter loan term in years: 
30
{monthlyPayment=1536.30, totalInterest=283068.00, totalPayment=553068.00}
```

## Configuring
```
This application can be configured to handle decimal precision
using the 'AppConstants' class (src > main > java > 
utils > AppConstants) to achieve the users desired configuration.
Below are the default values that can be altered.

EX: 

    // Configuration values
    public static final int MAX_INTEREST_RATE = 100;
    public static final int MAX_DECIMAL_POINTS = 5;

```

## Testing
```
Run the application @Test (src > test > java > ...) 
annotations, or use IntelliJ IDE to run the entire class.

EX:

/Library/Java/JavaVirtualMachines/amazon-corretto-11.jdk/Contents/Home/bin/java -ea -Didea.test.cyclic.buffer.size=1048576 -javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=56150:/Applications/IntelliJ IDEA CE.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Users/thomasarchuleta/.m2/repository/org/junit/platform/junit-platform-launcher/1.8.2/junit-platform-launcher-1.8.2.jar:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar:/Applications/IntelliJ IDEA CE.app/Contents/plugins/junit/lib/junit5-rt.jar:/Applications/IntelliJ IDEA CE.app/Contents/plugins/junit/lib/junit-rt.jar:/Users/thomasarchuleta/IdeaProjects/LoanPaymentCalculator/target/test-classes:/Users/thomasarchuleta/IdeaProjects/LoanPaymentCalculator/target/classes:/Users/thomasarchuleta/.m2/repository/org/junit/jupiter/junit-jupiter-engine/5.8.2/junit-jupiter-engine-5.8.2.jar:/Users/thomasarchuleta/.m2/repository/org/junit/platform/junit-platform-engine/1.8.2/junit-platform-engine-1.8.2.jar:/Users/thomasarchuleta/.m2/repository/org/opentest4j/opentest4j/1.2.0/opentest4j-1.2.0.jar:/Users/thomasarchuleta/.m2/repository/org/junit/platform/junit-platform-commons/1.8.2/junit-platform-commons-1.8.2.jar:/Users/thomasarchuleta/.m2/repository/org/junit/jupiter/junit-jupiter-api/5.8.2/junit-jupiter-api-5.8.2.jar:/Users/thomasarchuleta/.m2/repository/org/apiguardian/apiguardian-api/1.1.2/apiguardian-api-1.1.2.jar:/Users/thomasarchuleta/.m2/repository/org/mockito/mockito-core/4.2.0/mockito-core-4.2.0.jar:/Users/thomasarchuleta/.m2/repository/net/bytebuddy/byte-buddy/1.12.4/byte-buddy-1.12.4.jar:/Users/thomasarchuleta/.m2/repository/net/bytebuddy/byte-buddy-agent/1.12.4/byte-buddy-agent-1.12.4.jar:/Users/thomasarchuleta/.m2/repository/org/objenesis/objenesis/3.2/objenesis-3.2.jar com.intellij.rt.junit.JUnitStarter -ideVersion5 -junit5 calculator.LoanRepaymentSummaryTest

Process finished with exit code 0
```

