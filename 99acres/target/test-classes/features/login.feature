Feature: Login to 99acres website

  Scenario: Successful login to 99acres.com
    Given User is on the login page of 99acres
    When User enters valid credentials
    And User clicks on login button
    Then User should be successfully logged in
