Feature: Select a PG with price less than 10000 and navigate to the details page

  Scenario: Select the first PG under 10,000 and navigate to its page
    Given User is on the 99acres search results page for Noida rental properties
    When User applies the price filter for PGs less than 10,000
    And User selects the first PG from the filtered results
    Then User should be redirected to the PG's details page
