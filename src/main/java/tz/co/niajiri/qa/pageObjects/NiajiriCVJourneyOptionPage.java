package tz.co.niajiri.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tz.co.niajiri.qa.LogTemplates.LogTemplates;
import tz.co.niajiri.qa.actionDriver.Action;

public class NiajiriCVJourneyOptionPage extends LogTemplates {
    WebDriver driver;
    Action action = new Action();
    @FindBy(xpath = "//a[@id='buildCvLink']")
    private WebElement BuildCVFromScratchButton;

    @FindBy(xpath = "//button[@id='uploadCvButton']")
    private WebElement BuildCVFromYourCVButton;

    public NiajiriCVJourneyOptionPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickBuildCVFromScratchButton(){
        action.click(BuildCVFromScratchButton, NiajiriCVJourneyOptionPage.class, BUILDCVFROMSCRATCHBUTTON);
    }

    public void clickBuildCVFromYourCVButton(){
        action.click(BuildCVFromYourCVButton, NiajiriCVJourneyOptionPage.class, BUILDCVFROMYOURCVBUTTON);
    }
}
