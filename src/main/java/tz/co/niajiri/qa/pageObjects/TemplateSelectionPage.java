package tz.co.niajiri.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import tz.co.niajiri.qa.LogTemplates.LogTemplates;
import tz.co.niajiri.qa.actionDriver.Action;

import java.time.Duration;

public class TemplateSelectionPage extends LogTemplates {

    WebDriver driver;
    Action action = new Action();
    @FindBy(xpath = "//button[normalize-space()='Skip for Now']")
    private WebElement SkipForNowButton;

    @FindBy(xpath = "//button[normalize-space()='Choose Template']")
    private WebElement ChooseTemplateButton;

    public TemplateSelectionPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ClickSkipForNowButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(SkipForNowButton));
        action.click(SkipForNowButton, TemplateSelectionPage.class, SKIPFORNOWBUTTON);
        SkipForNowButton.click();
    }
}
