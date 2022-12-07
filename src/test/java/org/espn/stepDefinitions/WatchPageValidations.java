package org.espn.stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.espn.pages.HomePage;
import org.espn.pages.WatchPage;
import org.espn.utils.BaseForAllTests;

import static org.hamcrest.CoreMatchers.is;


public class WatchPageValidations extends BaseForAllTests {


    @Given("user is logged in ESPN webpage")
    public void user_is_logged_in() throws InterruptedException {
        testSetUp();
        logIn();
    }

    @When("user clicks on the watch page and goes back to the homepage")
    public void user_clicks_on_watch_page() {
        WatchPage watchPage = homePage.navigateFromHomePageToWatchPage();
        checkThat("At least 1 carousel is present", watchPage.isAtLeastOneCarouselDisplayed(), is(true));
        checkThat("All cards in carousel number 2 have title", watchPage.checkTitleInAllCardsInTheCarouselTwo(), is(false));
        checkThat("All cards in carousel number 2 have description", watchPage.checkDescriptionInAllCardsInTheCarouselTwo(), is(false));
        watchPage.clickOnCardNumberTwoInCarouselTwo();
        checkThat("X close button is displayed", watchPage.isSecondCardXButtonDisplayed(), is(true) );
        watchPage.clickXButtonToCloseModal();
        watchPage.navigateToPreviousPage();
        }

    @Then("the user should still be logged in and be able to log out")
    public void at_least_one_carrousel_is_visible() throws InterruptedException {
        homePage.hoverProfileIcon();
        checkThat("Name is displayed in greetings", homePage.focusedGreetingsText(), is("Welcome" + this.username + "!"));
        homePage.hoverProfileIcon();
        homePage.clickLogoutButton();
        homePage.hoverProfileIcon();
        checkThat("Name is displayed in greetings", homePage.generalGreetingsText(), is("Welcome!"));
    }

}
