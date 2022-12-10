package org.espn.utils;

import org.apache.log4j.Logger;
import org.espn.configuration.Driver;
import org.espn.pages.HomePage;

/**
 * It has the instances for the general configuration of the driver and also the configuration
 * of the accounts already created and the new ones to be created with a random email.
 * And it also has the methods to start the new driver for each test scenario.
 * And a method to quit the driver.
 * Be careful when changing the username, as it is used to check the assertions in some steps.
 *
 */
public class BaseForWebTests {

    protected Driver driver;
    protected HomePage homePage;
    protected String username = "nameZeusTest";
    protected String password = "ZeusP4ss30rd.";

    protected String signUpEmail = "xzeusxvargasx@" + Math.random() + ".es";
    protected String email = "zeustesthybrid@zeustesthybrid.es";
    protected String lastname = "lastnameVargasTest";
    protected String browser = "chrome";
    protected String url = "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud";

    /**
     * Logger instance used by its children
     */
    protected Logger log = Logger.getLogger(BaseForWebTests.class);

    /**
     * Sets up the driver and navigates to the homepage
     */
    protected void testSetUp() {
        driver = new Driver(browser);
        log.info("Deleting all cookies");
        driver.getDriver().manage().deleteAllCookies();
        log.info("Navigating to " + url);
        driver.getDriver().get(url);
        driver.getDriver().manage().window().maximize();
        homePage = new HomePage(driver.getDriver());
    }

    /**
     * Quits the driver
     */
    protected void tearDown() {
        driver.getDriver().quit();
    }
}
