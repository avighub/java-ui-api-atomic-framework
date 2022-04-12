package testcases;

import base.BaseTestWeb;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class LoginPageTests extends BaseTestWeb {


    @Test
    public void should_be_able_to_login_using_standardUser_valid_credentials_updated() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();

        boolean pageDisplayed = loginPage.isPageDisplayed();
        Assert.assertTrue(pageDisplayed);

        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);

        loginPage.clickLoginBtn();

    }


}
