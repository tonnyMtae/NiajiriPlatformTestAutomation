package tz.co.niajiri.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import tz.co.niajiri.qa.LogTemplates.LogTemplates;
import tz.co.niajiri.qa.actionDriver.Action;
import tz.co.niajiri.qa.utilities.WaitUtils;

import java.time.Duration;

public class DownloadCVWithWatermarkPage extends LogTemplates {

    WebDriver driver;
    Action action = new Action();

    @FindBy(xpath = "//a[@id='downloadMyCv']")
    private WebElement DownloadButton;

    @FindBy(xpath = "//span[@id='downloadThisTemplate']")
    private WebElement DownloadThisTemplate;

    @FindBy(xpath = "//a[@id='continueWithWatermarkLink']")
    private WebElement ContinueWithWatermarkButton;

    public DownloadCVWithWatermarkPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickDownloadButton(){
        action.click(DownloadButton, DownloadCVWithWatermarkPage.class, DOWNLOADCVBUTTON);
    }

    public void clickDownloadThisTemplateButton(){
        action.click(DownloadThisTemplate, DownloadCVWithoutWatermarkPage.class, DOWNLOADTHISTEMPLATE);
    }

    public void clickContinueWithWatermarkButton(){
        action.click(ContinueWithWatermarkButton, DownloadCVWithWatermarkPage.class, CONTINUEWITHWATERMARKBUTTON);
    }
    public void downloadCVWithWatermark() throws InterruptedException {
        clickDownloadButton();
        WaitUtils.sleepTime(3);
        clickDownloadThisTemplateButton();
        WaitUtils.sleepTime(3);
        clickContinueWithWatermarkButton();
        WaitUtils.sleepTime(3);
    }

    public void downloadUploadedCVWithWatermark() throws InterruptedException {
        clickDownloadThisTemplateButton();
        WaitUtils.sleepTime(3);
        clickContinueWithWatermarkButton();
        WaitUtils.sleepTime(3);
    }

}
