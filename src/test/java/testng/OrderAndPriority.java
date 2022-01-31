package testng;

import org.testng.Assert;
import org.testng.annotations.*;

public class OrderAndPriority {


    @Test
    public void aloginTest1() throws InterruptedException {
        System.out.println("Login A - COMMON METHOD");
        Thread.sleep(2000);
        Assert.fail("Failed due to some login issue");
    }

    @Test(dependsOnMethods = "aloginTest1")
    public void dbloginTest2() throws InterruptedException {
        System.out.println("Login D");
        Thread.sleep(2000);
    }


    @Test
    public void bloginTest2() throws InterruptedException {
        System.out.println("Login B");
        Thread.sleep(2000);
    }

    @Test(enabled = false)
    public void b2loginTest2() throws InterruptedException {
        System.out.println("Login B2");
        Thread.sleep(2000);
    }

    @Test(enabled = false)
    public void cloginTest2() throws InterruptedException {
        System.out.println("Login C");
        Thread.sleep(2000);
    }


    @Test(groups = {"High"})
    public void b100loginTest2() throws InterruptedException {
        System.out.println("Login D");
        Thread.sleep(2000);
    }


    @Test(groups = {"Low"})
    public void lastbloginTest2() throws InterruptedException {
        System.out.println("Login D");
        Thread.sleep(2000);
    }


}
