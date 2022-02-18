package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static utils.PropertyUtils.configProperties;

public class BrowserFactory {
    static Logger log = LogManager.getLogger(BrowserFactory.class);
    private BrowserFactory() {
    }

    public static String browserName;
    public static String browserMode;

    static {
        setBrowserName();
        setBrowserMode();
    }
    static void setBrowserName() {
        //Checking if browserName is passed via environment variable
        try {
            browserName = System.getProperty("browserName");
            if (browserName == null) {
                browserName = configProperties.getProperty("BROWSER_NAME");
            }
        } catch (Exception e) {
            browserName = configProperties.getProperty("BROWSER_NAME");
        }
    }

    static void setBrowserMode() {
        //Checking if browserMode is passed via environment variable
        try {
            browserMode = System.getProperty("browserMode");
            if (browserMode == null) {
                browserMode = configProperties.getProperty("BROWSER_MODE");
            }
        } catch (Exception e) {
            browserMode = configProperties.getProperty("BROWSER_MODE");
        }
    }


    public static WebDriver getBrowser() {
        WebDriver driver;

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();

            if (browserMode.equalsIgnoreCase("headless")) {
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
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                log.info("===  ChromeDriver(Headful mode) Initialized ===");
            }
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            log.info("=== EdgeDriver Initialized ===");
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            log.info("=== FirefoxDriver Initialized ===");
        } else {
            throw new RuntimeException("!! Invalid Browser name provided. Please check name and try again.");
        }
        return driver;
    }


}
