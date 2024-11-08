package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static util.PropertiesUtil.getProp;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
    }

    public WebElement waitElementToBeVisible(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(getProp("explicit_wait"))))
                .until(ExpectedConditions.visibilityOf(element));
        return element;
    }
}
