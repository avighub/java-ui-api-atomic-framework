package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserFactory;
import utils.WebDriverFactory;

public class BaseTest {
//    protected WebDriver driver;

    @BeforeMethod
    public void initDriver() {
        System.out.println("****** Starting Test *********");
        System.out.println("===== Initializing WebDriver ======");

        // To check thread safe instance
            WebDriver browser = BrowserFactory.getBrowser();
            WebDriverFactory.setDriver(browser);
//            driver = WebDriverFactory.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("===== Quitting WebDriver ======");
        WebDriverFactory.closeBrowser();
        System.out.println("****** Test Ended *********");
    }
}
