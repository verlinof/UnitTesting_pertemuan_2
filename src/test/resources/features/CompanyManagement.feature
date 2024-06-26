# new feature
# Tags: optional

Feature: Company Management

  Background: Admin has logged in using admin account
    Given Admin is logged in using admin account

  @CreateCompany
  Scenario: Successfully created company
    Given Admin navigated to the create company page
    When Admin submit the company form with valid details
    Then Admin should see a success message Success Creating Company

  @UpdateCompany
  Scenario: Successfully updated company detail
    Given Admin navigated to the update company page
    When Admin update the company with valid details
    Then Admin should be redirected to all company page

  @DeleteCompany
  Scenario: Successfully deleted a company
    Given Admin navigated to the all company page
    And Admin click the delete button on company
    When Admin click the confirm delete button
    Then Admin should be redirected to all company page
