package tz.co.niajiri.qa.pageObjects.InsideCVFromScratch;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    @FindBy(xpath = "//select[@id='level_id']")
    private WebElement EducationLevelDropdown;

    @FindBy(css = "#qualification")
    private WebElement CourseNameDropdown;

    @FindBy(id = "institution")
    private WebElement InstitutionDropdown;

    @FindBy(id = "remark_system")
    private WebElement RemarkSystemDropdown;

    @FindBy(id = "remark")
    private WebElement ActualGPAField;

    @FindBy(id = "total_gpa")
    private WebElement OutOfTotalGPAField;

    @FindBy(xpath = "//input[@id='started_at']/following-sibling::input")
    private WebElement StartDateCalenderField;

    @FindBy(xpath = "//div[contains(@class,'flatpickr-calendar animate flatpickr-monthSelect-theme-light open arrowTop arrowLeft')]//input[contains(@aria-label,'Year')]")
    private WebElement StartYearField;

    @FindBy(xpath = "//input[@id='finished_at']/following-sibling::input")
    private WebElement EndDateCalenderField;

    @FindBy(xpath = "//div[contains(@class,'flatpickr-calendar animate flatpickr-monthSelect-theme-light open arrowTop arrowLeft')]//input[contains(@aria-label,'Year')]")
    private WebElement EndYearField;

    @FindBy(xpath = "//input[@id='attachment-file']")
    private WebElement UploadCertificateField;

    @FindBy(css = "#add_button_mobile")
    private WebElement AddEducationBackground;

    @FindBy(xpath = "//span[normalize-space()='Save Education Background']")
    private WebElement SaveEducationBackgroundButton;

    @FindBy(xpath = "//span[normalize-space()='Cancel']")
    private WebElement CancelButton;


    public EducationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectEducationLevel(String educationLevel){
        //action.scrollToElement(driver, EducationLevelDropdown, EducationPage.class, EDUCATIONDROPDOWN);
        action.selectOptionByVisibleText(EducationLevelDropdown, educationLevel, EducationPage.class, EDUCATIONDROPDOWN);
        action.getOptionSize(EducationLevelDropdown, EducationPage.class, EDUCATIONDROPDOWN);
    }


    public void selectCourse(String course){
        //action.scrollToElement(driver, CourseNameDropdown, EducationPage.class, COURSEDROPDOWN);
        action.selectOptionByValue(CourseNameDropdown, course, EducationPage.class, COURSEDROPDOWN);
        action.getOptionSize(CourseNameDropdown, EducationPage.class, COURSEDROPDOWN);
    }

    public void selectInstitution(String institution) {
        action.scrollToElement(driver, InstitutionDropdown, EducationPage.class, INSTITUTIONDROPDOWN);;
        action.selectOptionByVisibleText(InstitutionDropdown, institution, EducationPage.class, INSTITUTIONDROPDOWN);
        action.getOptionSize(InstitutionDropdown, EducationPage.class, INSTITUTIONDROPDOWN);
    }

    public void selectRemarkSystem(String remarkSystem){
        action.scrollToElement(driver, RemarkSystemDropdown, EducationPage.class, REMARKSYSTEMDROPDOWN);
        action.selectOptionByVisibleText(RemarkSystemDropdown, remarkSystem, EducationPage.class, REMARKSYSTEMDROPDOWN);
        action.getOptionSize(RemarkSystemDropdown, EducationPage.class, REMARKSYSTEMDROPDOWN);
    }

    public void enterScoredGPA(String actualScoredGPA) {
        action.sendKeys(ActualGPAField, actualScoredGPA, EducationPage.class, ACTUALSCOREDGPA);
    }

    public void enterOutOfTotalGPA(String outOfTotalGPA) {
        action.sendKeys(OutOfTotalGPAField, outOfTotalGPA, EducationPage.class, OUTOFTOTALGPA);
    }

    public void enterStartDate(String startYear, String startMonth) throws InterruptedException {
        action.scrollToElement(driver, StartDateCalenderField, EducationPage.class, STARTDATECALENDERFIELD);
        action.click(StartDateCalenderField, EducationPage.class, STARTDATECALENDERFIELD);
        action.sendKeys(StartYearField, startYear, EducationPage.class ,YEAR);
        Thread.sleep(Duration.ofSeconds(10));
        List<WebElement> months = driver.findElements(By.xpath("//div[contains(@class,'flatpickr-calendar animate flatpickr-monthSelect-theme-light open arrowTop arrowLeft')]//div[contains(@class,'flatpickr-monthSelect-months')]/child::span"));
        for(WebElement month: months){
            if(month.getText().equalsIgnoreCase(startMonth)){
                month.click();
                break;
            }
        }
    }

    public void enterEndDate(String endYear, String endMonth) throws InterruptedException {
        //action.scrollToElement(driver, EndDateCalenderField, EducationPage.class, ENDDATECALENDERFIELD);
        action.click(EndDateCalenderField, EducationPage.class, ENDDATECALENDERFIELD);
        action.sendKeys(EndYearField, endYear, EducationPage.class, YEAR);
        Thread.sleep(Duration.ofSeconds(10));
        List<WebElement> months = driver.findElements(By.xpath("//div[contains(@class,'flatpickr-calendar animate flatpickr-monthSelect-theme-light open arrowTop arrowLeft')]//div[contains(@class,'flatpickr-monthSelect-months')]/child::span"));
        for(WebElement month: months){
            if(month.getText().equalsIgnoreCase(endMonth)){
                month.click();
                break;
            }
        }
    }

    public void uploadCertificate(){
        action.scrollToElement(driver, UploadCertificateField, EducationPage.class, CERTIFICATION);
        action.uploadCertificate(UploadCertificateField, System.getProperty("user.dir")+"/src/main/java/testingDocsAndImages/Testing-Certificate-06-07-2024.pdf", EducationPage.class, CERTIFICATION);
    }

    public void saveEducationBackgroundButton(){
        action.scrollToElement(driver, SaveEducationBackgroundButton, EducationPage.class, SAVEBUTTON);
        action.click(SaveEducationBackgroundButton, EducationPage.class, SAVEBUTTON);
    }

    public void clickCancelButton(){;
        action.click(CancelButton, EducationPage.class, CANCELBUTTON);
    }

    public void enterEducationDetails() throws InterruptedException {
        selectEducationLevel("Bachelor Degree");
        WaitUtils.sleepTime(3);
        selectCourse("Law");
        WaitUtils.sleepTime(3);
        selectInstitution("Mzumbe University");
        WaitUtils.sleepTime(3);
        selectRemarkSystem("GPA");
        WaitUtils.sleepTime(3);
        enterScoredGPA("3.8");
        WaitUtils.sleepTime(3);
        enterOutOfTotalGPA("5");
        WaitUtils.sleepTime(3);
        enterStartDate("2010", "Jan");
        WaitUtils.sleepTime(3);
        enterEndDate("2023", "Dec");
        WaitUtils.sleepTime(3);
        uploadCertificate();
        WaitUtils.sleepTime(3);
        saveEducationBackgroundButton();
        WaitUtils.sleepTime(3);
    }
}
