Feature: Demo API automation sample

  @demo
  Scenario: Add an item into the cart
    Given the user sends a request to get all cat breeds to CAT api
    Then verifies that the status code is 200
    Then the response contains "Bengal" breed

