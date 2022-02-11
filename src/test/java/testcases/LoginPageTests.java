package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pageObjects.LoginPage;

public class LoginPageTests extends BaseTest {


    @Test
    public void should_be_able_to_login_using_standardUser_valid_credentials_updated() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();

        boolean pageDisplayed = loginPage.isPageDisplayed();
        Assert.assertTrue(pageDisplayed);

        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);

        loginPage.clickLoginBtn();
        Thread.sleep(2000);


    }
}
