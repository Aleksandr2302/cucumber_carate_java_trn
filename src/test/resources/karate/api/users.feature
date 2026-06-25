Feature: Users API with auth

Background:
    * def result = call read('classpath:karate/api/login.feature')
    * def token = result.token

    * def random = Math.floor(Math.random() * 100000)
    * def randomEmail = 'john' + random + '@doe.example'

    * def body =
        """
                     {
                       "first_name": "John",
                       "last_name": "Doe",
                       "address": {
                         "street": "Street 1",
                         "house_number": "12",
                         "city": "City",
                         "state": "State",
                         "country": "Country",
                         "postal_code": "1234AA"
                       },
                       "phone": "0447654321",
                       "dob": "1970-01-01",
                       "password": "SuperSecure@123111111111111111111",
                       "email": "randomEmail"
                     }
                 """

# Scenario 1
Scenario: Get users with invalid token

    Given url 'https://api.practicesoftwaretesting.com/users'
    And header Authorization = 'Bearer ' + token
    When method GET
    Then status 403

# Scenario 2
Scenario: Create a new user

    Given url 'https://api.practicesoftwaretesting.com/users/register'
    And request body
    When method POST
    Then status 201
    And response.email == randomEmail

