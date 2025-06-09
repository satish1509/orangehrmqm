Feature: Admin Module - Add and Search User

  Background:
    Given User launches the application URL
    And User logs into the application with valid credentials
    And User is on the Admin module page
    
@admin
  Scenario: Add a new user in Admin module
    When User clicks on Add button
    And User selects user role as admin
    And User enter name and select name from dropdown 
    And User selects status Enabled
    And User enters username 
    And User enters password
    And User enters confirm password
    And User clicked on Submit button
    Then New user should be added successfully
    
    @admin
    Scenario: Search for the newly added user
    When User enters username in the search field
    And User selects user role as Admin
    And User selects status as Enabled
    And User clicks on Submit button
    Then User details should be displayed in the search results
    