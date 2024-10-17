package tz.co.niajiri.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import tz.co.niajiri.qa.pageObjects.LandingPage;
import tz.co.niajiri.qa.pageObjects.LoginPage;
import tz.co.niajiri.qa.base.Base;
import tz.co.niajiri.qa.pageObjects.SectorSkillsPage;
import tz.co.niajiri.qa.utilities.RetryListener;

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
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
