package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    //WebDriver Defined
    WebDriver localDriver;

    //Constructor to execute the code when object is created
    public LoginPage(WebDriver driverParam) {
        System.out.println("I am inside LoginPage Construtor");
        this.localDriver = driverParam;
    }

    //Locators
    private By usernameTextBox = By.id("user-name");
    By passwordTextBox = By.id("password");
    By loginBtn = By.id("login-button");
    By logo = By.cssSelector("#root > div > div.login_logo");
    By robotImage = By.cssSelector("#root > div > div.login_wrapper > div.login_wrapper-inner > div.bot_column");
    String pageUrl = "https://www.saucedemo.com";

    //User actions
    public void navigateToLoginPage() {
        localDriver.get(pageUrl);
    }

    public void enterUsername() {
        localDriver.findElement(usernameTextBox).sendKeys("standard_user");
    }

    public void enterPassword() {
        localDriver.findElement(passwordTextBox).sendKeys("secret_sauce");
    }

    public void clickLoginBtn() {
        localDriver.findElement(loginBtn).click();
    }

    //Framework Action
    public boolean isPageDisplayed() {
        boolean displayedFlag = localDriver.findElement(loginBtn).isDisplayed();
        return displayedFlag;
    }

    public boolean isLogoDisplayed() {
        boolean displayedFlag = localDriver.findElement(logo).isDisplayed();
        return displayedFlag;
    }

    public boolean isRoboImageDisplayed() {
        boolean displayedFlag = localDriver.findElement(robotImage).isDisplayed();
        return displayedFlag;
    }


}
