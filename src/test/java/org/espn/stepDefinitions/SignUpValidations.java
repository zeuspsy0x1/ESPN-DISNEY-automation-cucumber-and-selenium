package org.espn.stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.espn.utils.BaseForAllTests;


public class SignUpValidations extends BaseForAllTests {

    public Logger log = Logger.getLogger(SignUpValidations.class);

    @Given("ESPN webpage is opened in the browser window")
    public void browser_window_is_open() throws InterruptedException {
            testSetUp();
    }

    @When("user logs in")
    public void user_enters_a_text_in_search_box() throws InterruptedException {
            logIn();
    }

    @Then("user is navigated to search results")
    public void user_is_navigated_to_search_results() {
        System.out.println("TEEEEEEEEEEEAAAAAAAAAAAARRRRRRRRRRR DDDDDDDDOOOOOOOOOOWWWWWWWWWNNNNNNNNN");
        tearDown();
    }

}
