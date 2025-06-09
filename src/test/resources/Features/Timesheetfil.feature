Feature: Timesheet Submission

  Background:
    Given user launches URL
    And User signs into the orange hrm with valid credentials
    And User navigated into to the dashboard

  Scenario: Submit Timesheet
    When User clicks on the Time button
    And User clicked on Timesheet dropdown 
    When User cliked on my timesheet 
    Then Timesheet period for current week is displayed
    And User clicks on Submit Button
    Then Timesheet is submitted successfully