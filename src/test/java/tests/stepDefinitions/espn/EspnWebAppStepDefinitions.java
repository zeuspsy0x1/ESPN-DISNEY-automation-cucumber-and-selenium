package tests.stepDefinitions.espn;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.espn.pages.HomePage;
import org.espn.pages.WatchPage;
import org.espn.utils.BaseForWebTests;
import org.testng.Assert;



public class EspnWebAppStepDefinitions extends BaseForWebTests {

    WatchPage watchPage;

    /**
     * Opens the browser and goes to the ESPN homepage.
     */
    @Given("ESPN homepage is opened in the browser window")
    public void openEspnHomepageInBrowser() {
            testSetUp();
    }

    /**
     * Performs the steps to enter the login iFrame.
     */
    @Given("user tries to log in")
    public void logInUser() {
        homePage.hoverProfileIcon();
        homePage.clickOnLoginButton();
        homePage.enterLoginOrUpdateAccountIframe();
    }

    /**
     * Checks that the login modal display its elements.
     * Then closes the driver.
     */
    @Then("login modal should display its elements")
    public void checkElementsInLoginModal() {
        log.info("Validate that Login modal iFrame is present");
        Assert.assertTrue(homePage.isLoginIframePresent(), "Login modal iFrame is not present");
        log.info("Validate that Login ESPN logo is displayed");
        Assert.assertTrue( homePage.isEspnLogoDisplayedInLoginModal(), "Login ESPN logo is not displayed");
        log.info("Validate that Login button is displayed");
        Assert.assertTrue( homePage.isLoginButtonDisplayedInLoginModal(), "Login button is not displayed");
        log.info("Validate that Signup button is displayed");
        Assert.assertTrue( homePage.isSignUpButtonDisplayedInLoginModal(), "Signup button is not displayed");

        tearDown();
    }


    /**
     * Performs the functions to log in and to enter the login iFrame
     */
    @Given("user is in the log in modal")
    public void userIsInTheLogInModal() {
        homePage.hoverProfileIcon();
        homePage.clickOnLoginButton();
        homePage.enterLoginOrUpdateAccountIframe();
    }

    /**
     * Performs click to the signup button inside the login iFrame.
     */
    @And("clicks sign up button")
    public void userClicksSignUpButton() {
        homePage.clickOnSignUpButtonIframe();
    }

    /**
     * Checks that all the necessary elements in the sign up iFrame are being displayed.
     */
    @And("all the sign up elements are displayed")
    public void allTheSignUpElementsAreDisplayed(){
        log.info("Validating that the sign up modal elements are being correctly displayed");

        log.info("Validate that sign Up title is displayed");
        Assert.assertTrue(homePage.signUpTitleIsDisplayed(), "sign up title is not displayed");

        log.info("Validate that the first Name input is displayed");
        Assert.assertTrue(homePage.firstNameInputSignUpIframeIsDisplayed(), "first name input is not displayed");

        log.info("Validate that last name input is displayed");
        Assert.assertTrue(homePage.lastNameSignUpInputIsDisplayed(), "last name input is not displayed");

        log.info("Validate that email input is displayed");
        Assert.assertTrue(homePage.emailInputSignUpIframe(), "email input is not displayed");

        log.info("Validate that password input is displayed");
        Assert.assertTrue(homePage.passwordInputSignUpIframe(), "password input is not displayed");

        log.info("Validate that sign Up button is displayed");
        Assert.assertTrue(homePage.signUpButtonToSubmitIframeIsDisplayed(), "sign up button is not displayed");

        log.info("Validate that close button is displayed");
        Assert.assertTrue(homePage.closeSignUpIframeButton(), "close modal button is not displayed");
    }

    /**
     * Types the information to create a new account from the sign-up iFrame.
     * The email is generated "automatically", but the rest of the information is defined.
     */
    @When("user enters valid information in the sign up modal")
    public void userEntersValidInformationInTheSignUpModal() {
        homePage.typeOnFirstNameInput(username);
        homePage.typeOnLastNameInput(lastname);
        homePage.typeOnEmailInput(signUpEmail);
        homePage.typeOnPasswordInput(password);
    }

    /**
     *
     */
    @And("clicks the sign up button to send the form")
    public void userClicksTheSignUpButtonToSendTheForm() {
        homePage.clickOnSignUpForSignUpButtonIframe();
        homePage.moveOutOfTheIframe();
        homePage.waitForTheUserToBeLogged();
    }
    @Then("user should be logged automatically")
    public void userShouldBeLoggedAutomatically() {
        homePage.hoverProfileIcon();
        log.info("Validate that greetings with username are correctly displayed");
        Assert.assertEquals( homePage.focusedGreetingsText(),"Welcome" + this.username + "!");

        tearDown();
    }

    /**
     * Performs the user log in functions with the data from <BaseForWebTests>.
     */
    @Given("user is logged in ESPN webpage")
    public void userIsLoggedInEspnWebpage() {
        homePage.hoverProfileIcon();
        homePage.clickOnLoginButton();
        homePage.enterLoginOrUpdateAccountIframe();
        homePage.typeEmailAndPasswordOnLoginInputs(email, password);
        homePage.clickSubmitButton();
        homePage.moveOutOfTheIframe();
        homePage = new HomePage(driver.getDriver());
    }

    /**
     * Allows to navigate from homepage to watch page.
     */
    @When("user goes to the watch page")
    public void userGoesToTheWatchPage()  {
        watchPage = homePage.goToWatchPage();
    }

    /**
     * Checks that the necessary carousel elements are correctly displayed.
     */
    @Then("the watch page carousel elements should be displayed correctly")
    public void checkThatWatchPageElementsAreDisplayed()  {
        log.info("Validate that carousel is displayed");
        Assert.assertTrue(watchPage.isAtLeastOneCarouselDisplayed(), "Carousel is not displayed");

        log.info("Validate that all cards have title");
        Assert.assertFalse(watchPage.checkTitleInAllCardsInTheCarouselTwo(), "At least one card do not have title");

        log.info("Validate that all cards have description");
        Assert.assertFalse(watchPage.checkDescriptionInAllCardsInTheCarouselTwo(), "At lest one card do not have description");

        watchPage.clickOnCardNumberTwoInCarouselTwo();

        log.info("Validate that x button is displayed");
        Assert.assertTrue( watchPage.isSecondCardXButtonDisplayed(), "X button is not displayed");

        watchPage.clickXButtonToCloseModal();
    }

    /**
     * Checks that the logged user still is logged in after being in the watch page and going back to the homepage.
     * Then closes the driver.
     */
    @And("user should still be logged in after going back to the homepage")
    public void checkThatUserIsStillLoggedInAfterGoingBackToTheHomepage()  {
        watchPage.navigateToPreviousPage();
        homePage.hoverProfileIcon();

        log.info("Validate that greetings with username are correctly displayed");
        Assert.assertEquals( homePage.focusedGreetingsText(),"Welcome" + this.username + "!");

        tearDown();
    }


    /**
     * Performs all the steps to log into the ESPN page
     */
    @Given("user is logged in ESPN webpage with the intention to logout")
    public void userIsLoggedInEspnWithTheIntentionToLogout() {
        homePage.hoverProfileIcon();
        homePage.clickOnLoginButton();
        homePage.enterLoginOrUpdateAccountIframe();
        homePage.typeEmailAndPasswordOnLoginInputs(email, password);
        homePage.clickSubmitButton();
        homePage.moveOutOfTheIframe();
        homePage.hoverProfileIcon();

        log.info("Validate that greetings with username are correctly displayed");
        Assert.assertEquals( homePage.focusedGreetingsText(),"Welcome" + this.username + "!");

    }

    /**
     * Performs hover to the profile icon and click on the logout button
     */
    @When("user is logged in and clicks on logout")
    public void userClicksOnLogout()  {
        homePage.hoverProfileIcon();
        homePage.clickLogoutButton();
        homePage.hoverProfileIcon();
    }

    /**
     * Performs hover to the profile icon checks if the user is logged out
     */
    @Then("user should be logged out")
    public void userShouldBeLoggedOut()  {
        homePage.hoverProfileIcon();
        log.info("Validate that greetings are general after logging out");
        Assert.assertEquals(homePage.generalGreetingsText(), "Welcome!");

        tearDown();
    }
}
