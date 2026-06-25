Feature: Users API with auth

Scenario: Get users with token

    * def result = call read('classpath:features/api/login.feature')
    * def token = result.token

    Given url 'https://api.practicesoftwaretesting.com/products'
    And header Authorization = 'Bearer ' + token
    When method GET
    Then status 200