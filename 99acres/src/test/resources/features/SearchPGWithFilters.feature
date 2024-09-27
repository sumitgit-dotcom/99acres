Feature: Search PG with Filters on 99acres

  Scenario: Apply filters for PG in Noida with budget up to 10,000 for boys sharing +2 rooms in Sector 62
    Given User is on the 99acres PG search results page
    When User applies a budget filter of up to 10,000
    And User applies a filter for "Boys" sharing +2 room
    And User applies the location filter for "Sector 62"
    Then User should see PG listings filtered accordingly
