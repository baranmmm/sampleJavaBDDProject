@login
Feature: Login Feature
  Scenario: Login with Valid Credentials
    Given the user provides valid credentials
    When the user clicks on login button
    Then the user should be able to logged in successfully

  @login_logout
  Scenario: Login with a specific role
    Given the user logs in as "HU Local Operations" role for "mehmet" user
    And the user logs out from Affectli



