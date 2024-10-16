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

    //section[@id='pricing']/div/div[2]/div[2]/div[2]/div[2]/div[4]

    //section[@id='pricing']/div/div[2]/div[2]/descendant::a[1]

    @FindBy(xpath = "//span[normalize-space()='Subscription']")
    private WebElement SubscriptionMenuItem;

    @FindBy(xpath = "//section[@id='pricing']/div/div[2]/div[2]/descendant::a[1]")
    private WebElement ShangwePackageButton;

    @FindBy(id = "sender")
    private WebElement PhoneNumberField;

    @FindBy(id = "submit-btn")
    private WebElement ProceedWithPaymentButton;

    @FindBy(xpath = "//button[normalize-space()='OK']")
    private WebElement OKButton;

    @FindBy(xpath = "//a[normalize-space()='Retry Payment']")
    private WebElement RetryPayment;

    public PaymentServicePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSubscriptionMenuItem(){
        action.click(SubscriptionMenuItem, PaymentServicePage.class, SUBSCRIPTIONMENUITEM);
    }

    public void clickShangwePackageButton(){
        action.click(ShangwePackageButton, PaymentServicePage.class, SHANGWEPACKAGEBUTTON);
    }

    public void enterPhoneNumber(String number){
        action.sendKeys(PhoneNumberField, number,PaymentServicePage.class, PHONENUMBERFIELD);
    }

    public void clickProceedPaymentButton(){
        action.click(ProceedWithPaymentButton, PaymentServicePage.class, PROCEEDWITHPAYMENTBUTTON);
    }

    public void clickOkButton(){
        action.click(OKButton, PaymentServicePage.class, VERIFYPAYMENTBUTTON);
    }

    public void clickRetryPaymentButton(){
        action.click(RetryPayment, PaymentServicePage.class, VERIFYPAYMENTBUTTON);
    }

    public void paymentTest() throws InterruptedException {
        clickSubscriptionMenuItem();
        WaitUtils.sleepTime(3);
        action.scrollToElement(driver, ShangwePackageButton, PaymentServicePage.class, SHANGWEPACKAGEBUTTON);
        WaitUtils.sleepTime(3);
        clickShangwePackageButton();
        WaitUtils.sleepTime(3);
        enterPhoneNumber("0694009881");
        WaitUtils.sleepTime(3);
        clickProceedPaymentButton();
        WaitUtils.sleepTime(3);
        clickOkButton();
        WaitUtils.sleepTime(3);
        clickRetryPaymentButton();
    }
}
