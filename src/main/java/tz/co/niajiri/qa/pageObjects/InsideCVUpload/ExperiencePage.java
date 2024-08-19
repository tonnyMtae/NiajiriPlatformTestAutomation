package tz.co.niajiri.qa.pageObjects.InsideCVUpload;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Text;
import tz.co.niajiri.qa.LogTemplates.LogTemplates;
import tz.co.niajiri.qa.actionDriver.Action;
import tz.co.niajiri.qa.utilities.WaitUtils;

import java.time.Duration;
import java.util.List;

public class ExperiencePage extends LogTemplates {

        WebDriver driver;
        Action action = new Action();
        Faker faker;

        @FindBy(xpath = "//button[@id='AddAnotherBtn']")
        private WebElement AddAnotherExperienceButton;

        @FindBy(xpath = "//button[normalize-space()='Continue']")
        private WebElement ContinueToEducationButton;

        @FindBy(id ="Position")
        private WebElement PositionNameField;

        @FindBy(id ="Employer")
        private WebElement EmployerField;

        @FindBy(id ="Country")
        private WebElement CountryDropdown;

        @FindBy(id ="Region")
        private WebElement StateDropdown;

        @FindBy(xpath = "//input[contains(@name,'startDate')]/following-sibling::input")
        private WebElement StartDateCalenderField;

        @FindBy(xpath = "//input[contains(@name,'endDate')]/following-sibling::input")
        private WebElement EndDateCalenderField;

        @FindBy(xpath = "//input[@type='checkbox' and @id='Current']")
        private WebElement CurrentWorkHereCheckbox;

        @FindBy(xpath = "//div[@class='note-btn-group note-para']//button[@type='button']")
        private WebElement BulletPoints;

        @FindBy(xpath = "//button[@aria-label='Unordered list (⌘+⇧+NUM7)']")
        private WebElement UnOrderedListButton;

        @FindBy(xpath = "//div[@role='textbox']")
        private WebElement TextAreaField;

        @FindBy(xpath = "//button[@id='NextBtn']")
        private WebElement SaveWorkExperienceButton;

        public ExperiencePage(WebDriver driver){
                this.driver = driver;
                PageFactory.initElements(driver, this);
        }

        public void clickAddAnotherExperienceButton(){
                action.click(AddAnotherExperienceButton, ExperiencePage.class, ADDANOTHEREXPERIENCE);
        }

        public void clickContinueToEducationButton(){
                action.click(ContinueToEducationButton, ExperiencePage.class, CONTINUETOEDUCATIONBUTTON);
        }

        public void enterPositionName(String position){
                action.sendKeys(PositionNameField, position, ExperiencePage.class, POSITIONNAME);
        }

        public void enterEmployerName(String employer){
                action.sendKeys(EmployerField, employer, ExperiencePage.class, ORGANIZATIONNAME);
        }

        public void selectCountry(String country){
                action.scrollToElement(driver, CountryDropdown, ExperiencePage.class, COUNTRYDROPDOWNFIELD);
                action.selectOptionByValue(CountryDropdown, country, ExperiencePage.class, COUNTRYDROPDOWN);
        }

        public void selectRegion(String region){
                action.scrollToElement(driver, StateDropdown, ExperiencePage.class, STATEDROPDOWNFIELD);
                action.selectOptionByValue(StateDropdown, region, ExperiencePage.class, STATEDROPDOWN);
        }

        public void enterStartDate(String startDate) throws InterruptedException {
                action.sendKeys(StartDateCalenderField, startDate, ExperiencePage.class, STARTDATECALENDERFIELD);
                action.keysEnter(StartDateCalenderField, ExperiencePage.class, STARTDATECALENDERFIELD);
        }

        public void enterEndDate(String endDate) throws InterruptedException {
                action.sendKeys(EndDateCalenderField, endDate, ExperiencePage.class, ENDDATECALENDERFIELD);
                action.keysEnter(EndDateCalenderField, ExperiencePage.class, ENDDATECALENDERFIELD);
        }

        public void clickCurrentWorkHereCheckbox(){
                action.click(CurrentWorkHereCheckbox, ExperiencePage.class, CURRENTWORKHERE);
        }

        public void enterExperienceSummary(String summary) throws InterruptedException {
                action.scrollToElement(driver, TextAreaField, ExperiencePage.class, TEXTAREAFIELD);
                action.clear(TextAreaField, ExperiencePage.class, TEXTAREAFIELD);
                action.click(UnOrderedListButton, ExperiencePage.class, UNORDEREDLISTBUTTON);
                action.click(TextAreaField, ExperiencePage.class, TEXTAREAFIELD);
                action.sendKeys(TextAreaField, summary, ExperiencePage.class, SUMMARY);
        }

        public void clickBulletPoint(){
                action.click(BulletPoints, ExperiencePage.class, BULLETPOINT);
        }

        public void clickContinueButton(){
                action.click(SaveWorkExperienceButton, ExperiencePage.class, CONTINUEBUTTON);
        }

        public void enterExperienceDetails() throws InterruptedException {
                enterPositionName(faker.company().profession());
                enterEmployerName(faker.company().name());
                selectCountry("Tanzania");
                selectRegion("Arusha");
                enterStartDate("December"+ " "+ "2020");
                clickCurrentWorkHereCheckbox();
                enterExperienceSummary("A-Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt \n B-ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud \n C-exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. \n D-Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu \n E-fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa \n F-qui officia deserunt mollit anim id est laborum.");
                clickContinueButton();
        }

        public void reviewExperiences() throws InterruptedException {

                WaitUtils.sleepTime(10);
                List<WebElement> experiences = driver.findElements(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div"));
                boolean isZeroElements = experiences.isEmpty();
                if(isZeroElements){
                        action.scrollUpByPixel(driver, BasicDetailsPage.class, 600);
                        clickAddAnotherExperienceButton();
                        enterExperienceDetails();
                        clickContinueToEducationButton();
                }
                else {
                        int Date = 2018;
                        System.out.println(experiences.size());
                        for(int x=1; x<=experiences.size(); x++){
                                WebElement reviewButton = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div["+ x +"]/div[1]/div[1]/div/div[2]/button[1]"));
                                action.scrollToElement(driver, reviewButton, ExperiencePage.class, REVIEWBUTTON);
                                action.click(reviewButton, ExperiencePage.class, REVIEWBUTTON);
                                WaitUtils.sleepTime(10);
                                selectCountry("Tanzania");
                                WaitUtils.sleepTime(10);
                                selectRegion("Arusha");
                                enterEndDate("December"+ " "+ Date);
                                action.scrollDownVertically(driver, ExperiencePage.class);
                                WaitUtils.sleepTime(5);
                                enterExperienceSummary("A-Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt \n B-ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud \n C-exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. \n D-Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu \n E-fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa \n F-qui officia deserunt mollit anim id est laborum.");
                                clickContinueButton();
                                WaitUtils.sleepTime(10);
                                Date++;
                        }
                        action.scrollDownVertically(driver, ExperiencePage.class);
                        WaitUtils.sleepTime(10);
                        clickContinueToEducationButton();
                        WaitUtils.sleepTime(10);

                }
        }
}
