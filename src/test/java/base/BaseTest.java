package base;

import common.CommonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import pages.*;

public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected LoginPage loginPage = new LoginPage(driver);
    protected CustomerPage customerPage = new CustomerPage(driver);
    protected AccountPage accountPage = new AccountPage(driver);
    protected ListTxPage listTxPage = new ListTxPage(driver);

    @AfterTest
    public void clearCookiesAndLocalStorage() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        driver.manage().deleteAllCookies();
        jsExecutor.executeScript("window.sessionStorage.clear();");
    }

    @AfterSuite(alwaysRun = true)
    public void close() {
        driver.quit();
    }
}
