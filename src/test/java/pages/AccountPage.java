package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;

public class AccountPage extends BasePage {

    private final String inputCss = "input";

    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "button[ng-click='deposit()']")
    private WebElement depositButton;

    @FindBy(css = inputCss)
    private WebElement depositAmountInput;

    @FindBy(xpath = "//button[text()='Deposit']")
    private WebElement submitDepositButton;

    @FindBy(css = "button[ng-click='withdrawl()']")
    private WebElement withdrawlButton;

    @FindBy(css = inputCss)
    private WebElement withdrawlAmountInput;

    @FindBy(xpath = "//button[text()='Withdraw']")
    private WebElement submitWithdrawlButton;

    @FindBy(css = "div strong.ng-binding:nth-child(2)")
    private WebElement balance;

    @FindBy(css = "button[ng-click='transactions()']")
    private WebElement transactionsButton;

    @Step("Account replenishment by {amount}")
    public AccountPage makeDeposit(String amount) {
        waitElementToBeVisible(depositButton);
        depositButton.click();
        waitElementToBeVisible(depositAmountInput);
        depositAmountInput.sendKeys(amount);
        waitElementToBeVisible(submitDepositButton);
        submitDepositButton.click();
        return this;
    }

    @Step("Write-off from account {amount}")
    public AccountPage makeWithdrawl(String amount) {
        waitElementToBeVisible(withdrawlButton);
        withdrawlButton.click();
        waitElementToBeVisible(withdrawlAmountInput);
        withdrawlAmountInput.sendKeys(amount);
        waitElementToBeVisible(submitWithdrawlButton);
        submitWithdrawlButton.click();
        return this;
    }

    @Step("Check that the balance amount is {expectedAmount}")
    public AccountPage checkBalance(String expectedAmount) {
        assertEquals(balance.getText(), expectedAmount);
        return this;
    }

    @Step("Click 'Transaction' button")
    public ListTxPage clickTransactionsButton() {
        waitElementToBeVisible(transactionsButton);
        transactionsButton.click();
        return new ListTxPage(driver);
    }
}
