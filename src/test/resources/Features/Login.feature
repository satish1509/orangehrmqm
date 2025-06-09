Feature: Verify the Login Functionality

  @Login
  Scenario: Successful login with valid credentials
    Given the user navigates to application URL
    When the user enters a valid username and valid password
    And the user clicks the Login button
    Then the user should be successfully logged in
