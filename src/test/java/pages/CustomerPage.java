package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage extends BasePage {

    public CustomerPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "select[name]")
    private WebElement userSelect;

    @FindBy(css = "option[value='2']")
    private WebElement harryPotter;

    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;

    @Step("Select Harry Potter from user list")
    public CustomerPage selectUser() {
        waitElementToBeVisible(userSelect);
        userSelect.click();
        waitElementToBeVisible(harryPotter);
        harryPotter.click();
        waitElementToBeVisible(userSelect);
        userSelect.click();
        return this;
    }

    @Step("Click 'Login' button")
    public AccountPage clickLoginButton() {
        waitElementToBeVisible(loginButton);
        loginButton.click();
        return new AccountPage(driver);
    }
}
