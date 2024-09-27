Feature: Navigate to Property for Rent in Delhi NCR from the Tenants menu

  Scenario: Select "Property for Rent in Delhi NCR" from the Tenants menu after login
    Given User is logged into 99acres
    When User hovers over the "Tenants" option in the header
    And User selects "Property for Rent in Delhi NCR"
    Then User should be navigated to the "Property for Rent in Delhi NCR" page
