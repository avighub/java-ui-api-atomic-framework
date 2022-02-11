package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    //Private constructor will restrict to be instantiated
    private WebDriverFactory() {
    }

    public  static WebDriver getDriver(String browserName, String browserMode) {
        WebDriver driver;

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();

            if (browserMode.equalsIgnoreCase("headless")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
//                options.addArguments("--disable-gpu");
//                options.addArguments("--disable-logging");
//                options.addArguments("--log-level=3");
//                options.addArguments("window-size=1920,1080");
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
