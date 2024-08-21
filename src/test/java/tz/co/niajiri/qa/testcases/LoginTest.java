package tz.co.niajiri.qa.testcases;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import tz.co.niajiri.qa.pageObjects.LandingPage;
import tz.co.niajiri.qa.pageObjects.LoginPage;
import tz.co.niajiri.qa.base.Base;
import tz.co.niajiri.qa.pageObjects.SectorSkillsPage;
import tz.co.niajiri.qa.utilities.RetryListener;

import java.time.Duration;

@Listeners(tz.co.niajiri.qa.utilities.Listeners.class)
public class LoginTest extends Base {
    public WebDriver driver;
    SectorSkillsPage sectorSkillsPage;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        loadCommonDataPropertiesFile();
        driver = initializeBrowserAndOpenApplicationURL(commonDataProperties.getProperty("browserName"));
    }

    @Test(description = "Verify Login With Valid Credentials", groups = {"Login"}, retryAnalyzer = RetryListener.class)
    public void verifyLoginWithValidCredentials() throws InterruptedException {
        loadPropertiesFile();
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickSignInButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValidEmailText(properties.getProperty("validEmail"));
        loginPage.enterValidPasswordText(properties.getProperty("validPassword"));
        sectorSkillsPage = loginPage.clickSignInButton();
        Thread.sleep(Duration.ofSeconds(5));
        Assert.assertTrue(sectorSkillsPage.getDisplayStatusOfGenderDropdownOption());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}