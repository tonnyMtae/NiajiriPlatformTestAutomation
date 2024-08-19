package tz.co.niajiri.qa.testcases.niajiriInsideCVFromScratch;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import tz.co.niajiri.qa.actionDriver.Action;
import tz.co.niajiri.qa.base.Base;
import tz.co.niajiri.qa.pageObjects.*;
import tz.co.niajiri.qa.pageObjects.InsideCVFromScratch.RefereesPage;
import tz.co.niajiri.qa.utilities.RetryListener;
import tz.co.niajiri.qa.utilities.WaitUtils;

import java.time.Duration;

@Listeners(tz.co.niajiri.qa.utilities.Listeners.class)
public class RefereesTest extends Base {
    WebDriver driver;
    Action action;
    @BeforeMethod
    public void setUp() {
        action = new Action();
        loadCommonDataPropertiesFile();
        driver = initializeBrowserAndOpenApplicationURL(commonDataProperties.getProperty("browserName"));
    }

    @Test(description = "Niajiri Inside CV From Scratch > Verify Filling Valid Referees Details", groups = {"RefereesDetails"}, retryAnalyzer = RetryListener.class)
    public void verifyFillingRefereeDetailsWithValidInputs() throws InterruptedException {
        loadPropertiesFile();

        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickSignInButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.signInIntoNiajiri(properties.getProperty("validEmail"), properties.getProperty("validPassword"));

        SideMenuItems sideMenuItems = new SideMenuItems(driver);
        sideMenuItems.clickJengaCVMenuItem();

        action.scrollDownByPixel(driver, RefereesTest.class, 600);

        TemplateSelectionPage templateSelectionPage = new TemplateSelectionPage(driver);
        templateSelectionPage.ClickSkipForNowButton();

        WaitUtils.sleepTime(7);

        NiajiriCVJourneyOptionPage niajiriCVJourneyOptionPage = new NiajiriCVJourneyOptionPage(driver);
        niajiriCVJourneyOptionPage.clickBuildCVFromScratchButton();

        RefereesPage refereesPage = new RefereesPage(driver);
        refereesPage.enterRefereeDetails();

        WaitUtils.sleepTime(7);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
