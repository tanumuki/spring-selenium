Feature: Testcases regarding homepage scenarios in logged out state

  Background:
    Given I am on the website

  Scenario: Verify the + New Playlist feature in logged out state
    When I click on + New Playlist button
    Then I get the login modal popup

  Scenario: Verify the Songs button in logged out state
    When I click on Songs button
    Then I get the login modal popup

  Scenario: Verify that the user can scroll up to the end
    When I scroll down till the end of the page
    Then I can see the footer of the page

  Scenario: Verify upgrade page tab
    When I click on Upgrade button
    Then I can verify that new page opens on another tab

  Scenario: Verify browse page tab
    When I click on Browse button
    Then I can verify that the browse page opens on the website

  Scenario: Verify that Surprise button should play song entity
    When I click on Browse button
    And I click on Surprise button button
    Then The player should start playing a song




