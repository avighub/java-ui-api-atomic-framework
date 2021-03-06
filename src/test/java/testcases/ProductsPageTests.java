package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.ProductPage;

import static utils.WebDriverFactory.getDriver;

public class ProductsPageTests extends BaseTest {

    @Test
    public void item_count_for_cart_should_be_updated()  {

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage();

        boolean pageDisplayed = loginPage.isPageDisplayed();
        Assert.assertTrue(pageDisplayed);

        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginBtn();

        ProductPage productPage=new ProductPage(getDriver());
        boolean pageTitleDisplayed = productPage.isPageTitleDisplayed();
        Assert.assertTrue(pageTitleDisplayed);

        productPage.clickAddToCartBtnByProductName("Sauce Labs Backpack");
        int cartItemCount = productPage.getCartItemCount();
        Assert.assertEquals(cartItemCount,1);


    }
    @Test
    public void item_count_for_cart_should_be_updated2()  {

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage();

        boolean pageDisplayed = loginPage.isPageDisplayed();
        Assert.assertTrue(pageDisplayed);

        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginBtn();

        ProductPage productPage=new ProductPage(getDriver());
        boolean pageTitleDisplayed = productPage.isPageTitleDisplayed();
        Assert.assertTrue(pageTitleDisplayed);

        productPage.clickAddToCartBtnByProductName("Sauce Labs Backpack");
        int cartItemCount = productPage.getCartItemCount();
        Assert.assertEquals(cartItemCount,1);


    }
    @Test
    public void item_count_for_cart_should_be_updated3()  {

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage();

        boolean pageDisplayed = loginPage.isPageDisplayed();
        Assert.assertTrue(pageDisplayed);

        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginBtn();

        ProductPage productPage=new ProductPage(getDriver());
        boolean pageTitleDisplayed = productPage.isPageTitleDisplayed();
        Assert.assertTrue(pageTitleDisplayed);

        productPage.clickAddToCartBtnByProductName("Sauce Labs Backpack");
        int cartItemCount = productPage.getCartItemCount();
        Assert.assertEquals(cartItemCount,1);


    }
}
