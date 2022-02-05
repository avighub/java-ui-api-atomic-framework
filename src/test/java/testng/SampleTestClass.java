package testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class SampleTestClass {

    @Test
    public void testSomething(){
        System.out.println("test something");

    }
    @Test
    public void testOtherThing(){
        System.out.println("test other thing");
    }

}
