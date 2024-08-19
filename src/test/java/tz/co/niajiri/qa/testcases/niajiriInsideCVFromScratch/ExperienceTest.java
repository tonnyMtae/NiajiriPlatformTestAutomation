package tz.co.niajiri.qa.testcases.niajiriInsideCVFromScratch;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import tz.co.niajiri.qa.actionDriver.Action;
import tz.co.niajiri.qa.base.Base;
import tz.co.niajiri.qa.pageObjects.*;
import tz.co.niajiri.qa.pageObjects.InsideCVFromScratch.ExperiencePage;
import tz.co.niajiri.qa.utilities.RetryListener;
import tz.co.niajiri.qa.utilities.WaitUtils;

import java.time.Duration;

@Listeners(tz.co.niajiri.qa.utilities.Listeners.class)
public class ExperienceTest extends Base {
    WebDriver driver;
    Action action;

    @BeforeMethod
    public void setUp() {
        action = new Action();
        loadCommonDataPropertiesFile();
        driver = initializeBrowserAndOpenApplicationURL(commonDataProperties.getProperty("browserName"));
    }

    @Test(description = "Niajiri Inside CV From Scratch > Verify Filling Experience Details With Valid Inputs", groups = {"ExperienceDetails"}, retryAnalyzer = RetryListener.class)
    public void verifyFillingExperienceDetailsWithValidInputs() throws InterruptedException {
        loadPropertiesFile();

        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickSignInButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.signInIntoNiajiri(properties.getProperty("validEmail"), properties.getProperty("validPassword"));

        WaitUtils.sleepTime(3);

        SideMenuItems sideMenuItems = new SideMenuItems(driver);
        sideMenuItems.clickJengaCVMenuItem();

        action.scrollDownByPixel(driver, ExperienceTest.class, 600);

        TemplateSelectionPage templateSelectionPage = new TemplateSelectionPage(driver);
        templateSelectionPage.ClickSkipForNowButton();

        NiajiriCVJourneyOptionPage niajiriCVJourneyOptionPage = new NiajiriCVJourneyOptionPage(driver);
        niajiriCVJourneyOptionPage.clickBuildCVFromScratchButton();

        ExperiencePage experiencePage = new ExperiencePage(driver);
        experiencePage.enterExperienceDetails();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
