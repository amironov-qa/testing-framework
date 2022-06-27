Feature: Rest Assured Example

  Scenario: Get all products
    When get all products request is sent
    Then status code is 200

  Scenario: Get product by id
    When get product by id request is sent
      | 62b1ad713fe36042796344df |
    Then status code is 200

  Scenario: Create new product
    When create new product request is sent
    Then status code is 201

  Scenario: Update product by id
    When product by id is updated
      | 62b9c2e92b41542118c58387 |
    Then status code is 200

  Scenario: Delete product by id
    When product by id is deleted
      | 62b9c2e92b41542118c58387 |
    Then status code is 200