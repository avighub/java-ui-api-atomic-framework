package testng.dataprovider;

import org.testng.annotations.DataProvider;

public class LoginDataProviders {



    @DataProvider(name = "form-data")
    public Object[][] formData() {
        //Add code to read csv/excel/json file
        //Return Object
        return new Object[][]{{"form1", "value1"}, {"form2", "value2"}};
    }

}
