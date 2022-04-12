package driver;

import config.IFrameworkConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public final class LocalDriverFactory {
    static Logger log = LogManager.getLogger(LocalDriverFactory.class);

    private LocalDriverFactory() {
    }


    public static WebDriver getDriver(String browserName,boolean headlessMode) {
        WebDriver driver = null;

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();

            if (headlessMode) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                options.addArguments("--disable-gpu");
                options.addArguments("--disable-logging");
                options.addArguments("--log-level=3");
                options.addArguments("window-size=1920,1080");
                options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver(options);
                log.info("===  ChromeDriver(Headless mode) Initialized ===");
            } else {
                driver =ChromeManager.getDriver();
                driver.manage().window().maximize();
                log.info("===  ChromeDriver(Headful mode) Initialized ===");
            }
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = EdgeManager.getDriver();
            driver.manage().window().maximize();
            log.info("=== EdgeDriver Initialized ===");
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver =FirefoxManager.getDriver();
            driver.manage().window().maximize();
            log.info("=== FirefoxDriver Initialized ===");
        } else {
            throw new RuntimeException("!! Invalid Browser name provided. Please check name and try again.");
        }
        return driver;
    }


}
