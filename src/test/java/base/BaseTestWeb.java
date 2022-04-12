package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import driver.local.LocalDriverFactory;
import driver.Driver;
import config.ConfigManager;

public class BaseTestWeb {
    protected WebDriver driver;
    Logger log = LogManager.getLogger(BaseTestWeb.class);

    @BeforeMethod
    public void initDriver() {
        log.info("****** Starting Test *********");
        log.info("===== Initializing WebDriver ======");

        // To check thread safe instance
        if (driver == null) {
            String browserName = ConfigManager.FRAMEWORKCONFIG.browserName();
            boolean headlessMode = ConfigManager.FRAMEWORKCONFIG.headlessMode();
            WebDriver browser = LocalDriverFactory.getDriver(browserName,headlessMode);
            Driver.setDriver(browser);
            driver = Driver.getDriver();
        }
    }

    @AfterMethod
    public void tearDown() {
        log.info("===== Quitting WebDriver ======");
        Driver.closeBrowser();
        log.info("****** Test Ended *********");
    }
}
