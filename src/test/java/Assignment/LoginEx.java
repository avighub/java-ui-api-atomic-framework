package Assignment;

import org.testng.annotations.Test;

public class LoginEx {
@Test
    public void loginweb(){
        String URL = "https://www.saucedemo.com/";
        String Username = "standard_user";
        String Pwd = "secret_sauce";
        System.out.println("User Will Navigate to " + URL);

        System.out.println("User will pass username in the field and sendkeys = " + Username);

        System.out.println("User will pass password in the PWD field and sendkeys = "+ Pwd);
    }
@Test
    public void addcart(){
    String URLC = "user is on this link https://www.saucedemo.com/inventory.html";

    System.out.println(URLC);

    System.out.println("User will find the element 'Sauce Labs Fleece Jacket' after logging in.");
    System.out.println("User will find the element 'ADD TO CART' and click it!");
    System.out.println("User will verify the button count is changed to '1' ");
    }
@Test
    public void productinfo(){
    String URLCart = "https://www.saucedemo.com/cart.html";
    System.out.println("User will go to 'Your Cart' page " + URLCart);
    System.out.println("verify the product name, description and price");
}
@Test
    public void productverify(){
    String URLinv = "https://www.saucedemo.com/inventory.html";
    System.out.println("The user is logged in and is on the products page "+ URLinv);
    System.out.println("Find element 'Sauce Labs Backpack' and click");
    System.out.println("Validate user is on the product info page of the same product");
    System.out.println("validate product image, title, description, price is present");

    }


}
