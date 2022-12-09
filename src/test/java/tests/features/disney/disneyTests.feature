@disneyMobileAutomation
Feature: feature to test disneyland app functionalities

  Background:
    Given user is in the dashboard screen

  @disneyMobileAutomation @CategoryListTest
  Scenario: Validate map screen and category list flow
    Given user goes to the map screen
    And all the map screen elements show correctly
    When user clicks on the attractions category list
    Then select category and hotels category are correctly displayed

  @disneyMobileAutomation @Privacy&LegalTest
  Scenario: Validate menu screen and privacy options flow
    Given user goes to the menu screen
    When scrolls to the bottom of the screen
    And the menu categories are displayed correctly
    And user clicks on privacy and legal button
    Then the privacy and legal category options are displayed correctly

  @disneyMobileAutomation @AddPlansOptionTest
  Scenario: Validate add plan screen flow
    Given user goes to the add plan screen
    When clicks on add plan
    Then plan options and dining availability options are displayed correctly
