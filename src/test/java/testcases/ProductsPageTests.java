package testcases;

import base.BaseTestWeb;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.ProductPage;

public class ProductsPageTests extends BaseTestWeb {

    @Test
    public void item_count_for_cart_should_be_updated()  {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();

        boolean pageDisplayed = loginPage.isPageDisplayed();
        Assert.assertTrue(pageDisplayed);

        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginBtn();

        ProductPage productPage=new ProductPage(driver);
        boolean pageTitleDisplayed = productPage.isPageTitleDisplayed();
        Assert.assertTrue(pageTitleDisplayed);

        productPage.clickAddToCartBtnByProductName("Sauce Labs Backpack");
        int cartItemCount = productPage.getCartItemCount();
        Assert.assertEquals(cartItemCount,1);


    }
}
