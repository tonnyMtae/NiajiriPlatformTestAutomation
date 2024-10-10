package tz.co.niajiri.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tz.co.niajiri.qa.actionDriver.Action;
import tz.co.niajiri.qa.utilities.WaitUtils;
import tz.co.niajiri.qa.LogTemplates.LogTemplates;

public class PaymentServicePage extends LogTemplates{
    WebDriver driver;
    Action action = new Action();

    @FindBy(xpath = "//span[normalize-space()='Jenga CV']")
    private WebElement jengaCVMenuItem;

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

    public PaymentServicePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickDownloadButton(){
        action.click(DownloadButton, PaymentServicePage.class, DOWNLOADCVBUTTON);
    }

    public void clickDownloadThisTemplateButton(){
        action.click(DownloadThisTemplate, PaymentServicePage.class, DOWNLOADTHISTEMPLATE);
    }

    public void clickUpgradeNowButton(){
        action.click(UpgradeNowButton, PaymentServicePage.class, UPGRADENOWBUTTON);
    }

    public void clickPayNowButton(){
        action.click(PayNowButton, PaymentServicePage.class, PAYNOWBUTTON);
    }

    public void enterPhoneNumber(String number){
        action.sendKeys(PhoneNumberField, number,PaymentServicePage.class, PHONENUMBERFIELD);
    }

    public void clickProceedPaymentButton(){
        action.click(ProceedWithPaymentButton, PaymentServicePage.class, PROCEEDWITHPAYMENTBUTTON);
    }

    public void clickVerifyPaymentButton(){
        action.click(VerifyPaymentButton, PaymentServicePage.class, VERIFYPAYMENTBUTTON);
    }

    public void clickOkButton(){
        action.click(OKButton, PaymentServicePage.class, VERIFYPAYMENTBUTTON);
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
