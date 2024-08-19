package tz.co.niajiri.qa.pageObjects.InsideCVUpload;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadPage {

    WebDriver driver;
    @FindBy(xpath = "//input[@id='resume']")
    private WebElement UploadCVButton;

    @FindBy(xpath = "//button[normalize-space()='Submit']")
    private WebElement SubmitCVButton;

    public UploadPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void uploadCVButton(){
        UploadCVButton.sendKeys(System.getProperty("user.dir")+"/src/main/java/testingDocsAndImages/Testing-CV.pdf");
    }

    public void clickSubmitButton(){
        SubmitCVButton.click();
    }
}
