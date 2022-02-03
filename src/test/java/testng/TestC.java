package testng;


import org.testng.annotations.*;

public class TestC {
    @BeforeSuite
    public void beforSuite() {
        System.out.println("I am inside Before SUite");
    }


    @BeforeTest
    public void beforTest() {
        System.out.println("I am inside Before Test");
    }

    @BeforeClass
    public void beforClass() {
        System.out.println("I am inside Before Class");
    }


    @Test(groups = {"high"})
    public void user_should_be_able_to_login_using_valid_username_and_password() throws InterruptedException {
        System.out.println("I should be able to navigate to Product page");
        Thread.sleep(2000);

    }

    @Test(groups = {"High"})
    public void user_should_not_be_able_to_login_using_invalid_username_and_valid_password() throws InterruptedException {
        System.out.println("I should be able to see Error message");
        Thread.sleep(2000);
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("I am inside After SUite");
    }


    @AfterTest
    public void afterTest() {
        System.out.println("I am inside After Test");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("I am inside After Class");
    }

}
