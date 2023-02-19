@api
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
      | 62ba2f07147daf00c53d9e95 |
    Then status code is 200

  Scenario: Delete product by id
    When product by id is deleted
      | 62ba2f07147daf00c53d9e95 |
    Then status code is 200