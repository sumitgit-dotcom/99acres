Feature: Filter Property Search on 99acres

  Scenario: Apply filters for rental properties in Delhi NCR
    Given User is on the 99acres property rental search page for Delhi NCR
    When User applies the filter for properties under Rs 20,000
    And User applies the filter for 2BHK
    And User applies the filter for "Residential Apartment"
    And User applies the filter for "Available for Family"
    And User applies the filter for "Posted by Owner and Builder"
    And User applies the filter for "Semifurnished"
    And User applies the filter for "All Localities"
    Then User should see the filtered property listings
