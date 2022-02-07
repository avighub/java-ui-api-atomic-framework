package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class BaseTest {

    WebDriver driver;


    public void initializedDriver() {
        /**
         * OOPS- Interface
         * WebDriver driver; //Step1- Creating reference
         *  driver = new ChromeDriver(); //Step2-Assign Chrome Object
         */
        System.setProperty("webdriver.chrome.driver", "BrowserDrivers/chromedriver.exe");
        driver = new ChromeDriver(); //single line
        driver.manage().window().maximize();
    }

    public void loginWithValidUserNameAndPassword() throws InterruptedException {
        //Arrange
        String loginUrl = "https://www.saucedemo.com/";
        String username = "standard_user";
        String password = "secret_sauce";

        String usernameTextBox = "user-name";
        String passwordTextBox = "password";
        String loginBtn = "login-button";


        String expectedLoginPageTitle = "Swag Labs";
        String actualLoginPageTitle;

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

    }

    public void validateProductPage() {
        String productsTitle = "#header_container > div.header_secondary_container > span";
        //Assert
        boolean flag = driver.findElement(By.cssSelector(productsTitle)).isDisplayed();
        Assert.assertTrue(flag);
    }

    public void addProductToCartAndValidate() throws InterruptedException {
        String addToCartBtn_fleeceJacket = "#add-to-cart-sauce-labs-fleece-jacket";
        String cartItemCount = "#shopping_cart_container > a > span";
        driver.findElement(By.cssSelector(addToCartBtn_fleeceJacket)).click();
        Thread.sleep(2000);
        String actualCartItemCount = driver.findElement(By.cssSelector(cartItemCount)).getText();
        int expectedCartItemCount = 1;
        Assert.assertEquals(Integer.parseInt(actualCartItemCount), expectedCartItemCount);
    }

    public void quitDriver(){
        driver.quit();
    }

}
