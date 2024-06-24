# new feature
# Tags: optional

Feature: Create Company

  Scenario: Successfully created company
    Given User is logged in using admin account
    And User navigated to the create company page
    When User submit the company form with valid details
    Then User should see a success message Success Creating Company