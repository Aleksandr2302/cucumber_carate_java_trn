Feature: Register a new user

 def token = result.token

Background:
    * def random = Math.floor(Math.random() * 100000000)
    * def randomEmail1 = 'john' + random + '@doe.example'
    * def randomEmail2 = 'john' + random + '@doe.example'
    * def randomPassword1 = 'John' + random + 'password!'
    * def randomPassword2 = '1'

    * def body = read('classpath:karate/payloads/register/register-user.json')
    * def incorrectBodyWithInvalidEmail = read('classpath:karate/payloads/register/register-user-incorrect.json')

@createUser
# Scenario 1
Scenario: Create a new user
* print body

    Given url 'https://api.practicesoftwaretesting.com/users/register'
    And request body
    When method POST
    Then status 201
    And response.email == randomEmail1
    And response.password == randomPassword1

    And match response contains
    """
    {
      email: '#string',
      first_name: '#string',
      last_name: '#string',
      phone: '#string',
      dob: '#string'
    }
    """


# Scenario 2
Scenario: Create user with invalid password
Given url 'https://api.practicesoftwaretesting.com/users/register'
    And request incorrectBodyWithInvalidEmail
    When method POST
    Then status 422

