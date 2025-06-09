Feature: Directory Employee Search Functionality

  Background:
    Given the OrangeHRM application is opened in a browser
    And the user logs in using valid credentials
    And the user navigates to the Directory section from the dashboard

  @smoke45
  Scenario: Search for a specific employee using the Directory module
    When the user types "Tandra" into the employee name input field
    And selects the employee from the autocomplete suggestions
    And presses the Search button in the Directory section
    Then a message indicating "(1) Record Found" should appear in the results panel
