package Assignment;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SimmiLoginEx {

    @DataProvider(name = "login-data")
    public Object[][] loginData() {
        //Add code to read csv/excel/json file
        //Return Object
        return new Object[][]{{"standard_user", "secret_sauce"}, {"locked_out_user", "secret_sauce"}};
    }

    @Test(priority = 0, dataProvider = "login-data")
    public void loginweb(String username, String password) {
        String URL = "https://www.saucedemo.com/";

        System.out.println("User Will Navigate to " + URL);

        System.out.println("User will pass username in the field and sendkeys = " + username);

        System.out.println("User will pass password in the PWD field and sendkeys = " + password);
    }

    @Test(priority = 1)
    public void addcart() {
        String URLC = "user is on this link https://www.saucedemo.com/inventory.html";

        System.out.println(URLC);

        System.out.println("User will find the element 'Sauce Labs Fleece Jacket' after logging in.");
        System.out.println("User will find the element 'ADD TO CART' and click it!");
        System.out.println("User will verify the button count is changed to '1' ");
    }

    @Test(priority = 2)
    public void productinfo() {
        String URLCart = "https://www.saucedemo.com/cart.html";
        System.out.println("User will go to 'Your Cart' page " + URLCart);
        System.out.println("verify the product name, description and price");
    }

    @Test(priority = 3)
    public void productverify() {
        String URLinv = "https://www.saucedemo.com/inventory.html";
        System.out.println("The user is logged in and is on the products page " + URLinv);
        System.out.println("Find element 'Sauce Labs Backpack' and click");
        System.out.println("Validate user is on the product info page of the same product");
        System.out.println("validate product image, title, description, price is present");

    }


}

