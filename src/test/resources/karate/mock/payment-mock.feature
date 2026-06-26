Feature: Payment Mock API

Scenario: pathMatches('/payment/check') && methodIs('post')

    * print 'Request:', request

    * def responseStatus = 200
    * def response =
    """
    {
      "message": "Success status"
    }
    """