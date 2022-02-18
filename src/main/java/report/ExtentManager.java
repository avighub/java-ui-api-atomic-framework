package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import utils.BrowserFactory;
import utils.PropertyUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class ExtentManager {

    private ExtentManager() {
    }

    public static ExtentReports initReport() {

        ExtentReports extentReports = null;
        String applicationName = PropertyUtils.configProperties.getProperty("APPLICATION_NAME");
        String version = PropertyUtils.configProperties.getProperty("VERSION");
        String date = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(new Date());
        String environment = PropertyUtils.configProperties.getProperty("ENVIRONMENT");

        //Creating HTML File
        extentReports = new ExtentReports();
        String reportname = "Automation_Report_" + date + "_" + environment + ".html";
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("Reports/" + reportname);

        //Decorating with Theme and Filling Basic Report Information
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(applicationName);
        htmlReporter.config().setReportName("Automation Report: V" + version);

        //Adding Environment details
        extentReports.setSystemInfo("Test environment", environment);
        extentReports.setSystemInfo("Operating System", System.getProperty("os.name"));
        extentReports.setSystemInfo("Test Browser", BrowserFactory.browserName);
        extentReports.setSystemInfo("Browser Mode", BrowserFactory.browserMode);

        //Attaching the HTML reporter
        extentReports.attachReporter(htmlReporter);
        return extentReports;
    }


    public static ExtentTest createTest(ExtentReports extentReports, String testName) {
        return extentReports.createTest(testName);
    }

    public static void flushReport(ExtentReports extentReports) {
        if (Objects.nonNull(extentReports)) {
            extentReports.flush();
        }
    }


}
