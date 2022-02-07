package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    //WebDriver Defeninig
    WebDriver localDriver;

    //Constructor
    public LoginPage(WebDriver driverParam) {
        System.out.println("I am inside LoginPage Construtor");
        this.localDriver = driverParam;
    }

    //Locators
    String usernameTextBox = "user-name";
    String passwordTextBox = "password";
    String loginBtn = "login-button";
    String logo = "#root > div > div.login_logo";
    String robotImage = "#root > div > div.login_wrapper > div.login_wrapper-inner > div.bot_column";


    //User actions
    public void navigateToLoginPage() {
        localDriver.get("https://www.saucedemo.com/");
    }

    public void enterUsername() {
        localDriver.findElement(By.id(usernameTextBox)).sendKeys("standard_user");
    }

    public void enterPassword() {
        localDriver.findElement(By.id(passwordTextBox)).sendKeys("secret_sauce");
    }

    public void clickLoginBtn() {
        localDriver.findElement(By.id(loginBtn)).click();
    }

    //Framework Action
    public boolean isPageDisplayed() {
        boolean displayedFlag = localDriver.findElement(By.id(loginBtn)).isDisplayed();
        return displayedFlag;
    }

    public boolean isLogoDisplayed() {
        boolean displayedFlag = localDriver.findElement(By.id(logo)).isDisplayed();
        return displayedFlag;
    }

    public boolean isRoboImageDisplayed() {
        boolean displayedFlag = localDriver.findElement(By.id(robotImage)).isDisplayed();
        return displayedFlag;
    }


}
