package tz.co.niajiri.qa.pageObjects.InsideCVUpload;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tz.co.niajiri.qa.LogTemplates.LogTemplates;
import tz.co.niajiri.qa.actionDriver.Action;
import tz.co.niajiri.qa.utilities.WaitUtils;

import java.time.Duration;
import java.util.List;

public class SkillsPage extends LogTemplates {

    WebDriver driver;
    Action action = new Action();

    @FindBy(id = "addSoftSkillBtn")
    private WebElement AddSoftSkillButton;

    @FindBy(id = "SoftSkillSideoverSave")
    private WebElement SoftSkillBackButton;

    @FindBy(id = "softSkillSearch")
    private WebElement SoftSkillSearchField;

    @FindBy(id = "addTechnicalSkillBtn")
    private WebElement AddTechnicalSkillButton;

    @FindBy(id = "TechnicalSkillSideoverSave")
    private WebElement TechnicalSkillBackButton;

    @FindBy(id = "TechnicalSkillsSearch")
    private WebElement TechnicalSkillSearchField;

    @FindBy(id = "addInterestBtn")
    private WebElement AddInterestButton;

    @FindBy(id = "interestSideoverSave")
    private WebElement InterestBackButton;

    @FindBy(id = "InterestSearch")
    private WebElement InterestSearchField;

    @FindBy(xpath = "//button[normalize-space()='Continue']")
    private WebElement ContinueToLanguageButton;


    public SkillsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddSoftSkillButton(){
        action.click(AddSoftSkillButton, SkillsPage.class, ADDSOFTSKILLSBUTTON);
    }
    public void selectSoftSkills(){
        List<WebElement> softSkills = driver.findElements(By.xpath("//div[@id='SoftSkillsOptionContainer']//ul//li//div//input"));
        for(int s = 2; s<softSkills.size();s++){
            if(s<5){
                softSkills.get(s).click();
            }
            else{
                break;
            }
        }
    }
    public void exitSoftSkills(){
        action.scrollToElement(driver, SoftSkillBackButton, SkillsPage.class, SOFTSKILLSBACKBUTTON);
        action.click(SoftSkillBackButton, SkillsPage.class, SOFTSKILLSBACKBUTTON);
    }


    public void clickAddTechnicalSkillButton(){
        action.click(AddTechnicalSkillButton, SkillsPage.class, ADDTECHNICALSKILLBUTTON);
    }
    public void selectTechnicalSkills(){
        List<WebElement> technicalSkills = driver.findElements(By.xpath("//div[@id='TechnicalSkillsOptionContainer']//ul//ul//li//div//input"));
        for(int s = 2; s<technicalSkills.size();s++){
            if(s<5){
                technicalSkills.get(s).click();
            }
            else{
                break;
            }
        }
    }
    public void exitTechnicalSkills(){
        action.scrollToElement(driver, TechnicalSkillBackButton, SkillsPage.class, TECHNICALSKILLBACKBUTTON);
        action.click(TechnicalSkillBackButton, SkillsPage.class, TECHNICALSKILLBACKBUTTON);
    }


    public void clickAddInterestButton(){
        action.scrollToElement(driver, AddInterestButton, SkillsPage.class, ADDINTERESTBUTTON);
        action.click(AddInterestButton, SkillsPage.class, ADDINTERESTBUTTON);
    }
    public void selectInterest(){
        List<WebElement> interests = driver.findElements(By.xpath("//div[@id='InterestOptionsContainer']//ul//li//div//input"));
        for(int s = 2; s<interests.size();s++){
            if(s<5){
                interests.get(s).click();
            }
            else{
                break;
            }
        }
    }
    public void exitInterest(){
        action.scrollToElement(driver, InterestBackButton, SkillsPage.class, INTERESTBACKBUTTON);
        action.click(InterestBackButton, SkillsPage.class, INTERESTBACKBUTTON);
    }

    public void clickContinueToLanguageButton(){
        action.scrollToElement(driver, ContinueToLanguageButton, SkillsPage.class, CONTINUETOLANGUAGEBUTTON);
        action.click(ContinueToLanguageButton, SkillsPage.class, CONTINUETOLANGUAGEBUTTON);
    }

    public void enterSkillsAndInterest() throws InterruptedException {
        clickAddSoftSkillButton();
        selectSoftSkills();
        WaitUtils.sleepTime(7);
        exitSoftSkills();
        WaitUtils.sleepTime(7);
        action.scrollDownVertically(driver, SkillsPage.class);
        clickAddTechnicalSkillButton();
        selectTechnicalSkills();
        WaitUtils.sleepTime(7);
        exitTechnicalSkills();
        WaitUtils.sleepTime(7);
        clickAddInterestButton();
        selectInterest();
        WaitUtils.sleepTime(7);
        exitInterest();
        WaitUtils.sleepTime(7);
    }

    public void reviewSkillsAndInterest() throws InterruptedException {
        enterSkillsAndInterest();
        action.scrollDownVertically(driver, SkillsPage.class);
        WaitUtils.sleepTime(7);
        clickContinueToLanguageButton();
        WaitUtils.sleepTime(7);
    }
}
