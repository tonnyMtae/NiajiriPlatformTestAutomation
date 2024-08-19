package tz.co.niajiri.qa.pageObjects.InsideCVFromScratch;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tz.co.niajiri.qa.LogTemplates.LogTemplates;
import tz.co.niajiri.qa.actionDriver.Action;
import tz.co.niajiri.qa.utilities.WaitUtils;

import java.time.Duration;

import static tz.co.niajiri.qa.base.Base.getCleanTelephone;

public class RefereesPage extends LogTemplates {
    Faker faker;
    WebDriver driver;
    Action action = new Action();

    @FindBy(name = "referees[0][name]")
    private WebElement RefereeNameField;

    @FindBy(name = "referees[0][title]")
    private WebElement RefereeTitleField;

    @FindBy(name = "referees[0][organization]")
    private WebElement RefereeOrganizationField;

    @FindBy(name = "referees[0][email]")
    private WebElement RefereeEmailField;

    @FindBy(name = "referees[0][mobile]")
    private WebElement RefereePhoneNumberField;

    @FindBy(name = "referees[1][name]")
    private WebElement RefereeNameField1;

    @FindBy(name = "referees[1][title]")
    private WebElement RefereeTitleField1;

    @FindBy(name = "referees[1][organization]")
    private WebElement RefereeOrganizationField1;

    @FindBy(name = "referees[1][email]")
    private WebElement RefereeEmailField1;

    @FindBy(name = "referees[1][mobile]")
    private WebElement RefereePhoneNumberField1;

    @FindBy(id = "add_button_mobile")
    private WebElement AddRefereeButton;

    @FindBy(name = "referees[2][name]")
    private WebElement RefereeNameField2;

    @FindBy(name = "referees[2][title]")
    private WebElement RefereeTitleField2;

    @FindBy(name = "referees[2][organization]")
    private WebElement RefereeOrganizationField2;

    @FindBy(name = "referees[2][email]")
    private WebElement RefereeEmailField2;

    @FindBy(name = "referees[2][mobile]")
    private WebElement RefereePhoneNumberField2;

    @FindBy(xpath = "//button[@id='submit_button']")
    private WebElement SavePreferenceButton;

    public RefereesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterRefereeName(String refereeName){
        //action.scrollToElement(driver, RefereeNameField, EducationPage.class, REFEREENAME);
        action.sendKeys(RefereeNameField, refereeName, RefereesPage.class, REFEREENAME);
    }
    public void enterRefereeTitle(String refereeTitle){
        //action.scrollToElement(driver, RefereeTitleField, EducationPage.class, STARTDATECALENDERFIELD);
        action.sendKeys(RefereeTitleField, refereeTitle, RefereesPage.class, REFEREETITLE);
    }
    public void enterRefereeOrganization(String refereeOrgName){
        //action.scrollToElement(driver, RefereeOrganizationField, EducationPage.class, STARTDATECALENDERFIELD);
        action.sendKeys(RefereeOrganizationField, refereeOrgName, RefereesPage.class, REFEREEORGANIZATIONNAME);;
    }
    public void enterRefereeEmail(String refereeEmail){
        //action.scrollToElement(driver, RefereeEmailField, EducationPage.class, STARTDATECALENDERFIELD);
        action.sendKeys(RefereeEmailField, refereeEmail, RefereesPage.class, REFEREEEMAIL);
    }
    public void enterRefereePhoneNumber(String refereePhoneNumber){
        //action.scrollToElement(driver, RefereePhoneNumberField, EducationPage.class, STARTDATECALENDERFIELD);
        action.sendKeys(RefereePhoneNumberField, refereePhoneNumber, RefereesPage.class, REFEREEPHONENUMBER);
        RefereePhoneNumberField.sendKeys(Keys.TAB);
    }


    public void enterRefereeName1(String refereeName){
        action.scrollToElement(driver, RefereeNameField1, EducationPage.class, STARTDATECALENDERFIELD);
        action.sendKeys(RefereeNameField1, refereeName, RefereesPage.class, REFEREENAME);
    }
    public void enterRefereeTitle1(String refereeTitle){
        action.scrollToElement(driver, RefereeTitleField1, EducationPage.class, STARTDATECALENDERFIELD);
        action.sendKeys(RefereeTitleField1, refereeTitle, RefereesPage.class, REFEREETITLE);
    }
    public void enterRefereeOrganization1(String refereeOrgName){
        action.scrollToElement(driver, RefereeOrganizationField1, EducationPage.class, STARTDATECALENDERFIELD);
        action.sendKeys(RefereeOrganizationField1, refereeOrgName, RefereesPage.class, REFEREEORGANIZATIONNAME);
    }
    public void enterRefereeEmail1(String refereeEmail){
        action.scrollToElement(driver, RefereeEmailField1, EducationPage.class, STARTDATECALENDERFIELD);
        action.sendKeys(RefereeEmailField1, refereeEmail, RefereesPage.class, REFEREEEMAIL);
    }
    public void enterRefereePhoneNumber1(String refereePhoneNumber){
        action.scrollToElement(driver, RefereePhoneNumberField1, EducationPage.class, STARTDATECALENDERFIELD);
        action.sendKeys(RefereePhoneNumberField1, refereePhoneNumber, RefereesPage.class, REFEREEPHONENUMBER);
        RefereePhoneNumberField1.sendKeys(Keys.TAB);
    }

    public void clickAddRefereeButton(){
        action.scrollToElement(driver, AddRefereeButton, EducationPage.class, STARTDATECALENDERFIELD);
        action.click(AddRefereeButton, RefereesPage.class, ADDREFEREEBUTTON);
    }

    public void enterRefereeName2(String refereeName){
        action.sendKeys(RefereeNameField2, refereeName, RefereesPage.class, REFEREENAME);
    }
    public void enterRefereeTitle2(String refereeTitle){
        action.sendKeys(RefereeTitleField2, refereeTitle, RefereesPage.class, REFEREETITLE);
    }
    public void enterRefereeOrganization2(String refereeOrgName){
        action.sendKeys(RefereeOrganizationField2, refereeOrgName, RefereesPage.class, REFEREEORGANIZATIONNAME);
    }
    public void enterRefereeEmail2(String refereeEmail){
        action.sendKeys(RefereeEmailField2, refereeEmail, RefereesPage.class, REFEREEEMAIL);
    }
    public void enterRefereePhoneNumber2(String refereePhoneNumber){
        action.sendKeys(RefereePhoneNumberField2, refereePhoneNumber, RefereesPage.class, REFEREEPHONENUMBER);
        RefereePhoneNumberField2.sendKeys(Keys.TAB);
    }

    public void clickSaveReferenceButton(){
        action.click(SavePreferenceButton, RefereesPage.class, SAVEBUTTON);
    }

    public void enterRefereeDetails(){
        faker = new Faker();
        //action.scrollDownBy300Pixel(driver, RefereesPage.class);
        enterRefereeName(faker.name().fullName());
        enterRefereeTitle(faker.name().prefix());
        enterRefereeOrganization(faker.company().name());
        enterRefereeEmail(faker.internet().safeEmailAddress());
        enterRefereePhoneNumber(getCleanTelephone(faker.phoneNumber().phoneNumber()));

        WaitUtils.sleepTime(3);

        //action.scrollUpByPixel(driver, RefereesPage.class, 500);

        enterRefereeName1(faker.name().fullName());
        enterRefereeTitle1(faker.name().prefix());
        enterRefereeOrganization1(faker.company().name());
        enterRefereeEmail1(faker.internet().safeEmailAddress());
        enterRefereePhoneNumber1(getCleanTelephone(faker.phoneNumber().phoneNumber()));
        WaitUtils.sleepTime(3);

        //action.scrollUpByPixel(driver, RefereesPage.class, 500);

        clickAddRefereeButton();

        action.scrollUpByPixel(driver, RefereesPage.class, 600);
        enterRefereeName2(faker.name().fullName());
        enterRefereeTitle2(faker.name().prefix());
        enterRefereeOrganization2(faker.company().name());
        enterRefereeEmail2(faker.internet().safeEmailAddress());
        enterRefereePhoneNumber2(getCleanTelephone(faker.phoneNumber().phoneNumber()));
        WaitUtils.sleepTime(3);

        action.scrollUpByPixel(driver, RefereesPage.class, 300);

        clickSaveReferenceButton();
    }

}
