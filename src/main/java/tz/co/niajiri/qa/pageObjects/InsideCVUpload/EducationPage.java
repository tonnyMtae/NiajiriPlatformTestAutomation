package tz.co.niajiri.qa.pageObjects.InsideCVUpload;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import tz.co.niajiri.qa.LogTemplates.LogTemplates;
import tz.co.niajiri.qa.actionDriver.Action;
import tz.co.niajiri.qa.utilities.WaitUtils;

import java.time.Duration;
import java.util.List;

public class EducationPage extends LogTemplates {
    WebDriver driver;
    Action action = new Action();

    // Education Details 1
    @FindBy(xpath = "//span[contains(@class,'hidden sm:inline')]")
    private WebElement AddAnotherEducationButton;

    @FindBy(xpath = "//button[normalize-space()='Continue']")
    private WebElement ContinueToSkillsInterestButton;

    @FindBy(xpath = "//button[@id='PreviousBtn']")
    private WebElement BackToExperience;

    @FindBy(xpath = "//button[@id='NextBtn']")
    private WebElement ContinueToEducationButton;

    @FindBy(id = "EducationLevel")
    private WebElement EducationLevelDropdown;

    @FindBy(id = "CourseName")
    private WebElement CourseNameDropdown;

    @FindBy(id = "Institution")
    private WebElement InstitutionDropdown;

    @FindBy(id = "RemarkSystem")
    private WebElement RemarkSystemDropdown;

    @FindBy(xpath = "//select[@id='RemarkDivision']")
    private WebElement RemarkDivisionDropdown;

    @FindBy(xpath = "//input[@id='Division Points']")
    private WebElement DivisionPointsField;

    @FindBy(xpath = "//input[@id='GPA']")
    private WebElement GPAPointsField;

    @FindBy(xpath = "//body/div/div/div/div/div/div/div/div/form[@x-data='{}']/div/div/div/input[2]")
    private WebElement StartDateCalenderField;

    @FindBy(xpath = "//input[contains(@type,'checkbox')]/following-sibling::div")
    private WebElement StillEnrolledCheckbox;

    @FindBy(xpath = "//div[contains(@x-show,'!$wire.current')]//input[contains(@type,'text')]")
    private WebElement EndDateCalenderField;


    public EducationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddAnotherEducationButton(){
        action.click(AddAnotherEducationButton, EducationPage.class, ADDANOTHEREDUCATIONBUTTON);
    }

    public void clickContinueToSkillsInterestButton(){
        action.click(ContinueToSkillsInterestButton, EducationPage.class, CONTINUETOSKILLSINTERESTBUTTON);
    }

    public void selectEducationLevel(String educationLevel){
        action.selectOptionByValue(EducationLevelDropdown, educationLevel, EducationPage.class, EDUCATIONDROPDOWN);
    }

    public void selectInstitutionName(String institutionName){
        action.selectOptionByValue(InstitutionDropdown, institutionName, EducationPage.class, INSTITUTIONDROPDOWN);
    }

    public void selectProgram(String program){
        action.selectOptionByVisibleText(CourseNameDropdown, program, EducationPage.class, COURSEDROPDOWN);
    }

    public void selectRemarkSystem(String remarkSystem){
        action.selectOptionByVisibleText(RemarkSystemDropdown, remarkSystem, EducationPage.class, REMARKSYSTEMDROPDOWN);
    }

    public void enterGPAPoints(String gpaPints){
        action.sendKeys(GPAPointsField, gpaPints, EducationPage.class, ACTUALSCOREDGPA);
    }

    public void enterStartDate(String startDate){
        action.sendKeys(StartDateCalenderField, startDate, EducationPage.class, STARTDATECALENDERFIELD);
        action.keysEnter(StartDateCalenderField, EducationPage.class, STARTDATECALENDERFIELD);
    }

    public void enterEndDate(String endDate){
        action.sendKeys(EndDateCalenderField, endDate, EducationPage.class, ENDDATECALENDERFIELD);
        action.keysEnter(EndDateCalenderField, EducationPage.class, ENDDATECALENDERFIELD);
    }

    public void selectRemarkDivision(String remarkDivision){
        action.selectOptionByValue(RemarkDivisionDropdown, remarkDivision, EducationPage.class, REMARKDIVISION);
    }

    public void enterDivisionPoints(String divisionPoints){
        action.sendKeys(DivisionPointsField, divisionPoints, EducationPage.class, DIVISIONPOINTS);
    }

    public void clickStillEnrolledCheckbox(){
        action.click(StillEnrolledCheckbox, EducationPage.class, STILLENROLLEDCHECKBOX);
    }

    public void clickContinueButton(){
        action.click(ContinueToEducationButton, EducationPage.class, CONTINUEBUTTON);
    }

    public void enterEducationDetails() throws InterruptedException {
        selectEducationLevel("Bachelor Degree");
        WaitUtils.sleepTime(5);
        selectInstitutionName("University of Dar es Salaam (UDSM)");
        WaitUtils.sleepTime(5);
        selectProgram("Law");
        WaitUtils.sleepTime(5);
        selectRemarkSystem("GPA");
//        action.scrollUpByPixel(driver, EducationPage.class, 600);
        WaitUtils.sleepTime(5);
        enterGPAPoints("4.3");
        WaitUtils.sleepTime(5);
        enterStartDate("January 2021");
        WaitUtils.sleepTime(5);
        enterEndDate("June 2023");
        WaitUtils.sleepTime(5);
        action.scrollDownVertically(driver, EducationPage.class);
        clickContinueButton();
    }


    public void reviewEducations() throws InterruptedException {
        WaitUtils.sleepTime(5);
        List<WebElement> educations = driver.findElements(By.xpath("//div[@class='w-full']/following-sibling::div[1]/div"));
        boolean isZeroElements = educations.isEmpty();
        if(isZeroElements){
            clickAddAnotherEducationButton();
            enterEducationDetails();
            clickContinueToSkillsInterestButton();
        }
        else {
            System.out.println(educations.size());
            for(int x=1; x<=educations.size(); x++){
                WebElement reviewButton = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div["+x+"]/div[2]/child::button[1]"));
                action.scrollToElement(driver, reviewButton, EducationPage.class, REVIEWBUTTON);
                action.click(reviewButton, EducationPage.class, REVIEWBUTTON);
                WaitUtils.sleepTime(10);
                enterEducationDetails();
                WaitUtils.sleepTime(10);
            }
            clickContinueToSkillsInterestButton();
            WaitUtils.sleepTime(10);
        }
    }
}
