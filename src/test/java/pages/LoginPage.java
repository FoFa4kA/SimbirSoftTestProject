package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "button[ng-click='customer()']")
    private WebElement customerLoginButton;

    @Step("Click 'Customer Login' button")
    public CustomerPage clickCustomerLoginButton() {
        waitElementToBeVisible(customerLoginButton);
        customerLoginButton.click();
        return new CustomerPage(driver);
    }
}
