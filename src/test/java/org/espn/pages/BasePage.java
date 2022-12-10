package org.espn.pages;

import org.apache.log4j.Logger;
import org.espn.configuration.WebOperations;
import org.openqa.selenium.WebDriver;

/**
 * Allows to send the webOperations methods to its children.
 */
public class BasePage extends WebOperations {

    /**
     * Constructor method
     * @param driver
     */
    protected BasePage(WebDriver driver) {
        super(driver);
    }

    /**
     * A logger instance to be used by the children of BasePage
     */
    protected Logger log = Logger.getLogger(BasePage.class);

}
