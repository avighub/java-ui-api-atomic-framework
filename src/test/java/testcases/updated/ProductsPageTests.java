package testcases.updated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import testcases.base.BaseTest;

public class ProductsPageTests extends BaseTest {
    @Test
    public void item_count_for_cart_should_be_updated() throws InterruptedException {

        //Init driver
        initializedDriver();

        //Call login method
        loginWithValidUserNameAndPassword();

        validateProductPage();

        addProductToCartAndValidate();

        quitDriver();

    }
}
