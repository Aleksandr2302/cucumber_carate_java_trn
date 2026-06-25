Feature: Products API

Background:


    * def result = call read('classpath:features/api/login.feature')
    * def token = result.token

    * def body =
    """
    {
                   "name": "new_product1",
                   "description": "descOfNewProduct1",
                   "price": 1.99,
                   "category_id": "01JFG8Q5XKZJY4BEYQ87PC2Q1Y",
                   "brand_id": "01JFG8Q5XKZJY4BEYQ87PC2Q1Y",
                   "product_image_id": "01JFG8Q5XKZJY4BEYQ87PC2Q1Y",
                   "is_location_offer": 1,
                   "is_rental": 0,
                   "co2_rating": "A"
                 }
"""

Scenario: Get products

    Given 'https://api.practicesoftwaretesting.com/products'

    When method GET

    Then status 200

    And match response != null

Scenario: Create products
    Given 'https://api.practicesoftwaretesting.com/products'
    And header Authorization = 'Bearer ' + token
    And request body
    When method POST
    Then status 201
    And match response != null
