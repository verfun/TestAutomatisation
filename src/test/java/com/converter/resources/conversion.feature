Feature: Convert temperature

Scenario: Convert to Fahrenheit from Celsius

	Given I wan to convert 37 degree to Fahrenheit
	
	When I input the value of 37 in text box
	
	Then It should be display 98.6 degree Fahrenheit

Scenario: Add a new user

	Given I to add a new user
	
	When I input the user data
	
	Then It add to my list of users