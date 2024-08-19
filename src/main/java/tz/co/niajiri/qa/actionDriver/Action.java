package tz.co.niajiri.qa.actionDriver;

import org.openqa.selenium.*;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import tz.co.niajiri.qa.actionInterface.ActionInterface;
import tz.co.niajiri.qa.utilities.LoggerHelper;
import tz.co.niajiri.qa.utilities.WaitUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

public class Action implements ActionInterface {
    WebDriver driver;
    @Override
    public void openURLandMaximizeBrowser(WebDriver driver, String url, String browserName, Class<?> clazz) {
        driver.manage().deleteAllCookies();
        driver.get(url);
        driver.manage().window().maximize();
        LoggerHelper.info(clazz, "Navigated to URL: " + url + " and Maximized " + browserName + " Browser.");
    }

    @Override
    public void getCurrentUrl(Class<?> clazz, String log) {

    }

    @Override
    public void getPageTitle(Class<?> clazz, String log) {

    }

    @Override
    public void getPageSource(Class<?> clazz, String log) {

    }

    @Override
    public boolean navigateTo(WebDriver driver, String url, Class<?> clazz, String log) {
        boolean flag = false;
        driver.navigate().to(url);
        LoggerHelper.info(clazz, "Navigate to URL: " + log);
        return flag;
    }

    @Override
    public void refreshPage(Class<?> clazz, String log) {

    }

    @Override
    public void backToPage(Class<?> clazz, String log) {

    }

    @Override
    public void forwardToPage(Class<?> clazz, String log) {

    }

    @Override
    public void closeCurrentWindow(Class<?> clazz, String log) {

    }

    @Override
    public void closeAllOpenWindows(Class<?> clazz, String log) {

    }

    @Override
    public void maximizeBrowser(Class<?> clazz) {
        driver.manage().window().maximize();
        LoggerHelper.info(clazz, "Maximized Browser");
    }

    @Override
    public boolean navigateToURLandMaximizeBrowser(String url, String browserName, Class<?> clazz) {
        boolean flag = false;
        driver.navigate().to(url);
        driver.manage().window().maximize();
        LoggerHelper.info(clazz, "Navigated to URL: " + url + " and Maximized " + browserName + " Browser.");
        return flag;
    }

    @Override
    public void click(WebElement element,  Class<?> clazz, String log) {
        WaitUtils.waitUntilElementVisibleAndToBeClickable(driver, element);
        WaitUtils.sleepTime(3);
        element.click();
        LoggerHelper.info(clazz, "Clicked:" + log);
    }

    @Override
    public void clear(WebElement element, Class<?> clazz,String log) {
        WaitUtils.waitUntilElementVisibleAndToBeClickable(driver, element);
        WaitUtils.sleepTime(3);
        element.click();
        element.clear();
        LoggerHelper.info(clazz, "Cleared text from: " + log);
    }

    @Override
    public void sendKeys(WebElement element, String text,  Class<?> clazz ,String log) {
        WaitUtils.waitUntilElementVisibleAndToBeClickable(driver, element);
        WaitUtils.sleepTime(3);
        element.click();
        element.clear();
        element.sendKeys(text);
        LoggerHelper.info( clazz, "Entered value:" + log);
    }

    @Override
    public void sendKeysWithSpace(WebElement element, String text, Class<?> clazz, String log) {
        WaitUtils.waitUntilElementVisibleAndToBeClickable(driver, element);
        WaitUtils.sleepTime(3);
        element.click();
        element.clear();
        element.sendKeys(Keys.SPACE);
        element.sendKeys(text);
        LoggerHelper.info(clazz, "Entered value:" + log);
    }

    @Override
    public void uploadCertificate(WebElement element, String directoryPath, Class<?> clazz, String log) {
        WaitUtils.waitUntilElementVisibleAndToBeClickable(driver, element);
        element.sendKeys(directoryPath);
        LoggerHelper.info(clazz,"Uploaded: ");
    }

    @Override
    public void uploadProfilePicture(WebElement element, String directoryPath, Class<?> clazz, String log) {
        WaitUtils.waitUntilElementVisibleAndToBeClickable(driver, element);
        element.sendKeys(directoryPath);
        LoggerHelper.info(clazz,"Uploaded: ");
    }

    @Override
    public void getAttributeValue(String attribute, Class<?> clazz, String log) {

    }

    @Override
    public void getText(WebElement element, Class<?> clazz, String log) {
        element.getText();
    }

    @Override
    public void submit(WebElement element, Class<?> clazz, String log) {

    }

    @Override
    public void clickCheckBox(WebElement element, Class<?> clazz, String log) {

    }

    @Override
    public void clickRadioButton(WebElement element, Class<?> clazz, String log) {

    }

    @Override
    public boolean isSelected(WebElement element, Class<?> clazz, String log) {
        return false;
    }

    @Override
    public boolean isDisplayed(WebElement element, Class<?> clazz, String log) {
        return false;
    }

    @Override
    public boolean isEnabled(WebElement element, Class<?> clazz, String log) {
        return false;
    }

    @Override
    public boolean selectOptionByIndex(WebElement element, int index, Class<?> clazz, String log) {
        return false;
    }

    @Override
    public boolean selectOptionByValue(WebElement element, String value, Class<?> clazz, String log) {
        boolean flag = false;
        WaitUtils.waitUntilElementVisibleAndToBeClickable(driver, element);
        Select select = new Select(element);
        select.selectByValue(value);
        LoggerHelper.info(clazz, "Selected Option by Value from:" + log);
        return flag;
    }

    @Override
    public boolean selectOptionByVisibleText(WebElement element, String visibleText, Class<?> clazz, String log) {
        boolean flag = false;
        WaitUtils.waitUntilElementVisibleAndToBeClickable(driver, element);
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
        LoggerHelper.info(clazz, "Selected Option by Visible Text from:" + log);
        return flag;
    }

    @Override
    public boolean deselectOptionByIndex(WebElement element, int index, Class<?> clazz, String log) {
        return false;
    }

    @Override
    public boolean deselectOptionByValue(WebElement element, String value, Class<?> clazz, String log) {
        return false;
    }

    @Override
    public boolean deselectOptionByVisibleText(WebElement element, String visibleText, Class<?> clazz, String log) {
        return false;
    }

    @Override
    public boolean getOptionSize(WebElement element, Class<?> clazz, String log) {
        boolean flag = false;
        WaitUtils.waitUntilElementVisibleAndToBeClickable(driver, element);
        Select select = new Select(element);
        int x = select.getOptions().size();
        String noOfItems = Integer.toString(x);
        LoggerHelper.info(clazz, "Number of Items from " + log + " is: "+ noOfItems);
        return flag;
    }

    @Override
    public boolean getSelectedOptionsSize(WebElement element,Class<?> clazz, String log) {
        boolean flag = false;
        WaitUtils.waitUntilElementVisibleAndToBeClickable(driver, element);
        Select select = new Select(element);
        int x = select.getAllSelectedOptions().size();
        String noOfItems = Integer.toString(x);
        LoggerHelper.info(clazz, "Number of Items from " + log + " is: "+ noOfItems);
        return flag;
    }

    @Override
    public void getFirstSelectedOption(WebElement element, Class<?> clazz, String log) {

    }

    @Override
    public void switchToAlert(Class<?> clazz, String log) {

    }

    @Override
    public void acceptAlert(Class<?> clazz, String log) {

    }

    @Override
    public void sendKeysToAlert(Class<?> clazz, String log) {

    }

    @Override
    public void getTextFromAlert(Class<?> clazz, String log) {

    }

    @Override
    public void dismissAlert(Class<?> clazz, String log) {

    }

    @Override
    public void actionClick(WebElement element, Class<?> clazz, String log) {

    }

    @Override
    public void rightClick(WebElement element, Class<?> clazz, String log) {

    }

    @Override
    public void actionSendKeys(WebElement element, Class<?> clazz, String log) {

    }

    @Override
    public void keysEnter(WebElement element, Class<?> clazz, String log) {
        element.sendKeys(Keys.ENTER);
        LoggerHelper.info(clazz, "Clicked Enter Key On: " + log);
    }

    @Override
    public boolean scrollToElement(WebDriver driver, WebElement element, Class<?> clazz, String log) {
        boolean flag = false;
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].scrollIntoView(true);", element);
//            Actions actions = new Actions(driver);
//            actions.moveToElement(element).build().perform();
            LoggerHelper.info(clazz, "Scrolled to:" + log);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean scrollDownVertically(WebDriver driver, Class<?> clazz) {
        boolean flag = false;
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
            LoggerHelper.info(clazz, "Scrolled to: BOTTOM");
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean scrollUpByPixel(WebDriver driver, Class<?> clazz, int pixel) {
        boolean flag = false;
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, "+pixel+")", "");
            LoggerHelper.info(clazz, "Scrolled by "+pixel+" PIXEL");
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean scrollDownByPixel(WebDriver driver, Class<?> clazz, int pixel) {
        boolean flag = false;
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, "+pixel+")", "");
            LoggerHelper.info(clazz, "Scrolled down by "+pixel+" PIXEL");
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean zoomInByPercentage(Class<?> clazz, String log) {
        return false;
    }

    @Override
    public boolean zoomOutByPercentage(Class<?> clazz, String log) {
        return false;
    }

    @Override
    public boolean scrollDownBy300Pixel(WebDriver driver, Class<?> clazz) {
        boolean flag = false;
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,300)", "");
            LoggerHelper.info(clazz, "Scrolled by 300 PIXEL");
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;

    }

    @Override
    public boolean scrollDownBy200Pixel(WebDriver driver, Class<?> clazz) {
        boolean flag = false;
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,200)", "");
            LoggerHelper.info(clazz, "Scrolled by 200 PIXEL");
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;

    }

    @Override
    public boolean clickJS(WebElement element, Class<?> clazz, String log) {
        return false;
    }

    @Override
    public boolean javaScriptHighLightElement(WebDriver driver, WebElement element) {
        boolean flag = false;
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].style.border='4px solid red'", element);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean javaScriptFlash(WebDriver driver, WebElement element) {
        return false;
    }
}
