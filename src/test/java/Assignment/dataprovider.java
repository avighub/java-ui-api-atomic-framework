package Assignment;

import org.testng.annotations.Test;

public class dataprovider {
    /**
     * 1- Class name should be LoginTest
     */
    @Test
    public void login() {
        /**
         *  1-Not meaningful test name, should follow a meanigful sentence
         *  Ex: should_be_able_to_login_with_standardUser_credentials()
         *  2-URL: Not meanigful, could be loginUrl
         *  4- Try using user should...... this is a expected behavior and it should follow
         *  user perspective as 3rd person view
         */

        String URL = ("https://www.saucedemo.com/");
        String username = ("standard_user");
        String password = ("secret-sauce");
        System.out.println("Application launched successfully");
    }

    @Test(priority = 1, enabled = false)
    public void AddCart() {
        //enabled should be true

        String URL = ("https://www.saucedemo.com/inventory.html");
        System.out.println("user lands on product page");
        System.out.println("User clicks add to cart on sauce lab fleece jacket");
        System.out.println("user can see quantity 1 in cart");
    }

    @Test()
    public void ProductCartPage() {
        String URL = ("https://www.saucedemo.com/cart.html");
        System.out.println("user lands on product page");
        System.out.println("User clicks on product sauce lab backpack");
        System.out.println("user validates all the description and price matches");
    }
}

