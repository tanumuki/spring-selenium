Feature: Login with valid credentials

  @login
  Scenario Outline: Login without captcha
    Given I am on the website
    When I click on Login button
    And I login with the credentials "<email>" and "<password>" without solving captcha
    Then I should not be able to login
    Examples:
      | email               | password  |
      |testsmdemo@gmail.com | Saavn1234 |
