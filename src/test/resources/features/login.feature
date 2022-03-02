#Author: your.email@your.domain.com

@login
Feature: login feature
 @smoke
  Scenario Outline: login to portal using valid credentials
    Given I navigate to login page
    When I enter valid username  "<username>"
    And I enter valid   password "<password>"
    And I click on login 
    Then I should get validation alert with  "<message>"
   
   Examples: 
    |username|password|message|
    |webdriver|webdriver123|validation succeeded|
    |webdriver|webdriver12345|validation failed1|
    |webdriver123|webdriver12345|validation failed|