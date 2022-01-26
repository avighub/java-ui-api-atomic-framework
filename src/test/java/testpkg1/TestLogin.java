package testpkg1;

import org.testng.annotations.*;

public class TestLogin {


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
    @BeforeMethod
    public void beformethod() {
        System.out.println("I am inside Before Method");
    }

    @Test
    public void loginTest1() throws InterruptedException {
        System.out.println("Login Test1");
        Thread.sleep(2000);
    }

    @Test
    public void loginTest2() throws InterruptedException {
        System.out.println("Login Test2");
        Thread.sleep(2000);
    }

}
