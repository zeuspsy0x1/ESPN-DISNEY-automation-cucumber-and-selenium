package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

public class Testabilities {

    public Logger log = Logger.getLogger(Testabilities.class);


    @Given("browser window is open")
    public void browser_window_is_open() {
        System.out.println("GIIIIIVEEEEEEEN");
        log.error("aaadadadadadada");
    }

    @And("user is on google search page")
    public void user_is_on_google_search_page() {

        System.out.println("kkkkkkkkkk");

    }

    @When("user enters a text in search box")
    public void user_enters_a_text_in_search_box(){

        System.out.println("iiiiiiiiiiiiiiiiiiiiiiiiii");
    }


    @Then("user is navigated to search results")
    public void user_is_navigated_to_search_results() {

        System.out.println("THEEEEEEEEEEEN");
    }

}
