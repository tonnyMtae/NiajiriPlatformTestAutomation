package tz.co.niajiri.qa.testcases;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import tz.co.niajiri.qa.actionDriver.Action;
import tz.co.niajiri.qa.base.Base;
import tz.co.niajiri.qa.pageObjects.*;
import tz.co.niajiri.qa.utilities.RetryListener;
import tz.co.niajiri.qa.utilities.WaitUtils;

@Listeners(tz.co.niajiri.qa.utilities.Listeners.class)
public class PaymentServiceTest extends Base{
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

        @Test(description = "Niajiri Inside CV Upload > Verify Filling Basic Details With Valid Inputs", retryAnalyzer = RetryListener.class)
        public void verifyFunctionalityOfPaymentService() throws InterruptedException {

            loadPropertiesFile();

            LandingPage landingPage = new LandingPage(driver);
            landingPage.clickSignInButton();

            LoginPage loginPage = new LoginPage(driver);
            loginPage.signInIntoNiajiri("cejihuci@clip.lat", "cejihuci@clip");

            WaitUtils.sleepTime(3);

            SideMenuItems sideMenuItems = new SideMenuItems(driver);
            sideMenuItems.clickJengaCVMenuItem();

            WaitUtils.sleepTime(3);

            DownloadCVWithoutWatermarkPage downloadCVWithoutWatermarkPage = new DownloadCVWithoutWatermarkPage(driver);
            downloadCVWithoutWatermarkPage.downloadCVWithoutWatermark();

            WaitUtils.sleepTime(3);
        }
        @AfterMethod
        public void tearDown(){
            driver.quit();
        }
}
