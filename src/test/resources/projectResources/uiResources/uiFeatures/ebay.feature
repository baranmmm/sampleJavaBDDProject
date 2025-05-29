Feature: Ebay Feature

  @ebay
  Scenario: Ebay product search
    Given the user goes to ebay website
    When the user searches for "wooden spoon" item
    And navigates to search results
    And collects the first item price
    And clicks on the first search result
    Then verifies that the prices are matching

