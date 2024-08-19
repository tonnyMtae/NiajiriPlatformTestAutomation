package tz.co.niajiri.qa.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ExtentReporter{
    public static ExtentReports generateExtentReport() throws IOException {
        ExtentReports extentReport = new ExtentReports();
        File extentReportFile = new File(System.getProperty("user.dir")+"/test-output/ExtentReports/extentReport.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);

        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setReportName("Niajiri Platform Test Automation Result");
        sparkReporter.config().setDocumentTitle("Niajiri Platform Automation Report");
        sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");

        extentReport.attachReporter(sparkReporter);


        Properties testData = new Properties();
        File testDataPropFile = new File(System.getProperty("user.dir")+"/src/main/java/com/testData.properties");

        Properties commonData = new Properties();
        File commonDataPropFile = new File(System.getProperty("user.dir")+"/src/main/java/com/commonData.properties");

        try {
            FileInputStream tdFisConfigProp = new FileInputStream(testDataPropFile);
            testData.load(tdFisConfigProp);
        }
        catch (Throwable e){
            e.printStackTrace();
        }

        try {
            FileInputStream cmdFisConfigProp = new FileInputStream(commonDataPropFile);
            commonData.load(cmdFisConfigProp);
        }
        catch (Throwable e){
            e.printStackTrace();
        }

        extentReport.setSystemInfo("Application URL", commonData.getProperty("globalURL"));
        extentReport.setSystemInfo("Browser Name", commonData.getProperty("browserName"));
        extentReport.setSystemInfo("Talent Name", testData.getProperty("FullName"));
        extentReport.setSystemInfo("Email", testData.getProperty("validEmail"));
        extentReport.setSystemInfo("Password", testData.getProperty("validPassword"));
        extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
        extentReport.setSystemInfo("Username", System.getProperty("user.name"));
        extentReport.setSystemInfo("Country", System.getProperty("user.country"));
        extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));

        return extentReport;
    }
}
