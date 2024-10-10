package tz.co.niajiri.qa.testcases.niajiriInsideCVFromScratch;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import tz.co.niajiri.qa.actionDriver.Action;
import tz.co.niajiri.qa.base.Base;
import tz.co.niajiri.qa.pageObjects.*;
import tz.co.niajiri.qa.pageObjects.InsideCVFromScratch.BasicDetailsPage;
import tz.co.niajiri.qa.utilities.RetryListener;

@Listeners(tz.co.niajiri.qa.utilities.Listeners.class)
public class BasicDetailsTest extends Base {
    WebDriver driver;
    Action action;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        action = new Action();
        loadCommonDataPropertiesFile();
        driver = initializeBrowserAndOpenApplicationURL(commonDataProperties.getProperty("browserName"));
    }

    @Test(description = "Niajiri Inside CV From Scratch > Verify Filling Basic Details With Valid Inputs", groups = {"BasicDetails"}, retryAnalyzer = RetryListener.class)
    public void verifyFillingBasicDetailsWithValidInputs() throws InterruptedException {
        loadPropertiesFile();

        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickSignInButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.signInIntoNiajiri(properties.getProperty("validEmail"), properties.getProperty("validPassword"));

        SideMenuItems sideMenuItems = new SideMenuItems(driver);
        sideMenuItems.clickJengaCVMenuItem();

        action.scrollDownByPixel(driver, BasicDetailsTest.class, 600);

        TemplateSelectionPage templateSelectionPage = new TemplateSelectionPage(driver);
        templateSelectionPage.ClickSkipForNowButton();


        NiajiriCVJourneyOptionPage niajiriCVJourneyOptionPage = new NiajiriCVJourneyOptionPage(driver);
        niajiriCVJourneyOptionPage.clickBuildCVFromScratchButton();

        BasicDetailsPage basicDetailsPage = new BasicDetailsPage(driver);
        basicDetailsPage.enterBasicDetails();

        //Add Assertions for Firstname, Email, and Phonenumber
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
