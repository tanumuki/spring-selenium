#Feature: Edit profile
#
#  @ignore
## Background:
##  Given I have the cookie for the following user
##  | username              | password   |
##  | paypaltest7@saavn.com | Saavn@1234 |
#
#  Scenario Outline: Verify edit profile of user
#    Given I am on edit profile screen
#    When I enter "<firstname>" and "<lastname>"
#    And I enter email as "<email>"
#    Then I click submit button
#    Examples:
#      | firstname | lastname |email|
#      |tanu       | mukherjee|tanu@saavn.com|