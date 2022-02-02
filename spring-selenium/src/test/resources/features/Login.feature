Feature: Verify different types of login

  Background:
    Given I am on the website

  Scenario Outline: Verify valid login flow
    When I click on Login button
    And I enter email "<email>" and password "<password>"
    Then I verify that I am logged in
    Examples:
      | email                   | password  |
#      | testwebauto00@gmail.com | Saavn1234 |
      |paypaltest7@saavn.com|Saavn@1234|
#      | testwebauto01@saavn.com | Saavn1234 |

  Scenario Outline: Login without captcha
    When I click on Login button without disabling captcha
    And I login with the credentials "<email>" and "<password>" without solving captcha
    Then I should not be able to login
    Examples:
      | email               | password  |
      |testsmdemo@gmail.com | Saavn1234 |

  Scenario Outline: Create new playlist
    When I click on Login button
    And I enter email "<email>" and password "<password>"
    And I try to create a new playlist

    Examples:
    | email | password |
#    | testwebauto01@saavn.com | Saavn1234 |
#    | testwebauto00@gmail.com | Saavn1234 |
    |paypaltest7@saavn.com|Saavn@1234|
