package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class AccountPage extends BasePage {

    private final String inputCss = "input";

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    private final By depositButton = By.cssSelector("button[ng-click='deposit()']");
    private final By depositAmountInput = By.cssSelector(inputCss);
    private final By submitDepositButton = By.xpath("//button[text()='Deposit']");
    private final By withdrawlButton = By.cssSelector("button[ng-click='withdrawl()']");
    private final By withdrawlAmountInput = By.cssSelector(inputCss);
    private final By submitWithdrawlButton = By.xpath("//button[text()='Withdraw']");
    private final By balance = By.cssSelector("div strong.ng-binding:nth-child(2)");
    private final By transactionsButton = By.cssSelector("button[ng-click='transactions()']");

    @Step
    public AccountPage makeDeposit(String amount) {
        driver.findElement(depositButton).click();
        waitElementToBeVisible(driver.findElement(submitDepositButton));
        driver.findElement(depositAmountInput).sendKeys(amount);
        driver.findElement(submitDepositButton).click();
        return this;
    }

    @Step
    public AccountPage makeWithdrawl(String amount) {
        driver.findElement(withdrawlButton).click();
        waitElementToBeVisible(driver.findElement(submitWithdrawlButton));
        driver.findElement(withdrawlAmountInput).sendKeys(amount);
        driver.findElement(submitWithdrawlButton).click();
        return this;
    }

    @Step
    public AccountPage checkBalance(String expectedAmount) {
        assertEquals(driver.findElement(balance).getText(), expectedAmount);
        return this;
    }

    @Step
    public AccountPage clickTransactionsButton() {
        driver.findElement(transactionsButton).click();
        return this;
    }

    public AccountPage wait(int milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }
}
