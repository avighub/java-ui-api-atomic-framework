package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pageObjects.LoginPage;
import pageObjects.ProductPage;

public class ProductsPageTests extends BaseTest {

    @Test
    public void item_count_for_cart_should_be_updated() throws InterruptedException {

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

        ProductPage productPage=new ProductPage(driver);
        boolean pageTitleDisplayed = productPage.isPageTitleDisplayed();
        Assert.assertTrue(pageTitleDisplayed);

        productPage.clickAddToCartBtnByProductName("Sauce Labs Backpack");
        int cartItemCount = productPage.getCartItemCount();
        Assert.assertEquals(cartItemCount,1);
        Thread.sleep(2000);


    }
}
