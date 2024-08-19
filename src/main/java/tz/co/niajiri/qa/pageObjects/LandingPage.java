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
    public void clickEmployerButton(){
        action.click(employerButton, LandingPage.class,EMPLOYERBUTTON);
    }
}
