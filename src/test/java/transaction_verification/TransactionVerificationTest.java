package transaction_verification;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static util.AddAttachment.getBytesAnnotationWithArgs;
import static util.DayOfMonth.getCurrentDayOfMonth;
import static util.FibonacciNumber.getFibonacciNumber;
import static util.PropertiesUtil.getProp;

public class TransactionVerificationTest extends BaseTest {

    @Test

    @Epic(value = "Online bank")
    @Story(value = "LogIn and transactions")
    @Severity(value = SeverityLevel.CRITICAL)
    @Description(value = "The test logs in, makes transactions, checks the balance and writes transaction data to a file")
    public void madeAndCheckTransactions() {
        int currentDayOfMonthPlusOne = getCurrentDayOfMonth() + 1;
        String fibonacciNumber = String.valueOf(getFibonacciNumber(currentDayOfMonthPlusOne));
        String zeroBalance = "0";

        basePage.open(getProp("home_page"));

        loginPage.clickCustomerLoginButton()
                .selectUser()
                .clickLoginButton()
                .makeDeposit(fibonacciNumber)
                .makeWithdrawl(fibonacciNumber)
                .checkBalance(zeroBalance)
                .clickTransactionsButton()
                .checkTransactions()
                .writeTransactionsDataToCsv();

        getBytesAnnotationWithArgs("transactions.csv");
    }
}
