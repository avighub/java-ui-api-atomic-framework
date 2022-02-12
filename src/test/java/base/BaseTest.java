package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.WebDriverFactory;

import static utils.PropertyUtils.configProperties;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void initDriver() {
        System.out.println("****** Starting Test *********");
        System.out.println("===== Initializing WebDriver ======");

        String browserName = configProperties.getProperty("BROWSER_NAME");
        String browserMode = configProperties.getProperty("BROWSER_MODE");

        // To check thread safe instance
        if (driver == null) {
            driver = WebDriverFactory.getDriver(browserName, browserMode);
        }
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("===== Quitting WebDriver ======");
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        System.out.println("****** Test Ended *********");
    }
}
