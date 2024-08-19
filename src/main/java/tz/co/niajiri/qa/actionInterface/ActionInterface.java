package tz.co.niajiri.qa.actionInterface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ActionInterface {

    public abstract void openURLandMaximizeBrowser(WebDriver driver, String url ,String browserName, Class<?> clazz);
    public abstract void getCurrentUrl(Class<?> clazz, String log);
    public abstract void getPageTitle(Class<?> clazz, String log);
    public abstract void getPageSource(Class<?> clazz, String log);
    public abstract boolean navigateTo(WebDriver driver, String url, Class<?> clazz, String log);
    public abstract void refreshPage(Class<?> clazz, String log);
    public abstract void backToPage(Class<?> clazz, String log);
    public abstract void forwardToPage(Class<?> clazz, String log);
    public abstract void closeCurrentWindow(Class<?> clazz, String log);
    public abstract void closeAllOpenWindows(Class<?> clazz, String log);
    public abstract void maximizeBrowser(Class<?> clazz);
    public boolean navigateToURLandMaximizeBrowser(String url, String browserName, Class<?> clazz);

    // Text Box Commands
    public abstract void click(WebElement element, Class<?> clazz, String log);
    public abstract void clear(WebElement element, Class<?> clazz ,String log);
    public abstract void sendKeys(WebElement element, String text,  Class<?> clazz, String log);
    public abstract void sendKeysWithSpace(WebElement element, String text, Class<?> clazz, String log);
    public abstract void uploadCertificate(WebElement element, String directoryPath, Class<?> clazz, String log);
    public abstract void uploadProfilePicture(WebElement element, String directoryPath, Class<?> clazz, String log);
    public abstract void getAttributeValue(String attribute, Class<?> clazz, String log);
    public abstract void getText(WebElement element, Class<?> clazz, String log);
    public abstract void submit(WebElement element, Class<?> clazz, String log);


    // Radio Button/Check Box Commands
    public abstract void clickCheckBox(WebElement element, Class<?> clazz, String log);
    public abstract void clickRadioButton(WebElement element, Class<?> clazz, String log);
    public abstract boolean isSelected(WebElement element, Class<?> clazz, String log);
    public abstract boolean isDisplayed(WebElement element, Class<?> clazz, String log);
    public abstract boolean isEnabled(WebElement element, Class<?> clazz, String log);
    public abstract boolean selectOptionByIndex(WebElement element, int index, Class<?> clazz, String log);
    public abstract boolean selectOptionByValue(WebElement element,String value, Class<?> clazz, String log);
    public abstract boolean selectOptionByVisibleText(WebElement element, String visibletext, Class<?> clazz, String log);
    public abstract boolean deselectOptionByIndex(WebElement element, int index, Class<?> clazz, String log);
    public abstract boolean deselectOptionByValue(WebElement element,String value, Class<?> clazz, String log);
    public abstract boolean deselectOptionByVisibleText(WebElement element, String visibletext, Class<?> clazz, String log);
    public abstract boolean getOptionSize(WebElement element, Class<?> clazz, String log);
    public abstract boolean getSelectedOptionsSize(WebElement element, Class<?> clazz, String log);
    public abstract void getFirstSelectedOption(WebElement element, Class<?> clazz, String log);

    // Alert commands
    public  abstract void switchToAlert(Class<?> clazz, String log);
    public  abstract void acceptAlert(Class<?> clazz, String log);
    public  abstract void sendKeysToAlert(Class<?> clazz, String log);
    public  abstract void getTextFromAlert(Class<?> clazz, String log);
    public abstract void dismissAlert(Class<?> clazz, String log);

    // Action commands
    public abstract void actionClick(WebElement element, Class<?> clazz, String log);
    public abstract void rightClick(WebElement element, Class<?> clazz, String log);
    public abstract void actionSendKeys(WebElement element, Class<?> clazz, String log);
    public abstract void keysEnter(WebElement element, Class<?> clazz, String log);


    // JS Commands
    public abstract boolean scrollToElement(WebDriver driver, WebElement element, Class<?> clazz, String log);
    public abstract boolean scrollDownVertically(WebDriver driver, Class<?> clazz);
    public abstract boolean scrollUpByPixel(WebDriver driver, Class<?> clazz, int pixel);
    public boolean scrollDownByPixel(WebDriver driver, Class<?> clazz, int pixel);
    public abstract boolean zoomInByPercentage(Class<?> clazz, String log);
    public abstract boolean zoomOutByPercentage(Class<?> clazz, String log);
    public abstract boolean scrollDownBy300Pixel(WebDriver driver, Class<?> clazz);
    public abstract boolean scrollDownBy200Pixel(WebDriver driver, Class<?> clazz);
    public abstract boolean clickJS(WebElement element, Class<?> clazz, String log);
    public abstract boolean javaScriptHighLightElement(WebDriver driver, WebElement element);
    public abstract boolean javaScriptFlash(WebDriver driver, WebElement element);


























}
