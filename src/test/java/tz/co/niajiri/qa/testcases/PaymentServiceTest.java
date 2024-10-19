package tz.co.niajiri.qa.testcases;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import tz.co.niajiri.qa.actionDriver.Action;
import tz.co.niajiri.qa.base.Base;
import tz.co.niajiri.qa.pageObjects.*;
import tz.co.niajiri.qa.utilities.RetryListener;

@Listeners(tz.co.niajiri.qa.utilities.Listeners.class)
public class PaymentServiceTest extends Base{
        WebDriver driver;
        Faker faker;
        Action action;
        SectorSkillsPage sectorSkillsPage;

        @BeforeMethod
        public void setUp() {
            action = new Action();
            faker = new Faker();
            loadLiveCredentialPropertiesFile();
            driver = initializeBrowserAndOpenApplicationLiveURL(liveCredentialProperties.getProperty("browserName"));
        }

        //

        @Test(description = "Niajiri Live Environment > Verify Payment service", retryAnalyzer = RetryListener.class)
        public void verifyFunctionalityOfPaymentService() throws InterruptedException {
            loadLiveCredentialPropertiesFile();
            LandingPage landingPage = new LandingPage(driver);

            landingPage.clickSignInButton();
            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterValidEmailText(liveCredentialProperties.getProperty("validEmail"));
            loginPage.enterValidPasswordText(liveCredentialProperties.getProperty("validPassword"));

            sectorSkillsPage = loginPage.clickSignInButton();
            PaymentServicePage paymentServicePage = new PaymentServicePage(driver);
            paymentServicePage.paymentTest();
        }
        @AfterMethod
        public void tearDown(){
            driver.quit();
        }
}
