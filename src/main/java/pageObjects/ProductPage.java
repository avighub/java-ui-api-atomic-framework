package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage {

    //WebDriver Defined
    WebDriver localDriver;

    //Constructor to execute the code when object is created
    public ProductPage(WebDriver driverParam) {
        System.out.println("I am inside ProductPage Construtor");
        this.localDriver = driverParam;
        PageFactory.initElements(localDriver, this);
    }

    //Locators
    @FindBy(css = "#header_container > div.header_secondary_container > span")
    private WebElement productsTitle;

    @FindBy(css = "#add-to-cart-sauce-labs-fleece-jacket")
    private WebElement addToCartBtn_fleeceJacket;


    String cartItemCount = "#shopping_cart_container > a > span";
    String cartBtn = "#shopping_cart_container > a";
    String pageUrl = "https://www.saucedemo.com/inventory.html";

    //User actions
    public void navigateToProductPage() {
        localDriver.get(pageUrl);
    }

    public void clickAddToCartBtnByProductName(String productName) {
        By addToCartBtn = By.xpath("//div[@class='inventory_item_description' and contains(normalize-space(),'" + productName + "')]/div/button");
        localDriver.findElement(addToCartBtn).click();
    }

    public void clickCartButton() {
        localDriver.findElement(By.cssSelector(cartBtn)).click();
    }

    //Combo method
    public void addProductsToCartByNames(List<String> listOfProductNames) {
        for (String item : listOfProductNames) {
            clickAddToCartBtnByProductName(item);
        }
    }

    //Framework Action
    public int getCartItemCount() {
        String count = localDriver.findElement(By.cssSelector(cartItemCount)).getText();
        return Integer.parseInt(count);
    }

    public boolean isPageTitleDisplayed() {
        String currentUrl = localDriver.getCurrentUrl();
        boolean flag = false;
        if (currentUrl.equals(pageUrl)) {
            flag = true;
        }
        return flag;
    }


}
