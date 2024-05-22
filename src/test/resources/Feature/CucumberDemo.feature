Feature: Login and Validate the login

	Scenario: Login to OrangeHRM portal using valid credentials
		Given user is providing valid credentials
		When user clicks on login button
		Then user is directed to main page
		
	Scenario: Login to OrangeHRM portal using invalid credentials
		Given user is providing invalid credentials
		When user clicks on login button
		Then user should not be logged in
			
	