Feature: Apply Leave in OrangeHRM

  Scenario: Successfully apply a casual leave with partial day
    Given I am on the OrangeHRM login page
    When I enter valid username and password
    And I click the login button
    Then I should be logged into the OrangeHRM dashboard

Given I am on the dashboard after login
    When I click on the Leave menu
    And I click on the Apply Leave option
    And I select casual leave from the leave type dropdown
    And I select the from date
    And I select the to date
    And I select partial days as Start Day Only and time as Half Day - Morning
    And I enter comment "Need leave for personal work"
    And I click on the Apply button
    Then the leave should be applied successfully