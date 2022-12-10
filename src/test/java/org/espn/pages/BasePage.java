package org.espn.pages;

import org.apache.log4j.Logger;
import org.espn.configuration.WebOperations;
import org.openqa.selenium.WebDriver;

/**
 * Allows to send the webOperations methods to its children.
 */
public class BasePage extends WebOperations {

    protected BasePage(WebDriver driver) {
        super(driver);
    }

    protected Logger log = Logger.getLogger(BasePage.class);

}
