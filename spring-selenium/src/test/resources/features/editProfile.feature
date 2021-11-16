Feature: Edit profile

  Scenario Outline: Verify edit profile of user
    Given I am on edit profile screen
    When I enter credentials "<firstname>" "<lastname>" and "<email>"
    Then I click submit button
    Examples:
      | firstname | lastname |email|
      |tanu       | mukherjee|tanu@saavn.com|