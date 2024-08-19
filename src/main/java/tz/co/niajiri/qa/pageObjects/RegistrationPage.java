package tz.co.niajiri.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tz.co.niajiri.qa.LogTemplates.LogTemplates;
import tz.co.niajiri.qa.actionDriver.Action;

public class RegistrationPage extends LogTemplates {
    WebDriver driver;
    Action action = new Action();

    @FindBy(xpath = "//input[@id='name']")
    private WebElement fullNameField;
    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailInputField;
    @FindBy(xpath = "//input[@id='mobile']")
    private WebElement phoneNumberField;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[normalize-space()='Register']")
    private WebElement signUpButton;
    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailLoginInputField;
    @FindBy(xpath = "//input[@id='login-password']")
    private WebElement passwordLoginInputField;
    @FindBy(xpath = "//button[normalize-space()='Sign In']")
    private WebElement signInButton;


    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterFullNameText(String fullName){
        action.sendKeys(fullNameField, fullName, RegistrationPage.class,FULLNAME);
    }
    public void enterEmailText(String email){
        action.sendKeys(emailInputField, email, RegistrationPage.class,EMAIL);
    }
    public void enterPhoneNumberText(String phoneNumber){
        action.sendKeys(phoneNumberField, phoneNumber, RegistrationPage.class ,PHONENUMBER);
    }
    public void enterPasswordText(String password){
        action.sendKeys(passwordField,password, RegistrationPage.class ,PASSWORD);
    }
    public void clickSignUpButton(){
        action.click(signUpButton, RegistrationPage.class,SIGNUPBUTTON);
    }
    public void enterLoginEmailText(String loginEmail){
        action.sendKeys(emailLoginInputField, loginEmail, RegistrationPage.class,EMAIL);
    }
    public void enterLoginPasswordText(String loginPassword){
        action.sendKeys(passwordLoginInputField, loginPassword, RegistrationPage.class,PASSWORD);
    }
    public void clickSignInButton(){
        action.click(signInButton, RegistrationPage.class,SIGNINBUTTON);
    }
}
