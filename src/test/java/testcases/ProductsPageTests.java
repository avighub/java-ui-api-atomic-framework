package testcases;

import org.testng.annotations.Test;
import base.BaseTest;

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
