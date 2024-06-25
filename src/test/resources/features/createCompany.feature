# new feature
# Tags: optional

Feature: Company Management

  Scenario: Successfully created company
    Given User is logged in using admin account
    And User navigated to the create company page
    When User submit the company form with valid details
    Then User should see a success message Success Creating Company

  Scenario: Successfully updated company detail
    Given User is logged in using admin account
    Given User navigated to the update company page
    When User update the company with valid details
    Then User should be redirected to all company page