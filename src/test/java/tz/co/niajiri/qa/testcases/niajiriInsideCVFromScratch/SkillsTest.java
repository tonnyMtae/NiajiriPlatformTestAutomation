package tz.co.niajiri.qa.testcases.niajiriInsideCVFromScratch;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import tz.co.niajiri.qa.actionDriver.Action;
import tz.co.niajiri.qa.base.Base;
import tz.co.niajiri.qa.pageObjects.*;
import tz.co.niajiri.qa.pageObjects.InsideCVFromScratch.SkillsPage;
import tz.co.niajiri.qa.utilities.RetryListener;
import tz.co.niajiri.qa.utilities.WaitUtils;

import java.time.Duration;

@Listeners(tz.co.niajiri.qa.utilities.Listeners.class)
public class SkillsTest extends Base {

    WebDriver driver;
    Action action;

    @BeforeMethod
    public void setUp() {
        action = new Action();
        loadCommonDataPropertiesFile();
        driver = initializeBrowserAndOpenApplicationURL(commonDataProperties.getProperty("browserName"));
    }

    @Test(description = "Niajiri Inside CV From Scratch > Verify Filling Valid Skills Details", groups = {"SkillsDetails"}, retryAnalyzer = RetryListener.class)
    public void verifyFillingValidSkillsDetails() throws InterruptedException {
        loadPropertiesFile();

        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickSignInButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.signInIntoNiajiri(properties.getProperty("validEmail"), properties.getProperty("validPassword"));

        SideMenuItems sideMenuItems = new SideMenuItems(driver);
        sideMenuItems.clickJengaCVMenuItem();

        action.scrollDownByPixel(driver, SkillsTest.class, 600);

        TemplateSelectionPage templateSelectionPage = new TemplateSelectionPage(driver);
        templateSelectionPage.ClickSkipForNowButton();

        WaitUtils.sleepTime(7);

        NiajiriCVJourneyOptionPage niajiriCVJourneyOptionPage = new NiajiriCVJourneyOptionPage(driver);
        niajiriCVJourneyOptionPage.clickBuildCVFromScratchButton();

        SkillsPage skillsPage = new SkillsPage(driver);
        skillsPage.enterSkillDetails();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
