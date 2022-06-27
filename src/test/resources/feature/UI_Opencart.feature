@OPENCART
Feature: Opencart

  Scenario: Register a new account
    Given register page is opened
    When user entered the valid data
    Then a new account is created