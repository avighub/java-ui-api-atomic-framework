package Assignment;

import org.testng.annotations.Test;

public class dataprovider {

    @Test
    public void login() {

        String URL = ("https://www.saucedemo.com/");
        String username = ("standard_user");
        String password = ("secret-sauce");
        System.out.println("Application launched successfully");
    }

    @Test(priority = 1, enabled = false)
    public void AddCart() {

        String URL = ("https://www.saucedemo.com/inventory.html");
        System.out.println("user lands on product page");
        System.out.println("User clicks add to cart on sauce lab fleece jacket");
        System.out.println("user can see quantity 1 in cart");
    }

    //    @Test(parallel=true)
    public void ProductCartPage() {
        String URL = ("https://www.saucedemo.com/cart.html");
        System.out.println("user lands on product page");
        System.out.println("User clicks on product sauce lab backpack");

        System.out.println("user validates all the description and price matches");
    }
}

