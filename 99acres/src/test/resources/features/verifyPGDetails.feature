Feature: Verify PG details page on 99acres

  Scenario: Verify that image, tabs, links, and info are correct
    Given User is on the PG details page
    Then The image of the PG should be displayed
    And All the tabs should be clickable and functional
    And All the important information about the PG should be visible
