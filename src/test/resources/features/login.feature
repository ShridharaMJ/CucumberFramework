#Author: your.email@your.domain.com

@login @e2etest
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

