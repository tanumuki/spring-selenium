Feature: Search functionality across the platform

  Scenario Outline: Search for a single word keyword
    When I accept all the cookies and alert toast
    And I search with the keyword "<keyword>"
    Then The search grid should appear

    Examples:
    | keyword |
    | sanam   |

  Scenario Outline: Verify View All of any facet
    Given I accept all the cookies and alert toast
    When I search with the keyword "<keyword>"
    And I randomly clicked on View All of any facet
#    Then I verify the search results of the keyword with "Search results for "
    Examples:
      | keyword |
      | sanam    |
