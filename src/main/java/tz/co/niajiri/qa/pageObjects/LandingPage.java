package tz.co.niajiri.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tz.co.niajiri.qa.LogTemplates.LogTemplates;
import tz.co.niajiri.qa.actionDriver.Action;

public class LandingPage extends LogTemplates {
    WebDriver driver;
    Action action = new Action();

    @FindBy(id = "signInButton")
    private WebElement signInButton;
    @FindBy(id = "registerButton")
    private WebElement registrationButton;
    @FindBy(id = "talentPageLink")
    private WebElement talentButton;
    @FindBy(id = "employerPageLink")
    private WebElement employerButton;
    @FindBy(xpath = "//h1[normalize-space()='Lets start with your basic Information']")
    private WebElement pageHeading;
    @FindBy(xpath = "//span[normalize-space()='Build Your CV here']")
    private WebElement buildYouCVHereButton;
    @FindBy(xpath = "//a[normalize-space()='Continue']")
    private WebElement continueButton;
    @FindBy(xpath = "//label[@id='uploadCVLabel']")
    private WebElement uploadCVLabel;
    @FindBy(xpath = "//label[@id='fromScratchLabel']")
    private WebElement fromScratchLabel;
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    private WebElement continueButtonToUpload;


    public LandingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSignInButton(){
        action.click(signInButton, LandingPage.class,LANDINGSIGNINBUTTON);
    }
    public void clickRegistrationUpButton(){
        action.click(registrationButton, LandingPage.class,LANDINGSREGISTRATIONBUTTON);
    }

    public void clickTalentButton(){
        action.click(talentButton, LandingPage.class,TALENTBUTTON);
    }
    public void clickBuildYourCVHereButton(){
        action.click(buildYouCVHereButton, LandingPage.class,BUILDYOURCVHEREBUTTON);
    }

    public void clickContinueButton(){
        action.click(continueButton, LandingPage.class,CONTINUEBUTTON);
    }

    public void clickUploadCVLabel(){
        action.click(uploadCVLabel, LandingPage.class,UPLOADCVLABEL);
    }

    public void clickFromScratchLabel(){
        action.click(fromScratchLabel, LandingPage.class,FROMSCRATCHLABEL);
    }

    public void clickContinueButtonToUpload(){
        action.click(continueButtonToUpload, LandingPage.class,CONTINUEBUTTON);
    }

    public String getPageHeadingText(){
        return pageHeading.getText();
    }
}
