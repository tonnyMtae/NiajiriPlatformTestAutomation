package tz.co.niajiri.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import tz.co.niajiri.qa.actionDriver.Action;
import tz.co.niajiri.qa.utilities.WaitUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Base {

    Action action = new Action();

    public Properties properties;
    public Properties commonDataProperties;
    public Properties liveCredentialProperties;
    WebDriver driver;
    static String destinationPath = System.getProperty("user.dir") + "/src/main/java/com/testData.properties";
    static String commonDataDestinationPath= System.getProperty("user.dir")+"/src/main/java/com/commonData.properties";
    static String liveCredentialsDestinationPath= System.getProperty("user.dir")+"/src/main/java/com/liveCredentials.properties";


    public WebDriver initializeBrowserAndOpenApplicationURL(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--headless");
//            options.addArguments("--window-size=1920,1080");
            driver = new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080");
            driver = new FirefoxDriver(options);
        } else if (browserName.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080");
            driver = new EdgeDriver(options);
        } else if (browserName.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
            SafariOptions options = new SafariOptions();
        }
        else {
            throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
        action.openURLandMaximizeBrowser(driver, commonDataProperties.getProperty("globalURL"), commonDataProperties.getProperty("browserName"), Base.class);
        WaitUtils.sleepTime(7);
        return driver;
    }

    public WebDriver initializeBrowserAndOpenApplicationLiveURL(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
            driver = new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080");
            driver = new FirefoxDriver(options);
        } else if (browserName.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080");
            driver = new EdgeDriver(options);
        } else if (browserName.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
            SafariOptions options = new SafariOptions();
        }
        else {
            throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
        action.openURLandMaximizeBrowser(driver, liveCredentialProperties.getProperty("globalLiveURL"), liveCredentialProperties.getProperty("browserName"), Base.class);
        WaitUtils.sleepTime(7);
        return driver;
    }


    // Generate new unique email with a time stamp
    public static String generateEmailWithTimeStamp(){
        Date date = new Date();
        String timeStamp= date.toString().replace(" ", "_").replace(":", "_");
        return "qaTest_"+timeStamp+"@gmail.com";
    }
    public static synchronized String buildUniqueTextBySuffix(String suffix) {
        return buildUniqueText("", suffix, "");
    }

    public static synchronized String buildUniqueTextBySuffix(String suffix, String separator) {
        return buildUniqueText("", suffix, separator);
    }
    public static synchronized String buildUniqueText(String prefix, String suffix, String separator) {
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddHHmmssSS");
        String datetime = ft.format(dNow);
        try {
            Thread.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prefix + separator + datetime + separator + suffix;
    }

    public static void WriteValidRegistrationCredentials(String key, String value) throws IOException {
        // Step 1: Create an object of FileReader class. Can use FileWriter vs FileInputStream
        // Can add boolean parameter while creating file writer object; TRUE - data will be appended
        // to existing file; FALSE - existing data will be erased and new data will be written
        // Delete the existing file if it exists

        FileWriter fw = new FileWriter(destinationPath, true);

        // Step 2: Create an object of property class
        Properties properties = new Properties();

        // Step 3: Use the set property method to set property
        properties.setProperty(key, value);
        properties.store(fw, "Valid Login Credentials");
    }

    public void loadPropertiesFile(){
        properties = new Properties();
        //Locate the path of config.properties file
        File file = new File(destinationPath);
        try{
            // This stream is used to read the contents of the file.
            FileInputStream fis = new FileInputStream(file);
            // This method loads the properties from the file into the properties object.
            properties.load(fis);
        } catch (Throwable e){
            e.printStackTrace();
        }
    }

    public void loadCommonDataPropertiesFile(){
        commonDataProperties = new Properties();
        //Locate the path of config.properties file
        File commonDatafile = new File(commonDataDestinationPath);
        try{
            // This stream is used to read the contents of the file.
            FileInputStream cdfis = new FileInputStream(commonDatafile);
            // This method loads the properties from the file into the properties object.
            commonDataProperties.load(cdfis);
        } catch (Throwable e){
            e.printStackTrace();
        }
    }

    public void loadLiveCredentialPropertiesFile(){
        liveCredentialProperties = new Properties();
        //Locate the path of config.properties file
        File liveCredentialfile = new File(liveCredentialsDestinationPath);
        try{
            // This stream is used to read the contents of the file.
            FileInputStream lc = new FileInputStream(liveCredentialfile);
            // This method loads the properties from the file into the properties object.
            liveCredentialProperties.load(lc);
        } catch (Throwable e){
            e.printStackTrace();
        }
    }

    public static boolean cleanPropertiesFile() {
        File file = new File(destinationPath);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static String getCleanTelephone(String telephone) {
        // Remove all non-numeric characters
        String cleanedNumber = telephone.replaceAll("[^\\d]", "");
        // Ensure the number starts with '0'
        if (!cleanedNumber.startsWith("0")) {
            cleanedNumber = "0" + cleanedNumber;
        }
        // Truncate or pad the number to ensure it is exactly 10 digits long
        if (cleanedNumber.length() > 10) {
            cleanedNumber = cleanedNumber.substring(0, 10);
        } else if (cleanedNumber.length() < 10) {
            cleanedNumber = String.format("%10s", cleanedNumber).replace(' ', '0');
        }
        return cleanedNumber;
    }

}
