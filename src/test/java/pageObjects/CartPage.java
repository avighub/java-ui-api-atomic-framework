package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    //WebDriver Defined
    WebDriver localDriver;

    //Constructor to execute the code when object is created
    public CartPage(WebDriver driverParam) {
        System.out.println("I am inside CartPage Construtor");
        this.localDriver = driverParam;
    }

    //Locators
    String itemNameLink = "#item_5_title_link > div";
    String itemDescriptionTxt = "#cart_contents_container > div > div.cart_list > div.cart_item > div.cart_item_label > div.inventory_item_desc";
    String itemPrice = "#cart_contents_container > div > div.cart_list > div.cart_item > div.cart_item_label > div.item_pricebar > div";
    String checkoutBtn = "#checkout";
    String pageUrl = "https://www.saucedemo.com/cart.html";

    //User actions
    public void navigateToCartPage() {
        localDriver.get(pageUrl);
    }

    public String getItemName() {
        return localDriver.findElement(By.cssSelector(itemNameLink)).getText();
    }

    public String getItemDescription() {
        return localDriver.findElement(By.cssSelector(itemDescriptionTxt)).getText();
    }

    public String getItemPrice() {
        return localDriver.findElement(By.cssSelector(itemPrice)).getText();
    }

    public void clickCheckoutBtn() {
        localDriver.findElement(By.cssSelector(checkoutBtn)).click();
    }

    //Framework Action
    public boolean isPageDisplayed() {
        String currentUrl = localDriver.getCurrentUrl();
        boolean flag = false;
        if (currentUrl.equals(pageUrl)) {
            flag = true;
        }
        return flag;
    }


}
