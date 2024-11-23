Feature: Ebay Feature

  @ebay
  Scenario: Ebay product search
    Given the user goes to ebay website
    When the user searches for "wooden spoon" item
#    And navigates to search results
