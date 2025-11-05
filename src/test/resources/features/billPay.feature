Feature: Paying bills tests

Background:
    When Navigate to the webpage
    Then Click the Register Link
    And Fill the additional details
    Then Click Register button
    Then Verify Registration is successful

Background:
    When navigate to the webpage
    Then enter the username and password
    Then Click login button
    Then verify Home Page Opened

  @Smoke
  Scenario: Pay Bills
    Then Click bill pay button
    And Fill the payee information
      | field     | value       |
      | payeename | <mahmut>    |
      | address   | <sokak>     |
      | city      | <bursa>     |
      | state     | <TR>        |
      | zipcode   | <123456>    |
      | phone     | <33333>     |

    Then Click read account number
    Then fill the account inputs
    Then click the send payment button
    Then Verify the payment is successful