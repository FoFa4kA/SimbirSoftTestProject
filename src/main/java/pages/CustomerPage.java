package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerPage extends BasePage {

    public CustomerPage(WebDriver driver) {
        super(driver);
    }

    private final By userSelect = By.cssSelector("select[name]");
    private final By harryPotter = By.cssSelector("option[value='2']");
    private final By loginButton = By.cssSelector("button[type='submit']");

    @Step
    public CustomerPage selectUser() {
        driver.findElement(userSelect).click();
        driver.findElement(harryPotter).click();
        driver.findElement(userSelect).click();
        return this;
    }

    @Step
    public CustomerPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return this;
    }
}
