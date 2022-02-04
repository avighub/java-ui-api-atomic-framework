package LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests {


    @Test
    public void should_be_able_to_login_using_standardUser_valid_credentials() throws InterruptedException {

        //Arrange
        String loginUrl = "https://www.saucedemo.com/";
        String username = "standard_user";
        String password = "secret_sauce";

        String usernameTextBox = "user-name";
        String passwordTextBox = "password";
        String loginBtn = "login-button";
        String productsTitle = "#header_container > div.header_secondary_container > span";

        String expectedLoginPageTitle = "Swag Labs";
        String actualLoginPageTitle;

        //OOPS- Interface
//        WebDriver driver; //Step1- Creating reference
//        driver = new ChromeDriver(); //Step2-Assign Chrome Object
        System.setProperty("webdriver.chrome.driver", "BrowserDrivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver(); //single line

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

        //Assert
        boolean flag = driver.findElement(By.cssSelector(productsTitle)).isDisplayed();
        Assert.assertTrue(flag);

        Thread.sleep(2000);

        //cleanup
        driver.quit();

    }


}
