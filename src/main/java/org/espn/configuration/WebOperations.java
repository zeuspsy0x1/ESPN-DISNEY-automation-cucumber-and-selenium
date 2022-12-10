package org.espn.configuration;

import static org.openqa.selenium.support.PageFactory.initElements;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * A class that contains methods to interact with the web pages.
 * It also has a driver and a wait instance from the driver library which is used later for the explicit waits.
 */
public class WebOperations {
    private final WebDriver driver;
    private final WebDriverWait wait;

    /**
     * Constructor class that receives a driver and creates a driver instance with it.
     */
    public WebOperations(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10L);
        initElements(driver, this);
    }
    /**
     * Returns the driver instance.
     */
    public WebDriver getDriver() {
        return driver;
    }
    /**
     * Performs hover to web elements when they are visible.
     */
    public void mouseHover(WebElement element) {
        this.waitForVisibility(element);
        new Actions(getDriver()).moveToElement(element).perform();
    }
    /**
     * Clicks web elements.
     */
    public void clickWebElement(WebElement element) {
        this.waitForVisibility(element);
        this.waitForClickable(element);
        element.click();
    }
    /**
     * Receives text and sends it to inputs passed as web elements.
     */
    public void typeOnInput(WebElement element, String text) {
        element.sendKeys(text);
    }

    /**
     * Waits until the web element that it receives is visible.
     */
    public void waitForVisibility(WebElement element) {
        this.wait.until(ExpectedConditions.visibilityOf(element));
    }
    /**
     * Waits until the list of web element that it receives are visible.
     */
    public void waitForVisibility(List<WebElement> elements) {
        this.wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
    /**
     * Waits until the web element that it receives is clickable.
     */
    public void waitForClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    /**
     * Navigates to the previous page.
     */
    public void navigateToPreviousPage() {
        this.driver.navigate().back();
    }
    /**
     * Waits until the element that it receives as a selector is present.
     */
    public void waitToSeeIfElementAppears(String selector) {
        this.wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector)));
    }
    /**
     * Waits for a change in the web element that it receives to an expected value.
     */
    public void waitForChangeInTheAttribute(WebElement element, String attribute, String value) {
        this.wait.until(ExpectedConditions.attributeToBe(element, attribute, value));
    }
}


