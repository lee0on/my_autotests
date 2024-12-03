Feature: Add a product
  Scenario: Adding a product to the catalog
    Given The administrator has a product to add
    When The administrator sends a request to add a product
    Then The server returns a response with correct product data