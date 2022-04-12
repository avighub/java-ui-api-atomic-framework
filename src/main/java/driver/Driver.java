package driver;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

public final class Driver {

    //Private constructor will restrict to be instantiated
    private Driver() {
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
