Feature: feature to test user functionalities in the espn webpage

  Scenario: Validate user sign up function
    Given ESPN webpage is opened in the browser window
    When user logs in
    Then user is navigated to search results

  Scenario: Validate that the logged user can go to watch page and it correctly shows the carrousels
    Given user is logged in ESPN webpage
    When user clicks on the watch page and goes back to the homepage
    Then the user should still be logged in and be able to log out



#  #Test 1 web
#Feature: feature to test user functionalities in the espn webpage
#
#  Scenario: Validate user login and log out functions
#    Given browser window is open
#    And user is on google search page
#    When user enters a text in search box
#    Then user is navigated to search results
#
