package tz.co.niajiri.qa.testcases;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import tz.co.niajiri.qa.base.Base;
import tz.co.niajiri.qa.pageObjects.LandingPage;
import tz.co.niajiri.qa.pageObjects.LoginPage;
import tz.co.niajiri.qa.pageObjects.SideMenuItems;
import tz.co.niajiri.qa.utilities.RetryListener;

import java.time.Duration;

@Listeners(tz.co.niajiri.qa.utilities.Listeners.class)
public class SideMenuItemsTest extends Base {
    WebDriver driver;
    Faker faker;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        loadCommonDataPropertiesFile();
        driver = initializeBrowserAndOpenApplicationURL(commonDataProperties.getProperty("browserName"));
    }

    @Test(description = "Verify Functionality Of JengaCV Menu Item", groups = {"SideMenuItem"}, retryAnalyzer = RetryListener.class)
    public void verifyFunctionalityOfJengaCVMenuItem() throws InterruptedException {
        loadPropertiesFile();

        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickSignInButton();

        LoginPage loginPage = new LoginPage(driver);

        Thread.sleep(Duration.ofSeconds(10));

        loginPage.signInIntoNiajiri(properties.getProperty("validEmail"), properties.getProperty("validPassword"));

        SideMenuItems sideMenuItems = new SideMenuItems(driver);
        sideMenuItems.clickJengaCVMenuItem();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
