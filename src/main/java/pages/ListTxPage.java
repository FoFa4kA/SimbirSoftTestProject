package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static util.ConvertDate.convertDateToRequiredFormat;
import static util.WriteDataToCsv.writeDataFromPageToCsv;

public class ListTxPage extends BasePage {


    public ListTxPage(WebDriver driver) {
        super(driver);
    }

    private final By firstTransaction = By.cssSelector("#anchor0");
    private final By secondTransaction= By.cssSelector("#anchor1");
    private final By firstTransactionDate= By.cssSelector("#anchor0 td:first-child");
    private final By firstTransactionAmount= By.cssSelector("#anchor0 td:nth-child(2)");
    private final By firstTransactionType= By.cssSelector("#anchor0 td:last-child");
    private final By secondTransactionDate= By.cssSelector("#anchor1 td:first-child");
    private final By secondTransactionAmount= By.cssSelector("#anchor1 td:nth-child(2)");
    private final By secondTransactionType= By.cssSelector("#anchor1 td:last-child");

    @Step
    public ListTxPage checkTransactions() {
        waitElementToBeVisible(driver.findElement(firstTransaction));
        waitElementToBeVisible(driver.findElement(secondTransaction));
        return this;
    }

    @Step
    private String getTransactionData(By date, By amount, By type) {
        String formatDateValue = convertDateToRequiredFormat(driver.findElement(date).getText());
        String amountValue = driver.findElement(amount).getText();
        String typeValue = driver.findElement(type).getText();
        return formatDateValue + "," + amountValue + "," + typeValue;
    }

    @Step
    public void writeTransactionsDataToCsv() {
        String firstTransactionData = getTransactionData(firstTransactionDate, firstTransactionAmount,
                firstTransactionType);
        String secondTransactionData = getTransactionData(secondTransactionDate, secondTransactionAmount,
                secondTransactionType);
        writeDataFromPageToCsv(firstTransactionData + "\n" + secondTransactionData);
    }


}
