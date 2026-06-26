Feature: Auth helper

Background:
    * def registerResult = call read('classpath:karate/api/register.feature@createUser')
    * def email = registerResult.randomEmail1
    * def password = registerResult.randomPassword1

@login
Scenario: Get token

    Given url 'https://api.practicesoftwaretesting.com/users/login'
    And request
    """
    {
      "email": #(email),
      "password": #(password)
    }
    """
    When method POST
    Then status 200

    * def token = response.access_token