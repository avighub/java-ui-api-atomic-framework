package report;

import com.aventstack.extentreports.ExtentTest;

import java.util.Objects;

public class ExtentFactory {

    private ExtentFactory() {
    }

    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static void setExtentTest(ExtentTest extentTestReference) {
        if (Objects.nonNull(extentTestReference)) {
            extentTest.set(extentTestReference);
        }
    }

    public static ExtentTest getExtentTest() {
        return extentTest.get();
    }

    public static void removeExtentTest() {
        extentTest.remove();
    }


}
