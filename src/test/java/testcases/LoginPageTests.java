package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pageObjects.LoginPage;

public class LoginPageTests extends BaseTest {


    @Test
    public void should_be_able_to_login_using_standardUser_valid_credentials() throws InterruptedException {

        //Init driver
        initializedDriver();

        //Call login method
        loginWithValidUserNameAndPassword();

        //validate if login is successful
        validateProductPage();

        //cleanup
        quitDriver();

    }

    @Test
    public void should_be_able_to_login_using_standardUser_valid_credentials_updated() {
        System.setProperty("webdriver.chrome.driver", "BrowserDrivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();

        boolean pageDisplayed = loginPage.isPageDisplayed();
        Assert.assertTrue(pageDisplayed);

        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLoginBtn();

        driver.quit();

    }
}
