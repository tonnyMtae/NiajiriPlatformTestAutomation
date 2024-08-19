package tz.co.niajiri.qa.testcases.niajiriInsideCVFromScratch;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import tz.co.niajiri.qa.actionDriver.Action;
import tz.co.niajiri.qa.base.Base;
import tz.co.niajiri.qa.pageObjects.*;
import tz.co.niajiri.qa.utilities.RetryListener;
import tz.co.niajiri.qa.utilities.WaitUtils;

@Listeners(tz.co.niajiri.qa.utilities.Listeners.class)
public class DownloadCVWithoutWatermarkTest extends Base {

    WebDriver driver;
    Faker faker;
    Action action;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        faker = new Faker();
        action = new Action();
        loadCommonDataPropertiesFile();
        driver = initializeBrowserAndOpenApplicationURL(commonDataProperties.getProperty("browserName"));
    }

    @Test(description = "Verify Downloading CV Without Watermark",  groups = {"DownloadCV"}, retryAnalyzer = tz.co.niajiri.qa.utilities.RetryListener.class)
    public void verifyDownloadingCVWithoutWatermark() throws InterruptedException {
        loadPropertiesFile();

        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickSignInButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.signInIntoNiajiri(properties.getProperty("validEmail"), properties.getProperty("validPassword"));

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
