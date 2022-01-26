package testpkg1;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
    @Test
    public void user_should_be_able_to_login_using_valid_username_and_password() throws InterruptedException {
        System.out.println("I should be able to navigate to Product page");
        Thread.sleep(2000);

    }

    @Test
    public void user_should_not_be_able_to_login_using_invalid_username_and_valid_password() throws InterruptedException {
        System.out.println("I should be able to see Error message");
        Thread.sleep(2000);
    }


}
