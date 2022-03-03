#Author: mj.shridhara@gmail.com	

@contact-us @smoke @e2etest
Feature: Weddriver University- COntact us Page

Scenario: Validate Successful  Submission - Unique data

Given I access the webdriver univerisity contct us page

When I enter a unique first name
And I enter a unique last name
And I enter a unique email address
And I enter a unique comment
And I click on Submit button
Then I should be presented with a successful contct us submission message


Scenario: Validate Successful Submission - Specific Data

Given I access the webdriver univerisity contct us page

When I enter a specific first name sarah
And I enter a specific last name woods
And I enter a specific email address testinsarah@email.com
And I enter a specific comment "Hellow word..."
And I click on Submit button
Then I should be presented with a successful contct us submission message

