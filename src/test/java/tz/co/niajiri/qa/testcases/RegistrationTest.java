package tz.co.niajiri.qa.testcases;

import com.mailslurp.apis.InboxControllerApi;
import com.mailslurp.apis.WaitForControllerApi;
import com.mailslurp.clients.ApiClient;
import com.mailslurp.clients.ApiException;
import com.mailslurp.clients.Configuration;
import com.mailslurp.models.Email;
import com.mailslurp.models.InboxDto;
import factories.UserFactory;
import okhttp3.OkHttpClient;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import tz.co.niajiri.qa.actionDriver.Action;
import tz.co.niajiri.qa.base.Base;
import tz.co.niajiri.qa.pageObjects.AgreeTermsAndConditionPage;
import tz.co.niajiri.qa.pageObjects.LandingPage;
import tz.co.niajiri.qa.pageObjects.RegistrationPage;
import org.openqa.selenium.JavascriptExecutor;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Listeners(tz.co.niajiri.qa.utilities.Listeners.class)
public class RegistrationTest extends Base {
    private static ApiClient mailslurpClient;
    private static InboxControllerApi inboxControllerApi;
    private static final String API_KEY = System.getenv("MAILSLURP_API_KEY");
    public WebDriver driver;
    private static final Long TIMEOUT = 90000L;
    private WebDriverWait wait;
    Action action = new Action();


    @BeforeMethod
    public void setUp() throws InterruptedException {
        loadCommonDataPropertiesFile();
        driver = initializeBrowserAndOpenApplicationURL(commonDataProperties.getProperty("browserName"));
        // IMPORTANT set timeout for the http client
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
                .readTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
                .build();
        mailslurpClient = Configuration.getDefaultApiClient();
        // IMPORTANT set api client timeouts
        mailslurpClient.setConnectTimeout(TIMEOUT.intValue());
        mailslurpClient.setWriteTimeout(TIMEOUT.intValue());
        mailslurpClient.setReadTimeout(TIMEOUT.intValue());
        // IMPORTANT set API KEY and client
        mailslurpClient.setHttpClient(httpClient);
        mailslurpClient.setApiKey(API_KEY);

        inboxControllerApi = new InboxControllerApi(mailslurpClient);
    }

    //, retryAnalyzer = RetryListener.class
    @Test(description = "Verify Registration and Email Verification", groups = {"Registration"})
    public void userCreatedSuccessfully_when_validateEmail() throws ApiException, InterruptedException, IOException {
        loadPropertiesFile();
        //loadCommonDataPropertiesFile();
        var user = UserFactory.createDefault();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        InboxDto inbox = inboxControllerApi.createInbox(
                null,
                Arrays.asList(),
                user.getFullname(),
                "description_example",
                true,
                false,
                null,
                900000L,
                false,
                 String.valueOf(InboxDto.InboxTypeEnum.HTTP_INBOX),
                false,
                null,
                null,
                null,
                null);

        String email = inbox.getEmailAddress();
        user.setEmail(email);
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickRegistrationUpButton();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        cleanPropertiesFile();

        registrationPage.enterFullNameText(user.getFullname());
        WriteValidRegistrationCredentials("FullName", user.getFullname());
        registrationPage.enterEmailText(user.getEmail());
        registrationPage.enterPhoneNumberText(getCleanTelephone(user.getTelephone()));
        WriteValidRegistrationCredentials("PhoneNumber", user.getTelephone());
        registrationPage.enterPasswordText(user.getPassword());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");

        Thread.sleep(Duration.ofSeconds(5));
        registrationPage.clickSignUpButton();
        var currentTime = OffsetDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        //var waitForControllerApi = new WaitForControllerApi(mailslurpClient);

        int maxAttempts = 5;
        int pollInterval = 10000; // 10 seconds
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            try {
                var waitForControllerApi = new WaitForControllerApi(mailslurpClient);
                Email receivedEmail = waitForControllerApi
                        .waitForLatestEmail(inbox.getId(), TIMEOUT, false, null, currentTime, null, 10000L);

                if (receivedEmail != null) {
                    System.out.println("Email received: " + receivedEmail.getBody());
                    var emailLink =
                            Arrays.stream(receivedEmail.getBody().split(System.getProperty("line.separator")))
                                    .filter(l -> l.contains("email=")).findFirst().get();
                    System.out.println(emailLink.trim());

                    driver.navigate().to(emailLink.trim());
                    System.out.println("Opened link");

                    registrationPage.enterLoginEmailText(user.getEmail());
                    WriteValidRegistrationCredentials("validEmail", user.getEmail());
                    System.out.println(user.getEmail());

                    registrationPage.enterLoginPasswordText(user.getPassword());
                    WriteValidRegistrationCredentials("validPassword", user.getPassword());
                    System.out.println(user.getPassword());

                    registrationPage.clickSignInButton();
                    Thread.sleep(Duration.ofSeconds(5));
                    break;  // Exit loop when email is received
                }
            } catch (ApiException e) {
                System.err.println("Attempt " + attempt + ": Failed to fetch email");
                Thread.sleep(pollInterval);  // Wait before next attempt
            }
        }

//        int retries = 5;
//        for (int i = 0; i < retries; i++) {
//            try {
//                // Your code to call MailSlurp API
//                var waitForControllerApi = new WaitForControllerApi(mailslurpClient);
//                Email receivedEmail = waitForControllerApi
//                        .waitForLatestEmail(inbox.getId(), TIMEOUT, false, null, currentTime, null, 10000L);
//                var emailLink =
//                        Arrays.stream(receivedEmail.getBody().split(System.getProperty("line.separator")))
//                                .filter(l -> l.contains("email=")).findFirst().get();
//
//                System.out.println(emailLink.trim());
//
//                driver.navigate().to(emailLink.trim());
//                System.out.println("Opened link");
//                break;  // Exit loop if successful
//            } catch (ApiException e) {
//                if (i == retries - 1) {
//                    throw e;  // Rethrow exception after last retry
//                }
//                // Wait and retry
//                Thread.sleep(5000);  // Wait for 5 seconds before retrying
//            }
//        }

//        Email receivedEmail = waitForControllerApi
//                .waitForLatestEmail(inbox.getId(), TIMEOUT, false, null, currentTime, null, 10000L);

//        var emailLink =
//                Arrays.stream(receivedEmail.getBody().split(System.getProperty("line.separator")))
//                        .filter(l -> l.contains("email=")).findFirst().get();
//
//        System.out.println(emailLink.trim());
//
//        driver.navigate().to(emailLink.trim());
//        System.out.println("Opened link");
//
//        registrationPage.enterLoginEmailText(user.getEmail());
//        WriteValidRegistrationCredentials("validEmail", user.getEmail());
//        System.out.println(user.getEmail());
//
//        registrationPage.enterLoginPasswordText(user.getPassword());
//        WriteValidRegistrationCredentials("validPassword", user.getPassword());
//        System.out.println(user.getPassword());
//
//        registrationPage.clickSignInButton();
//        Thread.sleep(Duration.ofSeconds(5));
        AgreeTermsAndConditionPage agreeTermsAndConditionPage= new AgreeTermsAndConditionPage(driver);
        Assert.assertTrue(agreeTermsAndConditionPage.verifyExistanceOfAgreeTermsAndConditions());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}


