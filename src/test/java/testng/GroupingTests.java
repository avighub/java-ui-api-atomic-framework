package testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testng.dataprovider.LoginDataProviders;

public class GroupingTests {
    @Test(groups = {"High"})
    public void googletest() {
        System.out.println("User is on Google Home Page http:google.com");
    }

    @Test(groups = {"Low"})
    public void googlesearch() throws InterruptedException {
        System.out.println("User enters keyword to search 'automation testing'");
        Thread.sleep(2000);

    }

    @Test(groups = {"High"})
    @Parameters("browser")
    public void googleresult(String b) {
        System.out.println("I am a prametrized Test case , parameter = " + b);
        System.out.println("User gets the results in the google page");
    }




}
