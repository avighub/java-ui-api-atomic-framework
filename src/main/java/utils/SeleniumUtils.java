package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class SeleniumUtils {

    private SeleniumUtils() {
    }

    public static String takeScreenshotAsImage(WebDriver webdriver) throws IOException {

        //Convert web driver object to TakeScreenshot
        TakesScreenshot screenshotShot = ((TakesScreenshot) webdriver);

        //Call getScreenshotAs method to create image file
        File screenShotFile = screenshotShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination
        File screenshotPath = new File("Report/Screenshot/screenshot.png");

        //Copy file at destination
        FileUtils.copyFile(screenShotFile, screenshotPath);

        return null;
    }

    public static String takeScreenshotAsBase64(WebDriver webdriver) {

        //Convert web driver object to TakeScreenshot
        TakesScreenshot screenshotShot = ((TakesScreenshot) webdriver);

        //Call getScreenshotAs method to create image file
        return screenshotShot.getScreenshotAs(OutputType.BASE64);

    }

}
