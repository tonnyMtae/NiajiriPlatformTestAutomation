package tz.co.niajiri.qa.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    public static FluentWait<WebDriver> wait;

    public static void waitForElementPresentAndClickAble(WebDriver driver, final By by, int timeOutInSeconds) {
        WebElement element;
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // reset
        } catch (Exception e) {
            // e.printStackTrace();
        }
    }



    public static void waitUntilElementIsVisible(WebDriver driver, WebElement webElement) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(webElement));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); // reset
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void waitUntilElementToBeClickable(WebDriver driver, WebElement webElement) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); // reset
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void waitUntilElementVisibleAndToBeClickable(WebDriver driver, WebElement webElement) {

        try {
            wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(30))
                    .pollingEvery(Duration.ofSeconds(5)).withMessage("Timeout occured!")
                    .ignoring(NoSuchElementException.class);

            wait.until(ExpectedConditions.visibilityOf(webElement));
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sleepTime(int time) {
        try {
            Thread.sleep(Duration.ofSeconds(time));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
