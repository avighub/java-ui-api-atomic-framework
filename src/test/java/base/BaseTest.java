package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserFactory;
import utils.WebDriverFactory;

public class BaseTest {
    protected WebDriver driver;
    Logger log = LogManager.getLogger(BaseTest.class);

    @BeforeMethod
    public void initDriver() {
        log.info("****** Starting Test *********");
        log.info("===== Initializing WebDriver ======");

        // To check thread safe instance
        if (driver == null) {
            WebDriver browser = BrowserFactory.getBrowser();
            WebDriverFactory.setDriver(browser);
            driver = WebDriverFactory.getDriver();
        }
    }

    @AfterMethod
    public void tearDown() {
        log.info("===== Quitting WebDriver ======");
        WebDriverFactory.closeBrowser();
        log.info("****** Test Ended *********");
    }
}
