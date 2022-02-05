package testcases.updated;

import org.testng.annotations.Test;
import testcases.base.BaseTest;

public class LoginPageTests extends BaseTest {


    @Test
    public void should_be_able_to_login_using_standardUser_valid_credentials() throws InterruptedException {

        //Init driver
        initializedDriver();

        //Call login method
        loginWithValidUserNameAndPassword();

        //validate if login is successful
        validateProductPage();

        //cleanup
        quitDriver();

    }


}
