package tz.co.niajiri.qa.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tz.co.niajiri.qa.actionDriver.Action;

public class LoginPage {
    WebDriver driver;
    Action action = new Action();


    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailLoginInputField;
    @FindBy(xpath = "//input[@id='login-password']")
    private WebElement passwordLoginInputField;
    @FindBy(xpath = "//button[normalize-space()='Sign In']")
    private WebElement signInButton;



    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterValidEmailText(String loginEmail){
        action.sendKeys(emailLoginInputField, loginEmail, LoginPage.class ,"Valid Email");
    }
    public void enterValidPasswordText(String loginPassword){
        action.sendKeys(passwordLoginInputField, loginPassword, LoginPage.class,"Valid Password");
    }

    public SectorSkillsPage clickSignInButton(){
//        actions.moveToElement(emailLoginInputField).click().sendKeys("").build().perform();
        action.click(signInButton, LoginPage.class ,"Sign In Button");
        return new SectorSkillsPage(driver);
    }

    public void signInIntoNiajiri(String email, String password){
        enterValidEmailText(email );
        enterValidPasswordText(password);
        clickSignInButton();
    }

}
