package testcases.nonpom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutPageTest {

    @Test
    public void should_have_correct_product_information() throws InterruptedException {

        //Arrange
        String loginUrl = "https://www.saucedemo.com/";
        String username = "standard_user";
        String password = "secret_sauce";

        System.setProperty("webdriver.chrome.driver", "BrowserDrivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver(); //single line
        driver.manage().window().maximize();

        //Act
        driver.get(loginUrl);
        Thread.sleep(2000);
        String expectedLoginPageTitle = "Swag Labs";
        String actualLoginPageTitle = driver.getTitle(); //return String
        Assert.assertEquals(actualLoginPageTitle, expectedLoginPageTitle);

        String usernameTextBox = "user-name";
        String passwordTextBox = "password";
        driver.findElement(By.id(usernameTextBox)).sendKeys(username);
        driver.findElement(By.id(passwordTextBox)).sendKeys(password);
        Thread.sleep(2000);

        String loginBtn = "login-button";
        driver.findElement(By.id(loginBtn)).click();
        Thread.sleep(2000);

        String productsTitle = "#header_container > div.header_secondary_container > span";
        boolean flag = driver.findElement(By.cssSelector(productsTitle)).isDisplayed();
        Assert.assertTrue(flag);
        Thread.sleep(2000);

        String addToCartBtn_fleeceJacket = "#add-to-cart-sauce-labs-fleece-jacket";
        driver.findElement(By.cssSelector(addToCartBtn_fleeceJacket)).click();
        Thread.sleep(2000);

        int expectedCartItemCount = 1;
        String cartItemCount = "#shopping_cart_container > a > span";
        String actualCartItemCount = driver.findElement(By.cssSelector(cartItemCount)).getText();
        Assert.assertEquals(Integer.parseInt(actualCartItemCount), expectedCartItemCount);

        String cartBtn = "#shopping_cart_container > a";
        driver.findElement(By.cssSelector(cartBtn)).click();
        Thread.sleep(2000);

        String itemNameLink = "#item_5_title_link > div";
        String actualItemNameLink = driver.findElement(By.cssSelector(itemNameLink)).getText();
        Thread.sleep(2000);
        String expectedItemName = "Sauce Labs Fleece Jacket";
        Assert.assertEquals(actualItemNameLink, expectedItemName);

        String itemDescriptionTxt = "#cart_contents_container > div > div.cart_list > div.cart_item > div.cart_item_label > div.inventory_item_desc";
        String expectedItemDescription = "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.";
        String actualItemDescription = driver.findElement(By.cssSelector(itemDescriptionTxt)).getText();
        Thread.sleep(2000);
        Assert.assertEquals(actualItemDescription, expectedItemDescription);

        String itemPrice = "#cart_contents_container > div > div.cart_list > div.cart_item > div.cart_item_label > div.item_pricebar > div";
        String expectedItemPrice = "49.99";
        String actualItemPrice = driver.findElement(By.cssSelector(itemPrice)).getText();
        Thread.sleep(2000);
        Assert.assertTrue(actualItemPrice.contains(expectedItemPrice));

        String checkoutBtn = "#checkout";
        String continueBtn = "#continue";
        String checkoutTitleTxt = "#header_container > div.header_secondary_container > span";
        String expectedErrorMessage = "Error: First Name is required";
        driver.findElement(By.cssSelector(checkoutBtn)).click();
        Assert.assertTrue(driver.findElement(By.cssSelector(checkoutTitleTxt)).isDisplayed());
        Thread.sleep(2000);

        driver.findElement(By.cssSelector(continueBtn)).click();
        Thread.sleep(2000);

        String errorMsgTxt = "#checkout_info_container > div > form > div.checkout_info > div.error-message-container.error > h3";
        String actualErrorMsgTxt = driver.findElement(By.cssSelector(errorMsgTxt)).getText();
        Assert.assertEquals(actualErrorMsgTxt, expectedErrorMessage);

        //cleanup
        driver.quit();

    }
}
