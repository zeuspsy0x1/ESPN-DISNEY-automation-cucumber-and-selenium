package tests.stepDefinitions.disney;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.disney.screens.AddPlanScreen;
import org.disney.screens.DashBoardScreen;
import org.disney.screens.MapScreen;
import org.disney.screens.MenuScreen;
import org.disney.utils.BaseForMobileTests;
import org.testng.Assert;


/**
 * This class contains all the step definitions used for the three scenarios in the <disneyTests.feature>.
 * It extends from <BaseForMobileTest> to get access to the logger and the methods to use the driver.
 */
public class disneyAppStepDefinitions extends BaseForMobileTests  {

        DashBoardScreen dashBoard;
        MapScreen map;
        MenuScreen menu;
        AddPlanScreen addPlan;

        /**
         * Allows to navigate to the dashboard screen.
         */
        @Given("user is in the dashboard screen")
        public void iAmInTheDashboardView() {
                environmentSetUp();
                dashBoard = loadDashBoardScreen();
        }

        /**
         * Allows to navigate to the map screen.
         */
        @Given("user goes to the map screen")
        public void userGoesToMapScreen() {
                map = dashBoard.goToMapScreen();
        }

        /**
         * Checks that the map screen elements like buttons and containers are displayed.
         */
        @And("all the map screen elements show correctly")
        public void allTheMapScreenElementsShowCorrectly() {
                log.info("Validate Show List Button");
                Assert.assertTrue(map.isShowListDisplayed(), "Show List not displayed");

                log.info("Validate Category Button");
                Assert.assertTrue(map.isCategoryDisplayed(), "Category not displayed");

                log.info("Validate Filter Button");
                Assert.assertTrue(map.isFilterDisplayed(), "Filter not displayed");

                log.info("Validate that Map Container is displayed");
                Assert.assertTrue(map.isMapContainerDisplayed(), "Map Container is not displayed");

                log.info("Validate that Attractions category is displayed");
                Assert.assertTrue(map.isCategoryDisplayed(), "Attractions category is not displayed");
        }

        /**
         * Performs click on the list of attraction category found in the map screen.
         */
        @When("user clicks on the attractions category list")
        public void userClicksTheAttractionsCategoryList() {
                map.clickAttractionsCategoryList();
        }

        /**
         * Checks if the categories select category and hotels are displayed on the map screen.
         * Then closes the driver.
         */
        @Then("select category and hotels category are correctly displayed")
        public void user_is_navigated_to_search_results() {
                log.info("Validate that the select category is displayed");
                Assert.assertTrue(map.isSelectCategoryDisplayed(), " select categories header is not displayed");

                log.info("Validate that hotels category is displayed");
                Assert.assertTrue(map.isHotelsDisplayed(), "hotels category header is not displayed");

                log.info("***** Category List Test ended *****");

                mobileApplicationEnd();
        }

        /**
         * Allows to navigate to the menu screen.
         */
        @Given("user goes to the menu screen")
        public void userGoesToTheMenuScreen(){
                menu = dashBoard.clickOnMenuOption();

                log.info("Validate that the image from menu categories is displayed");
                Assert.assertTrue(menu.isCategoriesBannerDisplayed(), "menu categories is not being displayed");
        }

        /**
         * Performs scroll to bottom in the menu screen.
         */
        @When("scrolls to the bottom of the screen")
        public void scrollsToTheBottomOfTheScreen(){
                menu.scrollToTheBottomOfTheScreen();
        }

        /**
         * Checks if after the scroll the bottom menu categories are displayed correctly.
         */
        @And("the menu categories are displayed correctly")
        public void theMenuCategoriesAreDisplayedCorrectly(){
                log.info("Validate that Profile category is displayed");
                Assert.assertTrue(menu.isProfileCategoryDisplayed(), "Profile is not being displayed");
                log.info("Validate that Property Rules is displayed");
                Assert.assertTrue(menu.isPropertyRulesDisplayed(), "Property Rules is not being displayed");
                log.info("Validate that Cast Compliment is displayed");
                Assert.assertTrue(menu.isCastComplimentDisplayed(), "Cast Compliment is not being displayed");
                log.info("Validate that Link To Account is displayed");
                Assert.assertTrue(menu.isLinkToAccountDisplayed(), "Link To Account is not being displayed");
                log.info("Validate that Car Locator is displayed");
                Assert.assertTrue(menu.isCarLocatorDisplayed(), "Car Locator is not being displayed");
                log.info("Validate that Help is displayed");
                Assert.assertTrue(menu.isHelpDisplayed(), "Help is not being displayed");
                log.info("Validate that Privacy And Legal is displayed");
                Assert.assertTrue(menu.isPrivacyAndLegalDisplayed(), "Privacy And Legal is not being displayed");
        }

        /**
         * Performs click on the privacy and legal button.
         */
        @And("user clicks on privacy and legal button")
        public void userClicksOnPrivacyAndLegalButton(){
                menu.clickPrivacyAndLegalButton();
        }

        /**
         * Checks if the privacy and legal category options are displayed correctly.
         * Then closes the driver.
         */
        @Then("the privacy and legal category options are displayed correctly")
        public void thePrivacyAndLegalCategoryOptionsAreDisplayedCorrectly(){

                log.info("Validate that Privacy And Legal header text is displayed");
                Assert.assertTrue(menu.isPrivacyAndLegalHeaderDisplayed(), "Privacy And Legal header text is not being displayed");
                log.info("Validate that Privacy Policy is displayed");
                Assert.assertTrue(menu.isPrivacyPolicyDisplayed(), "Privacy Policy is not being displayed");
                log.info("Validate that Terms Of Use is displayed");
                Assert.assertTrue(menu.isTermsOfUseDisplayed(), "TermsOfUse is not being displayed");
                log.info("Validate that Supplemental Terms And Conditions is displayed");
                Assert.assertTrue(menu.isSupplementalTermsAndConditionsDisplayed(), "Supplemental Terms And Conditions is not being displayed");
                log.info("Validate that Legal Notices is displayed");
                Assert.assertTrue(menu.isLegalNoticesDisplayed(), "Legal Notices is not being displayed");
                log.info("Validate that Property Rules Option is displayed");
                Assert.assertTrue(menu.isPropertyRulesOptionDisplayed(), "Property Rules Option is not being displayed");
                log.info("Validate that Electronic Communication Disclosure is displayed");
                Assert.assertTrue(menu.isElectronicCommunicationDisclosureDisplayed(), "Electronic Communication Disclosure is not being displayed");
                log.info("Validate that Your California Privacy Rights is displayed");
                Assert.assertTrue(menu.isYourCaliforniaPrivacyRightsDisplayed(), "California Privacy Rights is not being displayed");
                log.info("Validate that Do Not Sell My Personal Information is displayed");
                Assert.assertTrue(menu.isDoNotSellMyPersonalInformationDisplayed(), "Do Not Sell My Personal Information is not being displayed");
                log.info("Validate that In App Maps Subject To Google Terms And Conditions is displayed");
                Assert.assertTrue(menu.isInAppMapsSubjectToGoogleTermsAndConditionsDisplayed(), "In App Maps Subject To Google Terms And Conditions is not being displayed");
                log.info("Validate that In App Maps Subject To Google Privacy Policy is displayed");
                Assert.assertTrue(menu.isInAppMapsSubjectToGooglePrivacyPolicyDisplayed(), "In App Maps Subject To Google Privacy Policy is not being displayed");

                log.info("***** Privacy And Legal Test ended *****");

                mobileApplicationEnd();
        }

        /**
         * Allows to navigate to the add plan screen.
         */
        @Given("user goes to the add plan screen")
        public void userGoesToTheAddPlanScreen(){
               addPlan = dashBoard.clickOnAddPlanOption();
        }

        /**
         * Performs click on add plan option.
         */
        @When("clicks on add plan")
        public void clicksOnAddPlan(){
                addPlan.clickAddPlan();
        }

        /**
         * Checks if plan options and dining availability are displayed correctly in the add plan screen.
         * Then closes the driver.
         */
        @Then("plan options and dining availability options are displayed correctly")
        public void planOptionsAndDiningAvailabilityOptionsAreDisplayedCorrectly(){
                log.info("Validate that List Of PlanOptions is displayed");
                Assert.assertTrue(addPlan.isListOfPlanOptionsDisplayed(), "List Of PlanOptions is not displayed");

                log.info("Validate that Check dining availability is displayed");
                Assert.assertTrue(addPlan.isDiningAvailabilityDisplayed(), "Check dining availability is not displayed");

                log.info("***** Add Plans Test ended *****");

                mobileApplicationEnd();
        }
}
