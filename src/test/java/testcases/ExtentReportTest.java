package testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExtentReportTest {

    @Test
    public void loginToCheckout() {
        System.out.println("Some test");
//        //Create report object
        ExtentReports report = new ExtentReports();
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("Reports/Report2.html");
        report.attachReporter(htmlReporter);

        //Setup Report information
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("SauceLabs");
        htmlReporter.config().setReportName("Regression report Name");

//        Create TestCase
        ExtentTest test = report.createTest("loginToCheckout");

        //Append Step or log messages
        test.info("User entered username");
        test.info("User entered passowrd");
        //validation, assertion
        test.pass("User landed to product page");
//        test.warning("warn message");
        test.fail("Failing from Extent");

//        Write all data to Report
        report.flush();
    }

    //    @Test
    public void Checkout() {
        ExtentReports report = new ExtentReports();
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("Reports/Report2.html");
        report.attachReporter(htmlReporter);

        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("applicationName");
        htmlReporter.config().setReportName("Report Name");

        ExtentTest test = report.createTest("Test2 sample");
        test.info("info message");
        test.pass("Pass message");
        test.warning("warn message");

        Assert.assertTrue(false);

        report.flush();
    }


}
