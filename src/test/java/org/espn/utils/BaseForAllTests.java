package org.espn.utils;

import org.apache.log4j.Logger;
import org.espn.configuration.Driver;
import org.espn.pages.HomePage;
import org.espn.pages.WatchPage;
import org.espn.stepDefinitions.SignUpValidations;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static java.lang.String.format;
import static org.hamcrest.CoreMatchers.is;

public class BaseForAllTests {

    private Driver driver;
    protected HomePage homePage;
    protected String email = "z1xxx@gmail.com";
    protected String password = "z1xxx@gmail.com.";
    protected String username = "z1xxx";
    protected String browser = "chrome";
    protected String url = "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud";

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

    public Logger log = Logger.getLogger(SignUpValidations.class);



    public void testSetUp() {
        driver = new Driver(browser);
        log.info("Deleting all cookies");
        driver.getDriver().manage().deleteAllCookies();
        log.info("Navigating to " + url);
        driver.getDriver().get(url);
        driver.getDriver().manage().window().maximize();
        homePage = new HomePage(driver.getDriver());
    }
    //@AfterMethod
    public void tearDown() {
        driver.getDriver().quit();
    }

    protected void loginFunctionalityAtOnce( String email, String password) throws InterruptedException {
        HomePage homePage = new HomePage(driver.getDriver()) ;
        homePage.hoverProfileIcon();
        homePage.clickOnLoginButton();
        homePage.enterLoginOrUpdateAccountIframe();
        homePage.typeEmailAndPasswordOnLoginInputs(email, password);
        homePage.clickSubmitButton();
        homePage.moveOutOfTheIframe();
    }
    protected void loginWithADeactivatedAccount( String email, String password) throws InterruptedException {
        HomePage homePage = new HomePage(driver.getDriver()) ;
        homePage.hoverProfileIcon();
        homePage.clickOnLoginButton();
        homePage.enterLoginOrUpdateAccountIframe();
        homePage.typeEmailAndPasswordOnLoginInputs(email, password);
        homePage.clickSubmitButton();
    }
    public void scrollToBottom(){
        JavascriptExecutor js = (JavascriptExecutor) driver.getDriver();
         js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        //js.executeScript("window.scrollBy(0,350)", "");
    }

    //Assertions
    protected <T> void checkThat(String description, T actualValue, Matcher<? super T> expectedValue) {
        log.info(format("Checking that " + description.toLowerCase() + "[Expectation: %s]", expectedValue));
        try {
            MatcherAssert.assertThat(actualValue, expectedValue);
        } catch (AssertionError e) {
            log.error(format("Assertion Error: [%s]", e.getMessage().replaceAll("\n", "")));
        }
    }


    protected void logIn() throws InterruptedException {
        homePage.hoverProfileIcon();
        homePage.clickOnLoginButton();
        homePage.enterLoginOrUpdateAccountIframe();
        checkThat("Login modal iFrame is present", homePage.isLoginIframePresent(), is(true));
        checkThat("Login ESPN logo is displayed", homePage.isEspnLogoDisplayedInLoginModal(), is(true));
        checkThat("Login button is displayed", homePage.isLoginButtonDisplayedInLoginModal(), is(true));
        checkThat("Signup button is displayed", homePage.isSignUpButtonDisplayedInLoginModal(), is(true));
        homePage.typeEmailAndPasswordOnLoginInputs(email, password);
        homePage.clickSubmitButton();
        homePage.moveOutOfTheIframe();
        homePage = new HomePage(driver.getDriver());
    }

    public void watchPageAndGreetingsValidations() throws InterruptedException {
        WatchPage watchPage = homePage.navigateFromHomePageToWatchPage();
        checkThat("At least 1 carousel is present", watchPage.isAtLeastOneCarouselDisplayed(), is(true));
        checkThat("All cards in carousel number 2 have title", watchPage.checkTitleInAllCardsInTheCarouselTwo(), is(false));
        checkThat("All cards in carousel number 2 have description", watchPage.checkDescriptionInAllCardsInTheCarouselTwo(), is(false));
        watchPage.clickOnCardNumberTwoInCarouselTwo();
        checkThat("X close button is displayed", watchPage.isSecondCardXButtonDisplayed(), is(true) );
        watchPage.clickXButtonToCloseModal();
        watchPage.navigateToPreviousPage();
        homePage.hoverProfileIcon();
        checkThat("Name is displayed in greetings", homePage.focusedGreetingsText(), is("Welcome" + this.username + "!"));
        homePage.hoverProfileIcon();
        homePage.clickLogoutButton();
        homePage.hoverProfileIcon();
        checkThat("Name is displayed in greetings", homePage.generalGreetingsText(), is("Welcome!"));
    }



}
