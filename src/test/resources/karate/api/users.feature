Feature: Users API with auth

Background:
    * def result = call read('classpath:karate/api/login.feature')
    * def token = result.token


# Scenario 1
Scenario: Get users with invalid token

    Given url 'https://api.practicesoftwaretesting.com/users'
    And header Authorization = 'Bearer ' + token
    When method GET
    Then status 403


# Scenario 2
Scenario: Get me user
    Given url 'https://api.practicesoftwaretesting.com/users/me'
    And header Authorization = 'Bearer ' + token
    When method GET
    Then status 200