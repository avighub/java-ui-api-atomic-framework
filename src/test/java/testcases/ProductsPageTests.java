package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pageObjects.LoginPage;
import pageObjects.ProductPage;

public class ProductsPageTests extends BaseTest {

    @Test
    public void item_count_for_cart_should_be_updated() {
        System.setProperty("webdriver.chrome.driver", "BrowserDrivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();

        boolean pageDisplayed = loginPage.isPageDisplayed();
        Assert.assertTrue(pageDisplayed);

        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLoginBtn();

        ProductPage productPage=new ProductPage(driver);
        boolean pageTitleDisplayed = productPage.isPageTitleDisplayed();
        Assert.assertTrue(pageTitleDisplayed);

        productPage.addToCartFleeceJacket();
        int cartItemCount = productPage.getCartItemCount();
        Assert.assertEquals(cartItemCount,1);

        driver.quit();

    }
}
