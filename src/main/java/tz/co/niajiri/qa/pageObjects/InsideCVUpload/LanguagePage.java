package tz.co.niajiri.qa.pageObjects.InsideCVUpload;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tz.co.niajiri.qa.LogTemplates.LogTemplates;
import tz.co.niajiri.qa.actionDriver.Action;

import java.time.Duration;
import java.util.List;

public class LanguagePage extends LogTemplates {
    WebDriver driver;
    Action action = new Action();

    @FindBy(id = "AddAnotherBtn")
    private WebElement AddAnotherButton;

    @FindBy(id = "PreviousBtn")
    private WebElement PreviousButton;

    @FindBy(id = "LanguageSearch")
    private WebElement LanguageSearchTextField;

    @FindBy(id = "deleteLanguageBtn")
    private WebElement DeleteLanguageButton;

    @FindBy(id = "NextBtn")
    private WebElement NextButton;

    @FindBy(id = "LanguageSideoverSave")
    private WebElement SaveLanguageButton;

    public LanguagePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddLanguageButton(){
        action.click(AddAnotherButton, LanguagePage.class, ADDLANGUAGEBUTTON);
    }

    public void clickSaveLanguageButton(){
        action.click(SaveLanguageButton, LanguagePage.class, SAVEBUTTON);
    }

    public void selectLanguages(){
        List<WebElement> languageOptions = driver.findElements(By.xpath("//div[@id='LanguageOptionContainer']/ul/li/span/input"));
        // Click on the first two language options
        for (int i = 0; i < languageOptions.size() && i < 2; i++) {
            action.click(languageOptions.get(i), LanguagePage.class, LANGUAGES+i);
//            languageOptions.get(i).click();
        }
        clickSaveLanguageButton();
    }

    public void selectLanguageProficiencyLevels() throws InterruptedException {
        List<WebElement> proficiencyLevels = driver.findElements(By.xpath("//div[@class='flex flex-col gap-y-6']//div[1]/div[1]/div[3]/div/div/div/div"));
        for(int p = 1; p<=proficiencyLevels.size(); p++){
            WebElement proficiencyLevel = driver.findElement(By.xpath("(//div[@class='flex flex-col gap-y-6'])["+p+"]//div[1]/div[1]/div[3]/div/div/div/div"));
            action.click(proficiencyLevel, LanguagePage.class, PROFICIENCYLEVEL);
            Thread.sleep(Duration.ofSeconds(20));
        }
    }

    public void clickContinueToRefereesButton(){
        action.click(NextButton, LanguagePage.class, CONTINUETOREFEREEBUTTON);
        NextButton.click();
    }


    public void reviewLanguage() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        clickAddLanguageButton();
        Thread.sleep(Duration.ofSeconds(10));
        selectLanguages();
        Thread.sleep(Duration.ofSeconds(10));
        selectLanguageProficiencyLevels();
        Thread.sleep(Duration.ofSeconds(10));
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(Duration.ofSeconds(10));
        clickContinueToRefereesButton();
        Thread.sleep(Duration.ofSeconds(10));
    }
}
