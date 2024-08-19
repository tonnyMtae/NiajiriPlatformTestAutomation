package tz.co.niajiri.qa.pageObjects.InsideCVUpload;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tz.co.niajiri.qa.LogTemplates.LogTemplates;
import tz.co.niajiri.qa.actionDriver.Action;
import tz.co.niajiri.qa.base.Base;
import tz.co.niajiri.qa.utilities.WaitUtils;

import java.time.Duration;
import java.util.List;

public class RefereesPage extends LogTemplates {
    Faker faker;
    WebDriver driver;
    Action action = new Action();

    @FindBy(id = "FullName")
    private WebElement RefereeNameField;

    @FindBy(id = "Title")
    private WebElement RefereeTitleField;

    @FindBy(id = "Organization")
    private WebElement RefereeOrganizationField;

    @FindBy(id = "EmailAddress")
    private WebElement RefereeEmailField;

    @FindBy(id = "mobile")
    private WebElement RefereePhoneNumberField;

    @FindBy(id = "NextBtn")
    private WebElement ContinueToListButton;

    @FindBy(id = "PreviousBtn")
    private WebElement BackToListButton;

    @FindBy(id = "FinishBtn")
    private WebElement ContinueToSelectTemplateButton;

    @FindBy(id = "PreviousBtn")
    private WebElement BackToLanguageButton;

    @FindBy(id = "AddAnotherBtn")
    private WebElement AddAnotherRefereeButton;

    public RefereesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddAnotherRefereeButton(){action.click(AddAnotherRefereeButton, RefereesPage.class,ADDREFEREEBUTTON);}
    public void clickBackToLanguageButton(){action.click(BackToLanguageButton, RefereesPage.class, BACKBUTTON);}
    public void clickContinueToListButton(){action.click(ContinueToListButton, RefereesPage.class, CONTINUETOREFEREESBUTTON);}

    public void enterTitleName(String title){
        action.sendKeys(RefereeTitleField, title, RefereesPage.class, REFEREETITLE);
    }

    public void enterRefereeName(String name){
        action.sendKeys(RefereeNameField, name, RefereesPage.class, REFEREENAME);
    }

    public void enterRefereeOrganization(String organization){
        action.sendKeys(RefereeOrganizationField, organization, RefereesPage.class, REFEREEORGANIZATIONNAME);
    }

    public void enterRefereeMobile(String mobileNumber) throws InterruptedException {
        faker = new Faker();
//        String mobile = getCleanTelephone(faker.phoneNumber().phoneNumber());
//        System.out.println("Original phone number: " + mobile);
//        if (mobile.startsWith("0")) {
//            mobile = mobile.substring(1);
//        }
//        String mobileNumber = mobile;
//        System.out.println("+255" + mobile);
        action.sendKeys(RefereePhoneNumberField, mobileNumber, RefereesPage.class, REFEREEPHONENUMBER);
//        RefereePhoneNumberField.click();
//        RefereePhoneNumberField.clear();
//        Thread.sleep(Duration.ofSeconds(5));
//        RefereePhoneNumberField.sendKeys(mobileNumber);
        WaitUtils.sleepTime(5);
    }

    public void enterRefereeEmail(String email){
//        RefereeEmailField.click();
//        RefereeEmailField.clear();
//        RefereeEmailField.sendKeys(email);
        action.sendKeys(RefereeEmailField, email, RefereesPage.class, REFEREEEMAIL);
    }

    public void clickContinueToSelectTemplateButton(){action.click(ContinueToSelectTemplateButton, RefereesPage.class, CONTINUETOSELECTTEMPLATEBUTTON);}

    public void enterRefereesDetails() throws InterruptedException {
        Faker faker = new Faker();
        enterRefereeName(faker.name().fullName());
        WaitUtils.sleepTime(3);
        enterTitleName(faker.job().title());
        WaitUtils.sleepTime(3);
        enterRefereeOrganization(faker.company().name());
        WaitUtils.sleepTime(3);
        enterRefereeMobile(Base.getCleanTelephone(faker.phoneNumber().phoneNumber()));
        WaitUtils.sleepTime(3);
        enterRefereeEmail(faker.internet().emailAddress());
        WaitUtils.sleepTime(3);
    }

    public void reviewReferees() throws InterruptedException {
        WaitUtils.sleepTime(7);
        List<WebElement> referees = driver.findElements(By.xpath("//body/div/div/div/div/div/div/div/div[2]/div"));
        boolean isZeroElements = referees.isEmpty();
        if(isZeroElements){
            for(int i=0; i < 3; i++){
                action.scrollUpByPixel(driver, RefereesPage.class, 600);
                clickAddAnotherRefereeButton();
                enterRefereesDetails();
                clickContinueToListButton();
            }
            clickContinueToSelectTemplateButton();
        }
        else {
            System.out.println(referees.size());
            for(int x=1; x<=referees.size(); x++){
                WebElement editButton = driver.findElement(By.xpath("(//span[normalize-space()='Edit'])["+ x +"]"));
                WaitUtils.sleepTime(3);
                action.scrollToElement(driver, editButton, RefereesPage.class, REFEREESEDITBUTTON);
                editButton.click();
                WaitUtils.sleepTime(3);
                enterRefereesDetails();
                clickContinueToListButton();
                WaitUtils.sleepTime(3);
            }
            action.scrollDownVertically(driver, RefereesPage.class);
            WaitUtils.sleepTime(3);
            clickContinueToSelectTemplateButton();
            WaitUtils.sleepTime(3);
        }
    }
}
