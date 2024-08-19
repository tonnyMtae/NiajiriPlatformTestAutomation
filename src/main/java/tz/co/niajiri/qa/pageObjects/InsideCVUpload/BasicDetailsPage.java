package tz.co.niajiri.qa.pageObjects.InsideCVUpload;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import tz.co.niajiri.qa.LogTemplates.LogTemplates;
import tz.co.niajiri.qa.actionDriver.Action;
import tz.co.niajiri.qa.base.Base;
import tz.co.niajiri.qa.utilities.LoggerHelper;


import java.time.Duration;

public class BasicDetailsPage extends LogTemplates {
    WebDriver driver;
    Action action = new Action();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));


    @FindBy(id = "FullName")
    private WebElement FullNameField;

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement EmailField;

    @FindBy(xpath = "//input[@id='personalPhoneNumber']")
    private WebElement PhoneNumberField;

    @FindBy(id = "PhysicalAddress")
    private WebElement PhysicalAddressField;

    @FindBy(xpath = "//form[@class='flex flex-col sm:grid gap-y-3 gap-x-4 grid-cols-2']/child::div[5]/div/input[2]")
    private WebElement BirthDateCalenderField;

    @FindBy(css = "#bordered-radio-1")
    private WebElement MaleRadioButton;

    @FindBy(css = "#bordered-radio-2")
    private WebElement FemaleRadioButton;

    @FindBy(xpath = "//select[@id='Country']")
    private WebElement CountryDropdown;

    @FindBy(xpath = "//select[@id='Region']")
    private WebElement StateDropdown;

    @FindBy(xpath = "//textarea[@id='headerSummary']")
    private WebElement SummaryTextArea;

    @FindBy(xpath = "//button[@id='PreviousBtn']")
    private WebElement BackButton;

    @FindBy(xpath = "//button[@id='NextBtn']")
    private WebElement ContinueButton;

    public BasicDetailsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyExistenceOfCorrectFullName(String fullName){
        boolean isCorrectName = FullNameField.getText().trim().equalsIgnoreCase(fullName.trim());
        System.out.println(isCorrectName);
        if(!isCorrectName){
            action.sendKeys(FullNameField, fullName, BasicDetailsPage.class, FULLNAME);
        } else {
            System.out.println("Full name is already correct.");
        }
    }

    public void verifyExistenceOfCorrectEmail(String email){
        boolean isCorrectEmail = EmailField.getText().trim().equalsIgnoreCase(email.trim());
        System.out.println(isCorrectEmail);
        if(!isCorrectEmail){
            action.sendKeys(EmailField, email, BasicDetailsPage.class, EMAIL);
        } else {
            LoggerHelper.info(BasicDetailsPage.class, "Email is already correct");
        }
    }

    public void verifyExistenceOfCorrectPhoneNumber(String phoneNumber) throws InterruptedException {
        boolean isCorrectPhoneNumber = PhoneNumberField.getText().trim().equalsIgnoreCase(phoneNumber);
        System.out.println(isCorrectPhoneNumber);
        if(!isCorrectPhoneNumber){
            action.click(PhoneNumberField, BasicDetailsPage.class, PHONENUMBERFIELD);
            action.clear(PhoneNumberField, BasicDetailsPage.class, PHONENUMBERFIELD);
            Thread.sleep(Duration.ofSeconds(5));
            action.sendKeys(PhoneNumberField, phoneNumber, BasicDetailsPage.class, PHONENUMBER);
            Thread.sleep(Duration.ofSeconds(5));
        } else {
            LoggerHelper.info(BasicDetailsPage.class, "Phone number is already correct");
        }
    }

    public void verifyExistenceOfPhysicalAddress(String physicalAddress){
        boolean isEmptyField = PhysicalAddressField.getText().isEmpty();
        System.out.println(isEmptyField);
        if(isEmptyField){
            action.sendKeys(PhysicalAddressField, physicalAddress, BasicDetailsPage.class, PHYSICALADDRESS);
        } else {
            LoggerHelper.info(BasicDetailsPage.class,"Physical Address is already correct.");
        }
    }

    public void verifyExistenceOfBirthDate(String birthDate){
        boolean isEmptyField = BirthDateCalenderField.getText().isEmpty();
        if(isEmptyField){
            action.sendKeys(BirthDateCalenderField, birthDate, BasicDetailsPage.class, BIRTHDATE);
            action.keysEnter(BirthDateCalenderField, BasicDetailsPage.class, BIRTHDATEFIELD);
        } else {
            LoggerHelper.info(BasicDetailsPage.class,"Birth date is already correct.");
        }
    }

    public void selectCountry(String country){
        action.scrollToElement(driver, CountryDropdown, BasicDetailsPage.class, COUNTRYDROPDOWNFIELD);
        action.selectOptionByValue(CountryDropdown, country, BasicDetailsPage.class, COUNTRYDROPDOWN);
    }

    public void selectState(String state){
        action.scrollToElement(driver, StateDropdown, BasicDetailsPage.class, STATEDROPDOWNFIELD);
        action.selectOptionByValue(StateDropdown, state, BasicDetailsPage.class, STATEDROPDOWN);
    }

    public void selectMaleGender(){
        action.click(MaleRadioButton, BasicDetailsPage.class, MALERADIOBUTTON);
    }

    public void selectFemaleGender(){
        action.click(FemaleRadioButton, BasicDetailsPage.class, FEMALERADIOBUTTON);
    }

    public void verifyExistenceOfSummaryText(String summary){
        boolean isEmptyField = SummaryTextArea.getText().isEmpty();
        if(!isEmptyField){
            action.sendKeys(SummaryTextArea, summary, BasicDetailsPage.class, SUMMARY);
        } else {
            LoggerHelper.info(BasicDetailsPage.class,"Summary is already correct.");
        }
    }

    public void clickBackButton(){
        action.click(BackButton, BasicDetailsPage.class, BACKBUTTON);
    }

    public void clickContinueButton(){
        action.click(ContinueButton, BasicDetailsPage.class, CONTINUEBUTTON);
    }

}
