package tz.co.niajiri.qa.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Listeners implements ITestListener {
    ExtentReports extentReports;
    ExtentTest extentTest;
    String testName;
    @Override
    public void onStart(ITestContext context) {
        try {
            extentReports = ExtentReporter.generateExtentReport();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        testName = result.getMethod().getDescription();
        extentTest = extentReports.createTest(testName);
        extentTest.log(Status.INFO, testName+"  :  --> started executing");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        testName = result.getMethod().getDescription();
        extentTest.log(Status.PASS, testName+"  :  --> successFully executed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        testName = result.getMethod().getDescription();
        WebDriver driver = null;
        try {
            driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        String destinationScreenshotPath = null;
        try {
            destinationScreenshotPath = Screenshot.captureScreenshot(driver, testName);
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
        extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
        extentTest.log(Status.INFO, result.getThrowable());
        extentTest.log(Status.FAIL, testName+ "  :  --> Got Failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        testName = result.getMethod().getDescription();
        extentTest.log(Status.INFO, result.getThrowable());
        extentTest.log(Status.SKIP, testName+ "  :   --> got skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
        String pathOfExtentReport = System.getProperty("user.dir")+"/test-output/ExtentReports/extentReport.html";
        File extentReport = new File(pathOfExtentReport);
        try {
            Desktop.getDesktop().browse(extentReport.toURI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
