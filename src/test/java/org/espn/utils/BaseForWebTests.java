package org.espn.utils;

import org.apache.log4j.Logger;
import org.espn.configuration.Driver;
import org.espn.pages.HomePage;
public class BaseForWebTests {

    protected Driver driver;
    protected HomePage homePage;
    protected String signUpEmail = "xzeusxvargasx@" + Math.random() + ".es";
    protected String email = "zeustest@zeustest.com";
    protected String password = "ZeusP4ss30rd.";
    protected String username = "nameZeusTest";
    protected String lastname = "lastnameVargasTest";
    protected String browser = "chrome";
    protected String url = "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud";

    protected Logger log = Logger.getLogger(BaseForWebTests.class);


    protected void testSetUp() {
        driver = new Driver(browser);
        log.info("Deleting all cookies");
        driver.getDriver().manage().deleteAllCookies();
        log.info("Navigating to " + url);
        driver.getDriver().get(url);
        driver.getDriver().manage().window().maximize();
        homePage = new HomePage(driver.getDriver());
    }

    protected void tearDown() {
        driver.getDriver().quit();
    }
}
