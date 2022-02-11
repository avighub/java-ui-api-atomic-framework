package testcases;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;

import java.util.List;

public class CheckoutPageTests extends BaseTest {

    @Test
    public void should_have_correct_product_information() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
        Thread.sleep(2000);

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
        Thread.sleep(2000);

        productPage.clickAddToCartBtnByProductName("Sauce Labs Fleece Jacket");
        int cartItemCount = productPage.getCartItemCount();
        Assert.assertEquals(cartItemCount,1);
        Thread.sleep(2000);

        productPage.clickCartButton();

        CartPage cartPage = new CartPage(driver);
        boolean pageDisplayed1 = cartPage.isPageDisplayed();
        Assert.assertTrue(pageDisplayed1);
        Thread.sleep(2000);

        List<WebElement> itemsList = cartPage.getItemsList();
        String actualItemName = cartPage.getItemNameByIndex(itemsList, 0);
        String expectedItemName = "Sauce Labs Fleece Jacket";
        Assert.assertEquals(actualItemName,expectedItemName);

        String actualItemDescription = cartPage.getItemDescription();
        String expectedItemDescription = "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.";
        Assert.assertEquals(actualItemDescription,expectedItemDescription);

        String actualItemPrice = cartPage.getItemPrice();
        String expectedItemPrice = "49.99";
        Assert.assertTrue(actualItemPrice.contains(expectedItemPrice));
        Thread.sleep(2000);

        cartPage.clickCheckoutBtn();
        Thread.sleep(2000);

        String expectedErrorMessage = "Error: First Name is required";
        CheckoutPage checkoutPage= new CheckoutPage(driver);
        checkoutPage.clickContinueBtn();
        String actualErrorMsgTxt=checkoutPage.getErrorMessage();
        Assert.assertEquals(actualErrorMsgTxt, expectedErrorMessage);
        Thread.sleep(2000);


    }
}
