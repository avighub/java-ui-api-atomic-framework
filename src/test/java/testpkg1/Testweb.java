package testpkg1;

import org.testng.annotations.Test;

public class Testweb {
    @Test
    public void googletest()
    {
        System.out.println("User is on Google Home Page http:google.com");
    }
    @Test
    public void googlesearch()  {
        System.out.println("User enters keyword to serach 'automation testing'");

    }
    @Test
    public void googleresult()
    {
        System.out.println("User gets the results in the google page");
    }
}
