package testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testng.dataprovider.LoginDataProviders;

public class LoginTestWithDataProvider {
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

    @DataProvider(name = "googleSearch-data")
    public Object[][] googleSearch() {
        return new Object[][]{{"search1"}, {"search2"}, {"search3"}};
    }

    @Test(groups = {"High"}, dataProvider = "googleSearch-data")
    public void DataProviderTest(String searchKeyword) {
        System.out.println("I am a DATA PROVIDER prametrized Test case , parameter = " + searchKeyword);
        System.out.println("User gets the results in the google page");
    }


    @DataProvider(name = "login-data")
    public Object[][] loginData() {
        //Add code to read csv/excel/json file
        //Return Object
        return new Object[][]{{"username1", "password1"}, {"username2", "password2"}};
    }

    @Test(groups = {"High"}, dataProvider = "login-data")
    public void loginTest(String username, String password) {
        System.out.println("I am a DATA PROVIDER prametrized Test case , parameter = " + username + "|| " + password);
        System.out.println("User gets the results in the google page");
    }

    //Getting DP from different CLass
    @Test(groups = {"High"}, dataProvider = "form-data", dataProviderClass = LoginDataProviders.class)
    public void formDataTest(String formKey, String formValue) {
        System.out.println("I am a DATA PROVIDER prametrized Test case , parameter = " + formKey + "|| " + formValue);
        System.out.println("User gets the results in the google page");
    }


}
