package tz.co.niajiri.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tz.co.niajiri.qa.LogTemplates.LogTemplates;
import tz.co.niajiri.qa.actionDriver.Action;

public class AgreeTermsAndConditionPage extends LogTemplates {
    WebDriver driver;
    Action action = new Action();

    @FindBy(xpath = "//a[@class='pull-right']")
    private WebElement agreeTermsAndConditionButton;

    @FindBy(xpath = "//h1[contains(text(),'Terms and Conditions for Niajiri Platform operatin')]")
    private WebElement agreeTermsAndConditionStatement;




    public AgreeTermsAndConditionPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAgreeTermsAndCondition(){
        action.click(agreeTermsAndConditionButton, RegistrationPage.class, AGREETERMSANDCONDITION);
    }

    public boolean verifyExistanceOfAgreeTermsAndConditions(){
        return agreeTermsAndConditionStatement.getText().equalsIgnoreCase("Terms and Conditions for Niajiri Platform operating under Ekihya Limited");
    }
}
