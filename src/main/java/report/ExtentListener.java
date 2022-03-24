package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.SeleniumUtils;
import utils.WebDriverFactory;

public class ExtentListener implements ITestListener {

    ExtentReports extentReports;

    @Override
    public void onStart(ITestContext context) {
        extentReports = ExtentManager.initReport();

    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentFactory.setExtentTest(ExtentManager.createTest(extentReports, result.getMethod().getMethodName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentFactory.getExtentTest().pass("Test case passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentFactory.getExtentTest().fail("Test case failed: " + result.getMethod().getMethodName());
        String base64String = SeleniumUtils.takeScreenshotAsBase64(WebDriverFactory.getDriver());
        ExtentFactory.getExtentTest().fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64String, "Click here").build());
        ExtentFactory.getExtentTest().log(Status.FAIL,result.getThrowable());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentFactory.getExtentTest().skip("Test case Skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentFactory.removeExtentTest();
        ExtentManager.flushReport(extentReports);
    }

}
