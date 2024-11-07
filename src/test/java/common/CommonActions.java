package common;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static util.PropertiesUtil.getProp;

public class CommonActions {
    public static WebDriver createDriver() {
        WebDriver driver = null;
        String platformAndBrowser = getProp("win10_chrome");

        switch (platformAndBrowser) {
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
                Assert.fail("Unsupported platform: " + platformAndBrowser);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(getProp("implicit_wait"))));
        return driver;
    }
}
