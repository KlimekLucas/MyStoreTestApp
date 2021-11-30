Feature: Order Sweaters

  Scenario: OrderSweaters
    Given Open page: https://mystore-testlab.coderslab.pl
    When  SignIn user
    And Valid email and password
    And click Search our Catalog
    And click on Hummingbird Printed Sweater
    And check discount
    And select size: M
    And select items number 3
    And add to cart
    And click proceed button
    And proceed Cart
    And select Shipping Method
    And select payment Method
    Then take Screenshot
#    And Open user tab
#    And click order history


