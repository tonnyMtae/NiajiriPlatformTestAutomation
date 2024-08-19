package tz.co.niajiri.qa.pageObjects.InsideCVFromScratch;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tz.co.niajiri.qa.LogTemplates.LogTemplates;
import tz.co.niajiri.qa.actionDriver.Action;
import tz.co.niajiri.qa.utilities.LoggerHelper;

import java.time.Duration;

public class BasicDetailsPage extends LogTemplates {
    WebDriver driver;
    Action action = new Action();

    @FindBy(id = "first_name")
    private WebElement FirstNameField;

    @FindBy(name = "middle_name")
    private WebElement MiddleNameField;

    @FindBy(id = "surname")
    private WebElement SurnameField;

    @FindBy(id = "mobile")
    private WebElement PhoneNumberField;

    @FindBy(id = "email")
    private WebElement EmailField;

    @FindBy(id = "physical_address")
    private WebElement PhysicalAddressField;

    @FindBy(id = "country")
    private WebElement CountryDropdown;

    @FindBy(id = "state")
    private WebElement StateDropdown;

    @FindBy(xpath = "//textarea[@id='textAreaBasicDetails']/following-sibling::*//div[@class='note-editing-area']//div[@class='note-editable']")
    private WebElement TextArea;

    @FindBy(xpath = "//button[@id='basicDetailsBtnStepper']")
    private WebElement SaveBasicDetailsButton;

    @FindBy(xpath = "//button[@id='cancelBtnBasicDetailsStepper']")
    private WebElement CancelButton;

    public BasicDetailsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enteredFirstName(String firstName){
        System.out.println(FirstNameField.getText());
    }

    public void enteredSurname(){
        System.out.println(SurnameField.getText());
    }

    public void enteredPhoneNumber(String phoneNumber){
        System.out.println(PhoneNumberField.getText());
    }

    public void enteredEmail(String email){
        System.out.println(EmailField.getText());
    }

    public void enterPhysicalAddress(String physicalAddress){
        action.scrollToElement(driver, PhysicalAddressField, BasicDetailsPage.class, PHYSICALADDRESSFIELD);
        action.sendKeys(PhysicalAddressField, physicalAddress, BasicDetailsPage.class, PHYSICALADDRESS);
    }

    public void selectCountry(String country){
        action.scrollToElement(driver, CountryDropdown, BasicDetailsPage.class, COUNTRYDROPDOWNFIELD);
        action.selectOptionByValue(CountryDropdown, country, BasicDetailsPage.class, COUNTRYDROPDOWN);
    }

    public void selectState(String state){
        action.scrollToElement(driver, StateDropdown, BasicDetailsPage.class, STATEDROPDOWNFIELD);
        action.selectOptionByValue(StateDropdown, state, BasicDetailsPage.class, STATEDROPDOWN);
    }

    public void enterAboutMeSummary(String aboutMeSummary) throws InterruptedException {
        action.scrollToElement(driver, TextArea, BasicDetailsPage.class, TEXTAREAFIELD);
        action.sendKeys(TextArea, aboutMeSummary, BasicDetailsPage.class, SUMMARY);
        Thread.sleep(Duration.ofSeconds(5));
        TextArea.sendKeys(Keys.ENTER);
    }

    public void clickSaveButton(){
        action.click(SaveBasicDetailsButton, BasicDetailsPage.class, SAVEBUTTON);
    }

    public void clickCancelButton(){
        action.click(CancelButton, BasicDetailsPage.class, CANCELBUTTON);
    }

    public void enterBasicDetails() throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(5));
        enterPhysicalAddress("Kimara Temboni");
        selectCountry("Kenya");
        selectCountry("Tanzania");
        selectState("Arusha");
        enterAboutMeSummary("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        clickSaveButton();
    }
}
