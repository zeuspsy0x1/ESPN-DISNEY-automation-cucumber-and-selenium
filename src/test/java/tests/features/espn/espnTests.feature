@WebAutomation
Feature: Test logged and logged out user functionalities in the ESPN webpage.


  Background:
    Given ESPN homepage is opened in the browser window

  @WebAutomation @ValidateLogInElements
  Scenario: Validate user log in elements
    Given user tries to log in
    Then login modal should display its elements

  @WebAutomation @ValidateSignUpElements
  Scenario: Validate user sign up elements
    Given user is in the log in modal
    And clicks sign up button
    And all the sign up elements are displayed
    When user enters valid information in the sign up modal
    And clicks the sign up button to send the form
    Then user should be logged automatically

  @WebAutomation @ValidateLoggedUserWatchPageFunctions
  Scenario: Validate that the logged user can go to watch page and it correctly shows a carrousel
    Given user is logged in ESPN webpage
    When user goes to the watch page
    Then the watch page carousel elements should be displayed correctly
    And user should still be logged in after going back to the homepage

  @WebAutomation @ValidateLoggedUserCanLogout
  Scenario: Validate that the logged user can logout
    Given user is logged in ESPN webpage with the intention to logout
    When user is logged in and clicks on logout
    Then user should be logged out

