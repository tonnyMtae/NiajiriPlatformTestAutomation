package tz.co.niajiri.qa.testcases.niajiriInsideCVUpload;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import tz.co.niajiri.qa.actionDriver.Action;
import tz.co.niajiri.qa.base.Base;
import tz.co.niajiri.qa.pageObjects.*;
import tz.co.niajiri.qa.pageObjects.InsideCVFromScratch.BasicDetailsPage;
import tz.co.niajiri.qa.pageObjects.InsideCVUpload.UploadPage;
import tz.co.niajiri.qa.utilities.RetryListener;
import tz.co.niajiri.qa.utilities.WaitUtils;

import java.time.Duration;

@Listeners(tz.co.niajiri.qa.utilities.Listeners.class)
public class UploadCVTest extends Base {
    WebDriver driver;
    Faker faker;
    Action action;

    @BeforeMethod
    public void setUp() {
        action = new Action();
        faker = new Faker();
        loadCommonDataPropertiesFile();
        driver = initializeBrowserAndOpenApplicationURL(commonDataProperties.getProperty("browserName"));
    }

    @Test(description = "Niajiri Inside CV Upload  >  Verify Functionality of Uploading CV", retryAnalyzer = RetryListener.class)
    public void verifyUploadingCVFunctionality() throws InterruptedException {

        loadPropertiesFile();

        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickSignInButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.signInIntoNiajiri(properties.getProperty("validEmail"), properties.getProperty("validPassword"));

        WaitUtils.sleepTime(5);

        SideMenuItems sideMenuItems = new SideMenuItems(driver);
        sideMenuItems.clickJengaCVMenuItem();

        action.scrollDownByPixel(driver, UploadCVTest.class, 600);

        WaitUtils.sleepTime(5);

        TemplateSelectionPage templateSelectionPage = new TemplateSelectionPage(driver);
        templateSelectionPage.ClickSkipForNowButton();

        WaitUtils.sleepTime(5);

        NiajiriCVJourneyOptionPage niajiriCVJourneyOptionPage = new NiajiriCVJourneyOptionPage(driver);
        niajiriCVJourneyOptionPage.clickBuildCVFromYourCVButton();

        WaitUtils.sleepTime(5);

        UploadPage uploadPage = new UploadPage(driver);
        uploadPage.uploadCVButton();
        WaitUtils.sleepTime(7);

        uploadPage.clickSubmitButton();
        WaitUtils.sleepTime(7);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
