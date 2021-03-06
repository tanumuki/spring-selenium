Feature: Search functionality across the platform

  Scenario Outline: Search for a single word keyword
    When I am on the website
    And I search with the keyword "<keyword>"
    Then The search grid should appear

    Examples:
    | keyword |
    | sanam   |

  Scenario Outline: Verify View All of any facet
    Given I am on the website
    When I search with the keyword "<keyword>"
    And I randomly clicked on View All of any facet
#    Then I verify the search results of the keyword with "Search results for "
    Examples:
      | keyword |
      | sanam    |
