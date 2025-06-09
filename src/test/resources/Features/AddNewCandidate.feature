Feature: Add New Candidate

Background:
  Given the application is opened in a web browser
  And the user provides valid login credentials to access the dashboard
  And the user navigated to recruitment module
   @Reg
  Scenario: Add a candidate in Recruitment
    Given I am on the dashboard
    When I click on the Recruitment menu
    And I click on Add Candidate
    And I select job vacancy
    And I type name of candidate 
    And I enter mobile number
    And I upload resume
    And I click on Save
    Then the candidate should be added successfully
    And I click on Shortlist button
    And I click on Save button