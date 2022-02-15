package utils;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class WebDriverFactory {

    //Private constructor will restrict to be instantiated
    private WebDriverFactory() {
    }

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver(WebDriver driverReference) {
        if (Objects.nonNull(driverReference)) {
            driver.set(driverReference);
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void closeBrowser() {
        driver.get().quit();
        driver.remove();
    }

}
