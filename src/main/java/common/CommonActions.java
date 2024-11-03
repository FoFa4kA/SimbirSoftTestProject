package common;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static common.Config.PLATFORM_AND_BROWSER;
import static constants.Constant.Timeouts.IMPLICIT_WAIT;

public class CommonActions {
    public static WebDriver createDriver() {
        WebDriver driver = null;

        switch (PLATFORM_AND_BROWSER) {
            case "windows10_chrome":
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setBrowserName("chrome");
                capabilities.setPlatform(Platform.WIN10);
                try {
                    driver = new RemoteWebDriver(new URL("http://localhost:4444"), capabilities);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                Assert.fail("Unsupported platform: " + PLATFORM_AND_BROWSER);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        return driver;
    }
}
