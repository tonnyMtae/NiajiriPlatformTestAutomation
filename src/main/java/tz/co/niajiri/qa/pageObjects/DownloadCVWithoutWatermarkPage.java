package tz.co.niajiri.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tz.co.niajiri.qa.LogTemplates.LogTemplates;
import tz.co.niajiri.qa.actionDriver.Action;
import tz.co.niajiri.qa.utilities.WaitUtils;

public class DownloadCVWithoutWatermarkPage extends LogTemplates {

    WebDriver driver;
    Action action = new Action();

    @FindBy(xpath = "//a[@id='downloadMyCv']")
    private WebElement DownloadButton;

    @FindBy(xpath = "//span[@id='downloadThisTemplate']")
    private WebElement DownloadThisTemplate;

    @FindBy(xpath = "//button[@id='upgradeNowBttn']")
    private WebElement UpgradeNowButton;

    @FindBy(xpath = "//a[@id='watermarkFreeDownloadLink']")
    private WebElement PayNowButton;

    @FindBy(id = "sender")
    private WebElement PhoneNumberField;

    @FindBy(id = "submit-btn")
    private WebElement ProceedWithPaymentButton;

    @FindBy(xpath = "//button[normalize-space()='OK']")
    private WebElement OKButton;

    @FindBy(xpath = "//a[normalize-space()='Verify Payment']")
    private WebElement VerifyPaymentButton;

    public DownloadCVWithoutWatermarkPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickDownloadButton(){
        action.click(DownloadButton, DownloadCVWithoutWatermarkPage.class, DOWNLOADCVBUTTON);
    }

    public void clickDownloadThisTemplateButton(){
        action.click(DownloadThisTemplate, DownloadCVWithoutWatermarkPage.class, DOWNLOADTHISTEMPLATE);
    }

    public void clickUpgradeNowButton(){
        action.click(UpgradeNowButton, DownloadCVWithoutWatermarkPage.class, UPGRADENOWBUTTON);
    }

    public void clickPayNowButton(){
        action.click(PayNowButton, DownloadCVWithoutWatermarkPage.class, PAYNOWBUTTON);
    }

    public void enterPhoneNumber(String number){
        action.sendKeys(PhoneNumberField, number,DownloadCVWithoutWatermarkPage.class, PHONENUMBERFIELD);
    }

    public void clickProceedPaymentButton(){
        action.click(ProceedWithPaymentButton, DownloadCVWithoutWatermarkPage.class, PROCEEDWITHPAYMENTBUTTON);
    }

    public void clickVerifyPaymentButton(){
        action.click(VerifyPaymentButton, DownloadCVWithoutWatermarkPage.class, VERIFYPAYMENTBUTTON);
    }

    public void clickOkButton(){
        action.click(OKButton, DownloadCVWithoutWatermarkPage.class, VERIFYPAYMENTBUTTON);
    }

    public void downloadCVWithoutWatermark() throws InterruptedException {
        clickDownloadButton();
        WaitUtils.sleepTime(3);
        clickDownloadThisTemplateButton();
        WaitUtils.sleepTime(3);
        clickUpgradeNowButton();
        WaitUtils.sleepTime(3);
        clickPayNowButton();
        WaitUtils.sleepTime(3);
        enterPhoneNumber("0694009881");
        WaitUtils.sleepTime(3);
        clickProceedPaymentButton();
        WaitUtils.sleepTime(10);
        clickOkButton();
    }
}
