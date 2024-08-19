package tz.co.niajiri.qa.testcases.niajiriInsideCVUpload;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import tz.co.niajiri.qa.actionDriver.Action;
import tz.co.niajiri.qa.base.Base;
import tz.co.niajiri.qa.pageObjects.*;
import tz.co.niajiri.qa.pageObjects.InsideCVUpload.BasicDetailsPage;
import tz.co.niajiri.qa.pageObjects.InsideCVUpload.EducationPage;
import tz.co.niajiri.qa.pageObjects.InsideCVUpload.ExperiencePage;
import tz.co.niajiri.qa.pageObjects.InsideCVUpload.UploadPage;
import tz.co.niajiri.qa.utilities.RetryListener;
import tz.co.niajiri.qa.utilities.WaitUtils;

import java.time.Duration;
@Listeners(tz.co.niajiri.qa.utilities.Listeners.class)
public class ExperienceTest extends Base {
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

    @Test(description = "Niajiri Inside CV Upload > Verify Filling Experience Details With Valid Inputs", retryAnalyzer = RetryListener.class)
    public void verifyFillingExperienceDetailsWithValidInputs() throws InterruptedException {

        loadPropertiesFile();

        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickSignInButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.signInIntoNiajiri(properties.getProperty("validEmail"), properties.getProperty("validPassword"));

        WaitUtils.sleepTime(5);

        SideMenuItems sideMenuItems = new SideMenuItems(driver);
        sideMenuItems.clickJengaCVMenuItem();

        action.scrollUpByPixel(driver, BasicDetailsPage.class, 600);

        WaitUtils.sleepTime(5);

        TemplateSelectionPage templateSelectionPage = new TemplateSelectionPage(driver);
        templateSelectionPage.ClickSkipForNowButton();

        WaitUtils.sleepTime(10);

        NiajiriCVJourneyOptionPage niajiriCVJourneyOptionPage = new NiajiriCVJourneyOptionPage(driver);
        niajiriCVJourneyOptionPage.clickBuildCVFromYourCVButton();

        WaitUtils.sleepTime(5);

        UploadPage uploadPage = new UploadPage(driver);
        uploadPage.uploadCVButton();
        WaitUtils.sleepTime(10);

        uploadPage.clickSubmitButton();
        WaitUtils.sleepTime(10);

        BasicDetailsPage basicDetailsPage = new BasicDetailsPage(driver);
        loadPropertiesFile();
        basicDetailsPage.verifyExistenceOfCorrectFullName(properties.getProperty("FullName"));

        basicDetailsPage.verifyExistenceOfCorrectEmail(properties.getProperty("validEmail"));
        basicDetailsPage.verifyExistenceOfCorrectPhoneNumber(getCleanTelephone(properties.getProperty("PhoneNumber").trim()));
        basicDetailsPage.verifyExistenceOfPhysicalAddress(faker.address().streetAddress());

        action.scrollUpByPixel(driver, BasicDetailsPage.class, 600);

        basicDetailsPage.verifyExistenceOfBirthDate("June 9, 1995");
        basicDetailsPage.selectCountry("Tanzania");
        basicDetailsPage.selectState("Arusha");
        basicDetailsPage.verifyExistenceOfSummaryText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        basicDetailsPage.clickContinueButton();

        ExperiencePage experiencePage = new ExperiencePage(driver);
        experiencePage.reviewExperiences();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
