Feature: Convert temperature

Scenario: Convert to Celsius from Fahrenheit

	Given I wantt to convert 98.6 degree toFahrenheit
	
	When I input the value of 98.6 in text box
	
	Then It should be converted to celsius to 37 dgree