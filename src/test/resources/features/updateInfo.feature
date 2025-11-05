Feature: Update Contact Information

  @Accounts
  @Contact

  Background: Login with valid data
    When navigate to the webpage
    Then enter the username and password
    Then Click login button
    Then verify Home Page Opened

  Scenario Outline: Successfully update contact information and verify persistence after re-login
    When the user navigates to "Update Contact Info" page
    Then the user verifies the Update Profile form fields are displayed: First Name, Last Name, Address, City, State, Zip Code
    And the user updates contact information with:
      | firstName | <firstName> |
      | lastName  | <lastName>  |
      | address   | <address>   |
      | city      | <city>      |
      | state     | <state>     |
      | zip       | <zip>       |
    And the user clicks the "Update Profile" button
    Then a success confirmation message should be displayed
    And the left panel or profile summary should reflect the updated contact information
    When the user logs out
    And the user logs in again with username "rami" and password "malek"
    Then the profile page should display the persisted contact information:
      | firstName | <firstName> |
      | lastName  | <lastName>  |
      | address   | <address>   |
      | city      | <city>      |
      | state     | <state>     |
      | zip       | <zip>       |

    Examples:
      | firstName | lastName | address              | city     | state | zip    |
      | Alice     | Carter   | 123 Market Street    | Seattle  | WA    | 98101  |
      | Alice     | Carter   |                      | Seattle  | WA    | 98101  |

  @Accounts
  @Contact
  Scenario: Verify validation message when required field is empty
    When the user navigates to "Update Contact Info" page
    And the user clears the "Address" field
    And the user clicks the "Update Profile" button
    Then a validation message should be displayed for the "Address" field
    And the contact information should not be updated