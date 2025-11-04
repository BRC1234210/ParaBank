Feature: Open New Account Functionality

  @Accounts
    @Smoke
    @Regression

  Scenario Outline: Create New Account
    When Navigate to the webpage
    Then Click the Register Button on the login page
    And Fill the additional details
      | field     | value       |
      | firstname | <firstname> |
      | lastname  | <lastname>  |
      | address   | <address>   |
      | city      | <city>      |
      | state     | <state>     |
      | zipcode   | <zipcode>   |
      | phone     | <phone>     |
      | ssn       | <ssn>       |
      | username  | <username>  |
      | password  | <password>  |
      | confirm   | <confirm>   |

    Then Click Register button
    Then Verify Registration is successful

    Examples:
      | firstname | lastname | address | city   | state   | zipcode | phone      | ssn | username | password | confirm  |
      | Rita      | Ora      | UK      | London | England | 123     | +312456789 | xxx | Star     | Admin123 | Admin123 |




