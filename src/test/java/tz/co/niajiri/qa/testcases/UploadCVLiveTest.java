package tz.co.niajiri.qa.testcases;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tz.co.niajiri.qa.actionDriver.Action;
import tz.co.niajiri.qa.base.Base;
import tz.co.niajiri.qa.pageObjects.*;
import tz.co.niajiri.qa.pageObjects.InsideCVUpload.UploadPage;
import tz.co.niajiri.qa.utilities.RetryListener;
import tz.co.niajiri.qa.utilities.WaitUtils;


@Listeners(tz.co.niajiri.qa.utilities.Listeners.class)
public class UploadCVLiveTest extends Base{
    WebDriver driver;
    Faker faker;
    Action action;

    @BeforeMethod
    public void setUp() {
        action = new Action();
        faker = new Faker();
        loadLiveCredentialPropertiesFile();
        driver = initializeBrowserAndOpenApplicationLiveURL(liveCredentialProperties.getProperty("browserName"));
    }

    @Test(description = "Niajiri Live Environment > Verify CV Parser functionality", retryAnalyzer = RetryListener.class)
    public void verifyUploadingCVFunctionality() throws InterruptedException {

        loadPropertiesFile();

        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickTalentButton();
        WaitUtils.sleepTime(5);
        action.scrollDownByPixel(driver, tz.co.niajiri.qa.testcases.niajiriInsideCVUpload.UploadCVTest.class, 600);

        WaitUtils.sleepTime(5);
        landingPage.clickBuildYourCVHereButton();
        WaitUtils.sleepTime(5);
        landingPage.clickContinueButton();

        WaitUtils.sleepTime(5);

        action.scrollDownByPixel(driver, tz.co.niajiri.qa.testcases.niajiriInsideCVUpload.UploadCVTest.class, 600);

        WaitUtils.sleepTime(5);

        TemplateSelectionPage templateSelectionPage = new TemplateSelectionPage(driver);
        templateSelectionPage.ClickSkipForNowButton();

        WaitUtils.sleepTime(5);

        landingPage.clickUploadCVLabel();
        WaitUtils.sleepTime(5);

        landingPage.clickContinueButtonToUpload();
        WaitUtils.sleepTime(5);

        UploadPage uploadPage = new UploadPage(driver);
        uploadPage.uploadCVButton();
        WaitUtils.sleepTime(15);

        uploadPage.clickSubmitButton();
        WaitUtils.sleepTime(20);

        String actualPageHeading = "Lets start with your basic Information";
        Assert.assertEquals(landingPage.getPageHeadingText(), actualPageHeading);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}