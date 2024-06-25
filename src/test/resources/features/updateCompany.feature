# new feature
# Tags: optional

Feature: Update Company Details

  Scenario: Successfully updated company detail
    Given User is logged in using admin account
    And User navigated to the update company page
    When User update the company with valid details
    Then User should be redirected to all company page