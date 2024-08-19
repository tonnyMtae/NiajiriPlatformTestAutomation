package tz.co.niajiri.qa.pageObjects.InsideCVFromScratch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import tz.co.niajiri.qa.LogTemplates.LogTemplates;
import tz.co.niajiri.qa.actionDriver.Action;

import java.time.Duration;

public class LanguagePage extends LogTemplates {
    WebDriver driver;
    Action action = new Action();

    @FindBy(xpath = "//div[@id='mobile_wrapper_1']/div/div/select[@name='languages[0][name]']")
    private WebElement LanguageNameDropdown;

    @FindBy(xpath = "//div[@id='mobile_wrapper_1']/div[2]/div[1]/div/child::select[@id='written_fluency']")
    private WebElement WrittenDropDown;

    @FindBy(xpath = "//div[@id='mobile_wrapper_1']/div[2]/div[2]/div/child::select[@id='speak_fluency']")
    private WebElement OralDropDown;

    @FindBy(xpath = "//a[@class='add_button']")
    private WebElement AddLanguageButton;

    @FindBy(xpath = "//div[@id='mobile_wrapper_2']/div/div[2]/div/div/select[@name='languages[1][name]']")
    private WebElement LanguageNameDropdown1;

    @FindBy(xpath = "//div[@id='mobile_wrapper_2']/div/div[3]/descendant::div/child::select[@name='languages[1][write_fluency]']")
    private WebElement WrittenDropDown1;

    @FindBy(xpath = "//div[@id='mobile_wrapper_2']/div/div[3]/div[2]/div/descendant::div/child::select[@name='languages[1][speak_fluency]']")
    private WebElement OralDropDown1;

    @FindBy(xpath = "//span[normalize-space()='Save Languages']")
    private WebElement SaveLanguageButton;

    public LanguagePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectLanguage(String language){
        action.selectOptionByValue(LanguageNameDropdown, language, LanguagePage.class, LANGUAGEDROPDOWN);
    }

    public void selectWrittenFluencyLevel(String writtenFluencyLevel){
        action.selectOptionByValue(WrittenDropDown, writtenFluencyLevel, LanguagePage.class, WRITTENFLUENCYDROPDOWN);
    }

    public void selectOralFluencyLevel(String oralFluencyLevel){
        action.selectOptionByValue(OralDropDown, oralFluencyLevel, LanguagePage.class ,ORALFLUENCYDROPDOWN);
    }

    public void clickAddLanguageButton(){
        action.click(AddLanguageButton, LanguagePage.class, ADDLANGUAGEBUTTON);
    }

    public void selectLanguage1(String language){
        action.selectOptionByValue(LanguageNameDropdown1, language, LanguagePage.class, LANGUAGEDROPDOWN);
    }

    public void selectWrittenFluencyLevel1(String writtenFluencyLevel){
        action.selectOptionByValue(WrittenDropDown1, writtenFluencyLevel, LanguagePage.class, WRITTENFLUENCYDROPDOWN);
    }

    public void selectOralFluencyLevel1(String oralFluencyLevel){
        action.selectOptionByValue(OralDropDown1, oralFluencyLevel, LanguagePage.class, ORALFLUENCYDROPDOWN);
    }

    public void clickSaveLanguageButton(){
        action.click(SaveLanguageButton, LanguagePage.class, SAVEBUTTON);
    }

    public void enterLanguageDetails(){
        action.scrollDownBy300Pixel(driver, LanguagePage.class);
        selectLanguage("English");
        selectWrittenFluencyLevel("Excellent");
        selectOralFluencyLevel("Very Good");
        clickAddLanguageButton();
        action.scrollDownBy300Pixel(driver, LanguagePage.class);
        selectLanguage1("Swahili");
        selectWrittenFluencyLevel1("Fair");
        selectOralFluencyLevel1("Very Good");
        clickSaveLanguageButton();
    }
}
