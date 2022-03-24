package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    //WebDriver Defined
    WebDriver localDriver;

    //Constructor to execute the code when object is created
    public CheckoutPage(WebDriver driverParam) {
        System.out.println("I am inside CheckoutPage Construtor");
        this.localDriver = driverParam;
    }

    //Locators
    String continueBtn = "#continue";
    String checkoutTitleTxt = "#header_container > div.header_secondary_container > span";
    String errorMsgTxt = "#checkout_info_container > div > form > div.checkout_info > div.error-message-container.error > h3";
    String pageUrl = "https://www.saucedemo.com/checkout-step-one.html";

    //User actions
    public void clickContinueBtn() {
        localDriver.findElement(By.cssSelector(continueBtn)).click();
    }

    public String getErrorMessage() {
        return localDriver.findElement(By.cssSelector(errorMsgTxt)).getText();
    }

    //Framework Action
    public boolean isPageTitleDisplayed() {
        String currentUrl = localDriver.getCurrentUrl();
        boolean flag = false;
        if (currentUrl.equals(pageUrl)) {
            flag = true;
        }
        return flag;
    }


}
