Feature: Testcases regarding homepage scenarios in logged out state

  Background:
    Given I am on the website

  Scenario: Verify the + New Playlist feature in logged out state
    When I click on + New Playlist button
    Then I get the login modal popup

  Scenario: Verify the History button in logged out state
    When I click on "History" button
    Then I get the login modal popup

  Scenario: Verify the Songs button in logged out state
    When I click on Songs button
    Then I get the login modal popup

  Scenario: Verify that the user can scroll up to the end
    When I scroll down till the end of the page
    Then I can see the footer of the page
