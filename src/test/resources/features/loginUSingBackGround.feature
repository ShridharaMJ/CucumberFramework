#Author: mj.shridhara@gmail.com

@loginBackGround
Feature: WebDriver University - Login Page

Background:
Given I access the webdriver university login page


Scenario: Validate Successful Login
When I enter a username "webdriver"
 And I enter a password "webdriver123"
And I click on the login button
Then I should be presented with the successful login message

Scenario: Validate Unsuccessful Login
When I enter a username "webdriver"
And I enter a password "webdriver1"
And I click on the login button
Then I should be presented with the unsuccessful login message
