package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By customerLoginButton = By.cssSelector("button[ng-click='customer()']");

    @Step
    public LoginPage clickCustomerLoginButton() {
        driver.findElement(customerLoginButton).click();
        return this;
    }
}
