package tz.co.niajiri.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tz.co.niajiri.qa.base.Base;
import tz.co.niajiri.qa.pageObjects.AgreeTermsAndConditionPage;
import tz.co.niajiri.qa.pageObjects.LandingPage;
import tz.co.niajiri.qa.pageObjects.LoginPage;
import tz.co.niajiri.qa.pageObjects.SectorSkillsPage;
import tz.co.niajiri.qa.utilities.RetryListener;

import java.time.Duration;

public class AgreeTermsAndConditionTest extends Base {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        loadCommonDataPropertiesFile();
        driver = initializeBrowserAndOpenApplicationURL(commonDataProperties.getProperty("browserName"));
    }

    @Test(description = "Verify Agreeing to Terms and Condition", groups = {"TermsAndCondition"}, retryAnalyzer = RetryListener.class)
    public void verifyAgreeTermsAndConditions() throws InterruptedException {
        loadPropertiesFile();
        LandingPage landingPage = new LandingPage(driver);
        SectorSkillsPage sectorSkillsPage = new SectorSkillsPage(driver);
        AgreeTermsAndConditionPage agreeTermsAndConditionPage = new AgreeTermsAndConditionPage(driver);

        landingPage.clickSignInButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValidEmailText(properties.getProperty("validEmail"));
        loginPage.enterValidPasswordText(properties.getProperty("validPassword"));
        loginPage.clickSignInButton();
        Thread.sleep(Duration.ofSeconds(5));
        agreeTermsAndConditionPage.clickAgreeTermsAndCondition();
        Thread.sleep(Duration.ofSeconds(5));
        Assert.assertTrue(sectorSkillsPage.getDisplayStatusOfGenderDropdownOption());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
