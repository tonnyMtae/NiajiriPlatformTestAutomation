package tz.co.niajiri.qa.testcases.niajiriInsideCVFromScratch;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import tz.co.niajiri.qa.actionDriver.Action;
import tz.co.niajiri.qa.base.Base;
import tz.co.niajiri.qa.pageObjects.*;
import tz.co.niajiri.qa.pageObjects.InsideCVFromScratch.LanguagePage;
import tz.co.niajiri.qa.utilities.RetryListener;
import tz.co.niajiri.qa.utilities.WaitUtils;

@Listeners(tz.co.niajiri.qa.utilities.Listeners.class)
public class LanguageTest extends Base {
    WebDriver driver;
    Action action;

    @BeforeMethod
    public void setUp() {
        action = new Action();
        loadCommonDataPropertiesFile();
        driver = initializeBrowserAndOpenApplicationURL(commonDataProperties.getProperty("browserName"));
    }

    @Test(description = "Niajiri Inside CV From Scratch > Verify Filling Language", groups = {"LanguageDetails"}, retryAnalyzer = RetryListener.class)
    public void verifyFillingLanguages() throws InterruptedException {
        loadPropertiesFile();

        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickSignInButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.signInIntoNiajiri(properties.getProperty("validEmail"), properties.getProperty("validPassword"));

        SideMenuItems sideMenuItems = new SideMenuItems(driver);
        sideMenuItems.clickJengaCVMenuItem();

        action.scrollDownByPixel(driver, LanguageTest.class, 600);

        TemplateSelectionPage templateSelectionPage = new TemplateSelectionPage(driver);
        templateSelectionPage.ClickSkipForNowButton();

        WaitUtils.sleepTime(7);

        NiajiriCVJourneyOptionPage niajiriCVJourneyOptionPage = new NiajiriCVJourneyOptionPage(driver);
        niajiriCVJourneyOptionPage.clickBuildCVFromScratchButton();

        LanguagePage languagePage = new LanguagePage(driver);
        languagePage.enterLanguageDetails();

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
