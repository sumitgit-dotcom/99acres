Feature: Search PGs in Noida after login

  Scenario: Login to 99acres and search for PGs in Noida
    Given User is on the login page of 99acres
    When User logs in with valid credentials
    And User searches for PGs in Noida
    Then User should be navigated to the search results page for PGs in Noida
