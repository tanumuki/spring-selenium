Feature: Search functionality across the platform

  Scenario Outline: Search for a single word keyword
    Given I am on the website
    When I accept all the cookies and alert toast
    And I search with the keyword "<keyword>"
    Then The search grid should appear

    Examples:
    | keyword |
    | sanam   |