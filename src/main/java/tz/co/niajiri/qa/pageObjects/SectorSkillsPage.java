package tz.co.niajiri.qa.pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import tz.co.niajiri.qa.LogTemplates.LogTemplates;
import tz.co.niajiri.qa.actionDriver.Action;
import tz.co.niajiri.qa.utilities.LoggerHelper;

import java.time.Duration;
import java.util.List;

public class SectorSkillsPage extends LogTemplates {
    WebDriver driver;
    Action action = new Action();
    Actions actions;

    @FindBy(id = "full_name")
    private WebElement fullNameField;

    @FindBy(id = "profile_picture")
    private WebElement uploadProfilePictureButton;

    @FindBy(id = "gender")
    private WebElement genderDropDown;

    @FindBy(css = "input[placeholder='Select start date'][type='text']")
    private WebElement birthDateField;

    @FindBy(xpath = "//input[@aria-label='Year']")
    private WebElement yearTextField;

    @FindBy(xpath = "//select[@aria-label='Month']")
    private WebElement monthDropDown;

    @FindBy(xpath = "//select[@id='disability']")
    private WebElement disabilityDropdown;

    @FindBy(xpath = "//input[@placeholder='Choose Disability type']")
    private WebElement disabilityTypeDropdown;

    @FindBy(xpath = "//span[normalize-space()='Add Sector']")
    private WebElement addSectorButton;


    @FindBy(xpath = "//div[@class='mx-6']//button[contains(@class,'pt-8')]")
    private WebElement submitButton;

    @FindBy(xpath = "//button[normalize-space()='SAVE']")
    private WebElement saveButton;

    @FindBy(xpath = "//button[normalize-space()='CONTINUE']")
    private WebElement continueButton;

    @FindBy(xpath = "//button[normalize-space()='SKIP FOR NOW']")
    private WebElement skipForNowButton;

    public SectorSkillsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void uploadProfilePhoto(){
        action.uploadProfilePicture(uploadProfilePictureButton, System.getProperty("user.dir")+"/src/main/java/testingDocsAndImages/GettyImages.jpg", SectorSkillsPage.class, PROFILEPICTURE);
    }

    public void selectGender(){
        action.selectOptionByValue(genderDropDown, "Male", SectorSkillsPage.class, MALERADIOBUTTON);
    }

    public boolean getDisplayStatusOfGenderDropdownOption(){
        return genderDropDown.isDisplayed();
    }

    public void selectBirthDate(String year, String month, String date){
        action.click(birthDateField, SectorSkillsPage.class, BIRTHDATEFIELD);
        action.sendKeys(yearTextField, year, SectorSkillsPage.class, YEAR);
        action.selectOptionByVisibleText(monthDropDown, month, SectorSkillsPage.class, MONTH);

        List<WebElement> dates = driver.findElements(By.xpath("//div[@class='dayContainer']//child::span[@class='flatpickr-day ']"));
        for(WebElement d : dates){
            if(d.getText().equalsIgnoreCase(date)){
                d.click();
                LoggerHelper.info(SectorSkillsPage.class, "SELECTED: " + DATE);
                break;
            }
        }

    }

    public void selectDisabilityStatus(){
        action.selectOptionByValue(disabilityDropdown, "1", SectorSkillsPage.class, DISABILITYSTATUS);
    }

    public void selectDisabilityType() throws InterruptedException {
        action.click(disabilityTypeDropdown, SectorSkillsPage.class, DISABILITYTYPES);
        Thread.sleep(Duration.ofSeconds(4));
        action.sendKeys(disabilityTypeDropdown, "Blind", SectorSkillsPage.class, DISABILITYTYPES);
        Thread.sleep(Duration.ofSeconds(4));
        driver.findElement(By.xpath("//li[@role='treeitem']")).click();
        LoggerHelper.info(SectorSkillsPage.class, "SELECTED: " + DISABILITYTYPES);
    }


    public void selectInterestedSectors(){
        action.click(addSectorButton, SectorSkillsPage.class, ADDSECTORBUTTON);
        List<WebElement> sectors = driver.findElements(By.xpath("//input[contains(@name,'interest_sectors[]')]"));
        for(int s = 0; s<sectors.size();s++){
            if(s<=4){
                sectors.get(s).click();
            }
            else{
                break;
            }
        }
        LoggerHelper.info(SectorSkillsPage.class, "SELECTED: " + INTERESTEDSECTORS);
    }

    public void clickSubmitButton(){
        action.click(submitButton, SectorSkillsPage.class, SUBMITBUTTON);
    }

    public void clickSaveButton(){
        action.click(saveButton, SectorSkillsPage.class, SAVEBUTTON);
    }

    public void clickContinueButton(){
        action.click(continueButton, SectorSkillsPage.class, CONTINUEBUTTON);
    }
}
