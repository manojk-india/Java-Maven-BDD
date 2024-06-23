Feature: Create an item

  Scenario: Create an item with a valid body
    Given I have the base URL of the API
    When I send a POST request to the "items" endpoint with the body "wells"
    Then the response status code should be 201
