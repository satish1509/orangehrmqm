Feature: Add and Search Employee in PIM Module

  Background:
    Given User navigated to the url
    And user signed into the application
    And user navigates to the PIM page

	  @smoke
	  Scenario: Add a new employee in PIM module
	    When I click on the Add button
	    And I enter employee first name
	    And I enter employee last name
	    And I see employee ID number
	    And I click on the Save button
	    Then the employee should be added successfully
	
	
	@smoke
	  Scenario: Search for an employee in PIM module
	    When I enter employee name in the search field
	    And I click on the Search button
	    Then the employee record should be displayed in the results