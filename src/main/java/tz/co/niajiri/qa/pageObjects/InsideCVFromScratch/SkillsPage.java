package tz.co.niajiri.qa.pageObjects.InsideCVFromScratch;

import org.openqa.selenium.By;
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
    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[2]/div[2]/section[3]/form[1]/div[1]/div[1]/div[1]/div[1]/button[1]/p[1]")
    private WebElement AddSoftSkillButton;

    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[2]/div[2]/section[3]/form[1]/div[1]/div[2]/div[1]/div[1]/button[1]/p[1]")
    private WebElement AddTechnicalSkillButton;

    //(//div[@class='mx-6']//button[contains(@class,'pt-20')])[1]/*[1]
    //body/div[@id='wrapper']/div[@id='page-wrapper']/div[@id='content-wrapper']/div[2]/section[3]/form[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/button[1]/*[1]
    @FindBy(xpath = "(//div[@class='mx-6']//button[contains(@class,'pt-20')])[1]/*[1]")
    private WebElement SaveSoftSkillButton;

    //(//div[@class='mx-6']//button[contains(@class,'pt-20')])[2]/*[1]
    //body[1]/div[1]/div[2]/div[2]/div[2]/section[3]/form[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]/*[1]
    @FindBy(xpath = "(//div[@class='mx-6']//button[contains(@class,'pt-20')])[2]/*[1]")
    private WebElement SaveTechnicalSkillButton;

    @FindBy(xpath = "//button[normalize-space()='Submit']")
    private WebElement SaveSkills;

    public SkillsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddSoftSkillsButton(){
        action.click(AddSoftSkillButton, SkillsPage.class, ADDSOFTSKILLSBUTTON);
    }

    public void selectSoftSkills(){
        List<WebElement> softSkills = driver.findElements(By.xpath("//body/div/div/div/div/section[3]/form/div/div/div/div[3]/descendant::label/input"));
        for(int s = 0; s<softSkills.size();s++){
            if(s<=3){
                softSkills.get(s).click();
            }
            else{
                break;
            }
        }
    }

    public void saveSoftSkills(){
        action.click(SaveSoftSkillButton, SkillsPage.class, SAVEBUTTON);
    }

    public void clickAddTechnicalSkillsButton(){
        action.click(AddTechnicalSkillButton, SkillsPage.class, ADDTECHNICALSKILLBUTTON);
    }

    public void selectTechnicalSkills(){
        List<WebElement> technicalSkills = driver.findElements(By.xpath("//body[1]/div[1]/div[2]/div[2]/div[2]/section[3]/form[1]/div[1]/div[2]/div[1]/div[2]/descendant::label/input"));
        for(int s = 0; s<technicalSkills.size();s++){
            if(s<=3){
                technicalSkills.get(s).click();
            }
            else{
                break;
            }
        }
    }

    public void saveTechnicalSkills(){
        action.click(SaveTechnicalSkillButton, SkillsPage.class, SAVEBUTTON);
    }

    public void saveSkills(){
        action.click(SaveSkills, SkillsPage.class, SAVESKILLSBUTTON);
    }

    public void enterSkillDetails(){
        WaitUtils.sleepTime(5);
        clickAddSoftSkillsButton();
        WaitUtils.sleepTime(5);
        selectSoftSkills();
        WaitUtils.sleepTime(5);
        saveSoftSkills();
        action.scrollDownBy300Pixel(driver, SkillsPage.class);
        clickAddTechnicalSkillsButton();
        selectTechnicalSkills();
        saveTechnicalSkills();
        action.scrollDownBy300Pixel(driver, SkillsPage.class);
        saveSkills();
        WaitUtils.sleepTime(5);
    }

}
