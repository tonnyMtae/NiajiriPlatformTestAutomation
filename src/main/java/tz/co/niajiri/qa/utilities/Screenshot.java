package tz.co.niajiri.qa.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class Screenshot {
    public static String captureScreenshot(WebDriver driver, String testName) throws InterruptedException, IOException {
        File scrScreenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destinationScreenshotPath = System.getProperty("user.dir")+"/Screenshots/"+testName+".png";
        try {
            FileHandler.copy(scrScreenshotFile, new File(destinationScreenshotPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return destinationScreenshotPath;
    }
}
