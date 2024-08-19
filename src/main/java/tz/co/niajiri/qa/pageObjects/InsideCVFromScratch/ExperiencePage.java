package tz.co.niajiri.qa.pageObjects.InsideCVFromScratch;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Text;
import tz.co.niajiri.qa.LogTemplates.LogTemplates;
import tz.co.niajiri.qa.actionDriver.Action;

import java.time.Duration;
import java.util.List;

public class ExperiencePage extends LogTemplates {

        WebDriver driver;
        Action action = new Action();

        @FindBy(name ="experiences[0][position]")
        private WebElement PositionNameField;

        @FindBy(name ="experiences[0][organization]")
        private WebElement OrganizationNameField;

        @FindBy(name ="experiences[0][sector]")
        private WebElement SectorNameField;

        @FindBy(name ="experiences[0][location]")
        private WebElement LocationNameField;

        @FindBy(name ="experiences[0][experience_type]")
        private WebElement ExperienceTypeDropdown;

        //body/div[@id='wrapper']/div[@id='page-wrapper']/div[@id='content-wrapper']/div[2]/section[3]/form/div/div/div[7]/div/div/input[2]
        @FindBy(xpath = "//input[@id='started_at']/following-sibling::input")
        private WebElement StartDateCalenderField;

        @FindBy(xpath = "//div[contains(@class,'flatpickr-calendar animate flatpickr-monthSelect-theme-light open arrowBottom arrowLeft')]//input[contains(@aria-label,'Year')]")
        private WebElement StartYearField;

        @FindBy(xpath = "//input[@id='ended_at']/following-sibling::input")
        private WebElement EndDateCalenderField;

        @FindBy(xpath = "//div[contains(@class,'flatpickr-calendar animate flatpickr-monthSelect-theme-light open arrowBottom arrowLeft')]//div[contains(@class,'flatpickr-rContainer')]/descendant::span")
        private WebElement EndYearField;

        @FindBy(xpath = "//div[@class='inline-flex items-end mb-4 md:items-center -pt-4']//input[@name='experiences[0][ongoing]']")
        private WebElement CurrentWorkHereCheckbox;

        @FindBy(xpath = "//div[@id='mobile_wrapper_1']/div/div[9]/div/div/div[2]/descendant::button")
        private WebElement BulletPoints;

        @FindBy(xpath = "//div[contains(@class,'relative flex flex-col items-stretch w-full pt-1 mb-3')]//div[contains(@role,'textbox')]")
        private WebElement TextAreaField;

        @FindBy(id = "add_button_mobile")
        private WebElement AddExperience;

        @FindBy(xpath = "//span[normalize-space()='Save Work Experience']")
        private WebElement SaveWorkExperienceButton;

        public ExperiencePage(WebDriver driver){
                this.driver = driver;
                PageFactory.initElements(driver, this);
        }

        public void enterPositionName(String position){
                action.sendKeys(PositionNameField, position, ExperiencePage.class, POSITIONNAME);
        }

        public void enterOrganizationName(String organization){
                action.sendKeys(OrganizationNameField, organization, ExperiencePage.class, ORGANIZATIONNAME);
        }

        public void enterSectorName(String sector){
                action.sendKeys(SectorNameField, sector, ExperiencePage.class, SECTORNAME);
        }

        public void enterLocation(String location){
                action.sendKeys(LocationNameField, location, ExperiencePage.class, LOCATION);
        }

        public void selectExperienceType(String experience){
                action.scrollToElement(driver, ExperienceTypeDropdown, EducationPage.class, EXPERIENCETYPE);
                action.selectOptionByVisibleText(ExperienceTypeDropdown, experience, ExperiencePage.class, EXPERIENCETYPE);
        }

        public void enterStartDate(String startYear, String startMonth) throws InterruptedException {
                action.click(StartDateCalenderField, ExperiencePage.class, STARTDATECALENDERFIELD);
                action.sendKeys(StartYearField, startYear, ExperiencePage.class, YEAR);
                Thread.sleep(Duration.ofSeconds(10));
                List<WebElement> months = driver.findElements(By.xpath("//div[@class='flatpickr-calendar animate flatpickr-monthSelect-theme-light open arrowBottom arrowLeft']//div[@class='flatpickr-monthSelect-months']/child::span"));
                for(WebElement month:months){
                        if(month.getText().equalsIgnoreCase(startMonth)){
                                month.click();
                                break;
                        }
                }
        }

        public void clickCurrentWorkHereCheckbox(){
                //action.scrollToElement(driver, CurrentWorkHereCheckbox, EducationPage.class, REMARKSYSTEMDROPDOWN);
                action.click(CurrentWorkHereCheckbox, ExperiencePage.class, CURRENTWORKHERE);
        }

        public void enterExperienceSummary(String summary) throws InterruptedException {
                action.scrollToElement(driver, TextAreaField, ExperiencePage.class, TEXTAREAFIELD);
                action.sendKeysWithSpace(TextAreaField, summary, ExperiencePage.class, SUMMARY);
        }

        public void clickBulletPoint(){
                action.click(BulletPoints, ExperiencePage.class, BULLETPOINT);
        }

        public void clickSaveWorkExperienceButton(){
                action.scrollToElement(driver, SaveWorkExperienceButton, EducationPage.class, SAVEBUTTON);
                action.click(SaveWorkExperienceButton, ExperiencePage.class, SAVEBUTTON);
        }

        public void enterExperienceDetails() throws InterruptedException {
                action.scrollDownBy200Pixel(driver, ExperiencePage.class);
                enterPositionName("Cybersecurity Analyst");
                enterOrganizationName("Test Company");
                enterSectorName("Banking");
                enterLocation("Dar es salaam");
                action.scrollDownBy300Pixel(driver, ExperiencePage.class);
                selectExperienceType("Full Time");
                clickCurrentWorkHereCheckbox();
                enterStartDate("2019", "Jan");
                action.scrollDownBy300Pixel(driver, ExperiencePage.class);
                clickBulletPoint();
                enterExperienceSummary("A-Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt \n B-ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud \n C-exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. \n D-Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu\n E-fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa \n F-qui officia deserunt mollit anim id est laborum.");
                clickSaveWorkExperienceButton();
        }
}
