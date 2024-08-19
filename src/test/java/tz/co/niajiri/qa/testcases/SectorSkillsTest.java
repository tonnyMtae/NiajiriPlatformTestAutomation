package tz.co.niajiri.qa.testcases;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import tz.co.niajiri.qa.base.Base;
import tz.co.niajiri.qa.pageObjects.LandingPage;
import tz.co.niajiri.qa.pageObjects.LoginPage;
import tz.co.niajiri.qa.pageObjects.SectorSkillsPage;
import tz.co.niajiri.qa.utilities.RetryListener;

import java.time.Duration;

@Listeners(tz.co.niajiri.qa.utilities.Listeners.class)
public class SectorSkillsTest extends Base {
    WebDriver driver;
    Faker faker;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        loadCommonDataPropertiesFile();
        driver = initializeBrowserAndOpenApplicationURL(commonDataProperties.getProperty("browserName"));
    }

    @Test(description = "Verify Profile Completion With Valid Inputs", groups = {"SectorSkillsDetails"}, retryAnalyzer = RetryListener.class)
    public void verifyProfileCompletionWithValidInputs() throws InterruptedException {
        loadPropertiesFile();

        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickSignInButton();


        LoginPage loginPage = new LoginPage(driver);
        Thread.sleep(Duration.ofSeconds(10));

        loginPage.signInIntoNiajiri(properties.getProperty("validEmail"), properties.getProperty("validPassword"));

        SectorSkillsPage sectorSkillsPage = new SectorSkillsPage(driver);
        // Add Assertion to verify the fullname input is equal to fullname in testData.properties
        sectorSkillsPage.uploadProfilePhoto();
        Thread.sleep(Duration.ofSeconds(3));

        sectorSkillsPage.selectGender();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");

        Thread.sleep(Duration.ofSeconds(5));
        sectorSkillsPage.selectBirthDate("1999", "January", "13");
        Thread.sleep(Duration.ofSeconds(3));

        sectorSkillsPage.selectInterestedSectors();

        Thread.sleep(Duration.ofSeconds(5));

        sectorSkillsPage.clickSubmitButton();
        Thread.sleep(Duration.ofSeconds(5));

        sectorSkillsPage.clickSaveButton();
        Thread.sleep(Duration.ofSeconds(5));

        // Assert the Acknowledgment message is Displayed

        js.executeScript("window.scrollBy(0,600)", "");
        sectorSkillsPage.clickContinueButton();
        Thread.sleep(Duration.ofSeconds(10));

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
