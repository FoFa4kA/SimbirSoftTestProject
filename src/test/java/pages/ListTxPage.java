package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static util.ConvertDate.convertDateToRequiredFormat;
import static util.WriteDataToCsv.writeDataFromPageToCsv;

public class ListTxPage extends BasePage {


    public ListTxPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#anchor0")
    private WebElement firstTransaction;

    @FindBy(css = "#anchor1")
    private WebElement secondTransaction;

    @FindBy(css = "#anchor0 td:first-child")
    private WebElement firstTransactionDate;

    @FindBy(css = "#anchor0 td:nth-child(2)")
    private WebElement firstTransactionAmount;

    @FindBy(css = "#anchor0 td:last-child")
    private WebElement firstTransactionType;

    @FindBy(css = "#anchor1 td:first-child")
    private WebElement secondTransactionDate;

    @FindBy(css = "#anchor1 td:nth-child(2)")
    private WebElement secondTransactionAmount;

    @FindBy(css = "#anchor1 td:last-child")
    private WebElement secondTransactionType;

    @Step("Check for transactions in transaction history")
    public ListTxPage checkTransactions() {
        waitElementToBeVisible(firstTransaction);
        waitElementToBeVisible(secondTransaction);
        return this;
    }

    @Step("Getting transaction date, amount and type")
    private String getTransactionData(WebElement date, WebElement amount, WebElement type) {
        String formatDateValue = convertDateToRequiredFormat(date.getText());
        String amountValue = amount.getText();
        String typeValue = type.getText();
        return String.format("%s, %s, %s", formatDateValue, amountValue, typeValue);
    }

    @Step("Writing transaction information to .csv file")
    public void writeTransactionsDataToCsv() {
        String firstTransactionData = getTransactionData(firstTransactionDate, firstTransactionAmount,
                firstTransactionType);
        String secondTransactionData = getTransactionData(secondTransactionDate, secondTransactionAmount,
                secondTransactionType);
        writeDataFromPageToCsv(String.format("%s\n%s", firstTransactionData, secondTransactionData));
    }


}
