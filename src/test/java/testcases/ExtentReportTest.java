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

        //Create report object
        ExtentReports report = new ExtentReports();
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("Reports/Report.html");
        report.attachReporter(htmlReporter);

        //Setup Report information
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("applicationName");
        htmlReporter.config().setReportName("Report Name");

        //Create TestCase
        ExtentTest test = report.createTest("Test sample");

        //Append Step or log messages
        test.info("info message");
        test.pass("Pass message");
        test.warning("warn message");
        test.fail("Failing from Extent");

        //Write all data to Report
        report.flush();
    }

    @Test
    public void Checkout() {
        ExtentReports report = new ExtentReports();
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("Reports/Report.html");
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
