Feature: Test payment mock

Scenario: Check payment

    Given url 'http://localhost:8080/payment/check'

    And request
    """
    {
      "payment_method": "bank-transfer",
      "payment_details": {
        "bank_name": "Kaspi",
        "account_name": "Alex",
        "account_number": "123456"
      }
    }
    """

    When method POST

    Then status 200

    And match response ==
    """
    {
      "message": "Success status"
    }
    """