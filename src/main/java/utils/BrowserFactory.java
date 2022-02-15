package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static utils.PropertyUtils.configProperties;

public class BrowserFactory {

    private BrowserFactory() {
    }

    static String browserName;
    static String browserMode;

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
        setBrowserName();
        setBrowserMode();
        WebDriver driver;

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();

            if (browserMode.equalsIgnoreCase("headless")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                driver = new ChromeDriver(options);
                System.out.println("===  ChromeDriver(Headless mode) Initialized ===");
            } else {
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                System.out.println("===  ChromeDriver(Headful mode) Initialized ===");
            }
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            System.out.println("=== EdgeDriver Initialized ===");
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            System.out.println("=== FirefoxDriver Initialized ===");
        } else {
            throw new RuntimeException("!! Invalid Browser name provided. Please check name and try again.");
        }
        return driver;
    }


}
