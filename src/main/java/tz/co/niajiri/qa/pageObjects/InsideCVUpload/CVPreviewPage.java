package tz.co.niajiri.qa.pageObjects.InsideCVUpload;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import tz.co.niajiri.qa.LogTemplates.LogTemplates;
import tz.co.niajiri.qa.actionDriver.Action;
import tz.co.niajiri.qa.utilities.LoggerHelper;
import tz.co.niajiri.qa.utilities.WaitUtils;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class CVPreviewPage extends LogTemplates {
    WebDriver driver;
    Action action = new Action();

    @FindBy(xpath = "//button[normalize-space()='save']")
    private WebElement SaveCVButton;

    @FindBy(xpath = "//div[@id='desktopColorSelector']//div[3]")
    private WebElement CvColourSelector3;

    @FindBy(id = "chooseTemplateBtn")
    private WebElement ChooseTemplateButton;

    public CVPreviewPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectCVColour(){
        action.click(CvColourSelector3, CVPreviewPage.class, CVCOLOURSELECTOR3);
        //CvColourSelector3.click();
    }

    public void selectCVTemplate(){
        action.click(ChooseTemplateButton, CVPreviewPage.class, CHOOSETEMPLATEBUTTON);
        List<WebElement> templates = driver.findElements(By.xpath("//div[@id='templateOptions']/descendant::button"));
        Random random = new Random();
        int randomIndex = random.nextInt(templates.size());
        WebElement randomItem = templates.get(randomIndex);
        action.click(randomItem, CVPreviewPage.class, "SELECTED TEMPLATE BY INDEX:" + randomIndex);
        //randomItem.click();
    }

    public void clickSaveCVButton(){
        action.click(SaveCVButton, CVPreviewPage.class, SAVEBUTTON);
    }

    public void selectTemplateAndContinue() throws InterruptedException {
        action.scrollDownVertically(driver, CVPreviewPage.class);
        WaitUtils.sleepTime(5);
        selectCVColour();
        WaitUtils.sleepTime(5);
        selectCVTemplate();
        WaitUtils.sleepTime(5);
        clickSaveCVButton();
        WaitUtils.sleepTime(7);
    }
}
