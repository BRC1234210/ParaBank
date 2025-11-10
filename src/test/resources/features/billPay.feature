Feature: Paying bills tests

  Background:
    When navigate to the webpage
    Then enter the username and password
    Then Click login button

  Scenario Outline: Pay Bills
    Then Click bill pay button
    And Fill the payee information "<payeename>" "<address>" "<city>" "<state>" "<zipcode>" "<phone>"
    Then fill the account inputs
    Then fill the amount input "<amount>"
    Then click the send payment button
    Then Verify the payment is successful
    Then click the Account OverView Page
    Then verify payment1
    Then verify payment2
    Then verify payment3
    Then click Logout button

    Examples:
      | payeename  | address | city  | state | zipcode | phone   |amount|
      | su         | bursa   | bursa | TR    | 123     | 3332211 |20    |
      | elektrik   | bursa   | bursa | TR    | 123     | 3332211 |20    |
      | gaz        | bursa   | bursa | TR    | 123     | 3332211 |20    |


