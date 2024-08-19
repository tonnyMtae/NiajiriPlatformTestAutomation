package tz.co.niajiri.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tz.co.niajiri.qa.LogTemplates.LogTemplates;
import tz.co.niajiri.qa.actionDriver.Action;

public class SideMenuItems extends LogTemplates {

    WebDriver driver;
    Action action = new Action();

    @FindBy(xpath = "//ul[@id='side-menu']/child::li[*]//child::span[contains(.,'Jenga CV')]")
    private WebElement jengaCVMenuItem;

    public SideMenuItems(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickJengaCVMenuItem(){
        action.click(jengaCVMenuItem, SideMenuItems.class, JENGACVMENUITEM);
        jengaCVMenuItem.click();
    }
}
