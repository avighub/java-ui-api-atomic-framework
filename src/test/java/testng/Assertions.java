package testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions {


    @Test
    public void assert2() {
        int expectedINt = 10;
        System.out.println("Validate if the price of item is expected");
        Assert.assertEquals(12, expectedINt);
    }

    @Test
    public void asset1() {
        String expected = "Redmi Mobile";
        System.out.println("Validate if the name of item is expected");
        Assert.assertEquals("iPhone", expected);
    }

    @Test
    public void assert3() {
        String expected = "Redmi Mobile";
        System.out.println("Validate if the name of item is expected");
        Assert.assertEquals("Redmi Mobile", expected);
    }

    @Test
    public void assert4() {
        System.out.println("Validate if the name of item is expected");
        boolean actualValue = true;
        Assert.assertTrue(actualValue);
    }

    @Test
    public void assert5() {
        System.out.println("Validate if the name of item is expected");

        boolean actualValue = true;
        String exp1 = "redmi";
        String exp2 = "iphone";
        String exp3 = "win";

        SoftAssert softAssert = new SoftAssert(); // creating object of class

        softAssert.assertTrue(actualValue);
        softAssert.assertEquals("Redmi Mobile", exp1);
        softAssert.assertEquals("Redmi Mobile", exp2);
        softAssert.assertEquals("win", exp3);

        softAssert.assertAll();


    }


}
