package transaction_verification;

import base.BaseTest;
import org.testng.annotations.Test;

import static constants.Constant.Urls.HOME_PAGE;
import static util.AddAttachment.getBytesAnnotationWithArgs;
import static util.DayOfMonth.getCurrentDayOfMonth;
import static util.FibonacciNumber.getFibonacciNumber;

public class TransactionVerificationTest extends BaseTest {

    @Test
    public void madeAndCheckTransactions() {
        basePage.open(HOME_PAGE);

        loginPage.clickCustomerLoginButton();

        customerPage
                .selectUser()
                .clickLoginButton();

        int currentDayOfMonth = getCurrentDayOfMonth();
        String fibonacciNumber = String.valueOf(getFibonacciNumber(currentDayOfMonth + 1));

        accountPage
                .makeDeposit(fibonacciNumber)
                .wait(1000)
                .makeWithdrawl(fibonacciNumber)
                .wait(1000)
                .checkBalance("0")
                .clickTransactionsButton();

        listTxPage
                .checkTransactions()
                .writeTransactionsDataToCsv();

        getBytesAnnotationWithArgs("transactions.csv");
    }
}
