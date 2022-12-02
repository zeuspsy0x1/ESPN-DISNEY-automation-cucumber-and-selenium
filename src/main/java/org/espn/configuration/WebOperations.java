package org.espn.configuration;

import static org.openqa.selenium.support.PageFactory.initElements;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebOperations {
    private WebDriver driver;
    private final WebDriverWait wait;

    public WebOperations(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(6L));
        initElements(driver, this);
    }
    public WebDriver getDriver() {
        return driver;
    }

    public void mouseHover(WebElement element) {
        this.waitForVisibility(element);
        new Actions(getDriver()).moveToElement(element).perform();
    }
    public void clickWebElement(WebElement element) {
        this.waitForVisibility(element);
        this.waitForClickable(element);
        element.click();
    }
    public void typeOnInput(WebElement element, String text) {
        element.sendKeys(text);
    }
    public void waitForVisibility(WebElement element) {
        this.wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForVisibility(List<WebElement> elements) {
        this.wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
    public void waitForClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void navigateToPreviousPage() {
        this.driver.navigate().back();
    }

    public void waitToSeeIfElementAppears(String selector) {
        this.wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector)));
    }
//    public void reloadThisPage() {
//        this.driver.navigate().refresh();
//    }


}


