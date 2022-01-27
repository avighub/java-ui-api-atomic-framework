package testpkg1;

import org.testng.annotations.Test;

public class calculator {
    @Test
    public void calculator(){
        int a=2;
        int b=6;
        int sum = a+b;
        System.out.println("The sum of both the nos. is " + sum);
    }
    @Test
    public void print()
    {
        for(int i=0; i<10; i++)
    {
        System.out.print("Hello World");
    }

    }
}
