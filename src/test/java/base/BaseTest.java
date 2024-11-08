package base;

import common.CommonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import pages.*;

import static util.GetBoolean.getBooleanFromString;
import static util.PropertiesUtil.getProp;

public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected LoginPage loginPage = new LoginPage(driver);
    protected CustomerPage customerPage = new CustomerPage(driver);
    protected AccountPage accountPage = new AccountPage(driver);
    protected ListTxPage listTxPage = new ListTxPage(driver);

    @AfterTest
    public void clearCookiesAndLocalStorage() {
        boolean clearCookiesAndStorage = getBooleanFromString(getProp("clear_cookies_and_storage"));
        if (clearCookiesAndStorage) {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            jsExecutor.executeScript("window.sessionStorage.clear();");
        }
    }

    @AfterSuite(alwaysRun = true)
    public void close() {
        boolean closeBrowser = getBooleanFromString(getProp("close_browser"));
        if (closeBrowser) {
            driver.quit();
        }
    }
}
