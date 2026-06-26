Feature: Products API

Background:


    * def result = call read('classpath:features/api/login.feature')
    * def token = result.token

    * def body = read('classpath:karate/payloads/product/product.json')

Scenario: Get products

    Given url 'https://api.practicesoftwaretesting.com/products'

    When method GET

    Then status 200

    And match response != null

Scenario: Create products
    Given url 'https://api.practicesoftwaretesting.com/products'
    And header Authorization = 'Bearer ' + token
    And request body
    When method POST
    Then status 500

