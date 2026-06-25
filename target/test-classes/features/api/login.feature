Feature: Auth helper

Scenario: Get token

    Given url 'https://api.practicesoftwaretesting.com/users/login'
    And request
    """
    {
      "email": "customer@practicesoftwaretesting.com",
      "password": "welcome01"
    }
    """
    When method POST
    Then status 200

    * def token = response.access_token