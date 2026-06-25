Feature: Register

Scenario: Register new user
Given user opens the site
When user navigates to login page
And user click register button
And user fill first name
And user fill last name
And user fill dob
And user select country
And user fill postalCode
And user fill houseNumber
And user fill street
And user fill city
And user fill state
And user fill phone
And user fill email
And user fill password
And user click finish register button
And user enters valid credentials
And user clicks login button
Then my account page is displayed