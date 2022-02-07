package nonpom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsPageTests {
    @Test
    public void item_count_for_cart_should_be_updated() throws InterruptedException {

        //Arrange
        String loginUrl = "https://www.saucedemo.com/";
        String username = "standard_user";
        String password = "secret_sauce";

        //Locators
        String usernameTextBox = "user-name";
        String passwordTextBox = "password";
        String loginBtn = "login-button";
        String productsTitle = "#header_container > div.header_secondary_container > span";
        String addToCartBtn_fleeceJacket = "#add-to-cart-sauce-labs-fleece-jacket";
        String cartItemCount = "#shopping_cart_container > a > span";

        String expectedLoginPageTitle = "Swag Labs";
        String actualLoginPageTitle;
        int expectedCartItemCount = 1;

        System.setProperty("webdriver.chrome.driver", "BrowserDrivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver(); //single line
        driver.manage().window().maximize();
        //Act
        driver.get(loginUrl);
        Thread.sleep(2000);
        actualLoginPageTitle = driver.getTitle(); //return String
        Assert.assertEquals(actualLoginPageTitle, expectedLoginPageTitle);

        driver.findElement(By.id(usernameTextBox)).sendKeys(username);
        driver.findElement(By.id(passwordTextBox)).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(By.id(loginBtn)).click();
        Thread.sleep(2000);

        boolean flag = driver.findElement(By.cssSelector(productsTitle)).isDisplayed();
        Assert.assertTrue(flag);
        Thread.sleep(2000);

        driver.findElement(By.cssSelector(addToCartBtn_fleeceJacket)).click();
        Thread.sleep(2000);
        String actualCartItemCount = driver.findElement(By.cssSelector(cartItemCount)).getText();
        Assert.assertEquals(Integer.parseInt(actualCartItemCount), expectedCartItemCount);

        //cleanup
        driver.quit();

    }
}
