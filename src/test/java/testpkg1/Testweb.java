package testpkg1;

import org.testng.annotations.Test;

public class Testweb {
    @Test
    public void googletest()
    {

        System.out.println("User is on Google Home Page http:google.com");
    }
    @Test
    public void googlesearch() throws InterruptedException
    {
        System.out.println("User enters keyword to search 'automation testing'");
        Thread.sleep(2000);

    }
    @Test
    public void googleresult()
    {

        System.out.println("User gets the results in the google page");
    }
}
