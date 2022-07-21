package testcases;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;

import java.util.List;

import static utils.WebDriverFactory.getDriver;

public class CheckoutPageTests extends BaseTest {

    @Test
    public void should_have_correct_product_information()  {

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

        productPage.clickAddToCartBtnByProductName("Sauce Labs Fleece Jacket");
        int cartItemCount = productPage.getCartItemCount();
        Assert.assertEquals(cartItemCount,1);

        productPage.clickCartButton();

        CartPage cartPage = new CartPage(getDriver());
        boolean pageDisplayed1 = cartPage.isPageDisplayed();
        Assert.assertTrue(pageDisplayed1);

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

        cartPage.clickCheckoutBtn();

        String expectedErrorMessage = "Error: First Name is required";
        CheckoutPage checkoutPage= new CheckoutPage(getDriver());
        checkoutPage.clickContinueBtn();
        String actualErrorMsgTxt=checkoutPage.getErrorMessage();
        Assert.assertEquals(actualErrorMsgTxt, expectedErrorMessage);


    }


    @Test
    public void should_have_correct_product_information2()  {

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

        productPage.clickAddToCartBtnByProductName("Sauce Labs Fleece Jacket");
        int cartItemCount = productPage.getCartItemCount();
        Assert.assertEquals(cartItemCount,1);

        productPage.clickCartButton();

        CartPage cartPage = new CartPage(getDriver());
        boolean pageDisplayed1 = cartPage.isPageDisplayed();
        Assert.assertTrue(pageDisplayed1);

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

        cartPage.clickCheckoutBtn();

        String expectedErrorMessage = "Error: First Name is required";
        CheckoutPage checkoutPage= new CheckoutPage(getDriver());
        checkoutPage.clickContinueBtn();
        String actualErrorMsgTxt=checkoutPage.getErrorMessage();
        Assert.assertEquals(actualErrorMsgTxt, expectedErrorMessage);


    }
    @Test
    public void should_have_correct_product_information3()  {

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

        productPage.clickAddToCartBtnByProductName("Sauce Labs Fleece Jacket");
        int cartItemCount = productPage.getCartItemCount();
        Assert.assertEquals(cartItemCount,1);

        productPage.clickCartButton();

        CartPage cartPage = new CartPage(getDriver());
        boolean pageDisplayed1 = cartPage.isPageDisplayed();
        Assert.assertTrue(pageDisplayed1);

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

        cartPage.clickCheckoutBtn();

        String expectedErrorMessage = "Error: First Name is required";
        CheckoutPage checkoutPage= new CheckoutPage(getDriver());
        checkoutPage.clickContinueBtn();
        String actualErrorMsgTxt=checkoutPage.getErrorMessage();
        Assert.assertEquals(actualErrorMsgTxt, expectedErrorMessage);


    }
}
