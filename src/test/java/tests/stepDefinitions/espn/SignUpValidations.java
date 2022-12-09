package tests.stepDefinitions.espn;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.espn.utils.BaseForWebTests;


public class SignUpValidations extends BaseForWebTests {


    @Given("ESPN webpage is opened in the browser window")
    public void browser_window_is_open() {
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
