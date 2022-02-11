package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyUtils;

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
    String pageUrl = PropertyUtils.envProperties.getProperty("LOGIN_PAGE_URL");

    //User actions
    public void navigateToLoginPage() {
        localDriver.get(pageUrl);
    }

    public void enterUsername(String username) {
        localDriver.findElement(usernameTextBox).sendKeys(username);
    }

    public void enterPassword(String password) {
        localDriver.findElement(passwordTextBox).sendKeys(password);
    }

    public void clickLoginBtn() {
        localDriver.findElement(loginBtn).click();
    }

    //Making a combo method to perform multiple steps at once
    public void loginAsStandardUser(String username,String password){
        navigateToLoginPage();
        enterUsername(username);
        enterPassword(password);
        clickLoginBtn();
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
