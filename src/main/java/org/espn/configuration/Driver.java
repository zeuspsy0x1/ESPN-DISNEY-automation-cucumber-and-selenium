package org.espn.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


/**
 * Creates a new instance of a web driver
 */
public class Driver {
    private WebDriver driver;

    /**
     * Constructor class that receives a browser name. It has a switch case to add different browsers in the future.
     */
    public Driver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                this.driver = new ChromeDriver();
                break;

        }
    }
    /**
     * @return the web driver instance
     */
    public WebDriver getDriver() {
        return driver;
    }
}
