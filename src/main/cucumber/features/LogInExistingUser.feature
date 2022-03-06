Feature: Log in to Existing User

  Scenario Outline: LoginUser
    Given Open webpage: https://mystore-testlab.coderslab.pl
    When click SignIn button
    And Valid email jutripedro@vusra.com and password password
    And Click My Address
    And Fill valid user info: <alias>, <address>, <city>, <postalCode>, <country>, <phone>
    And confirm valid data
#    And delete address
#    Then confirm success


    Examples:
      | alias    | address     | city   | postalCode | country        | phone     |
      | Sherlock | BakerStreet | London | E16AN      | UnitedKingdom  | 666666666 |
#     | watson   | BakerStreet | London | E16AN      | United Kingdom | 666666667 |
