Feature: Update Contact Information

  Background: Login with valid data
    When navigate to the webpage
    Then enter the username and password
    Then Click login button
    Then verify Home Page Opened

  @Accounts
  @Contact
  @Positive
  Scenario: Successfully update contact information
    Given the user is on the Home Page
    When the user navigates to the "Update Contact Info" page
    Then the Update Profile fields should be visible
    When the user updates the contact information
    And clicks the "Update Profile" button
    Then a success message should be displayed
    When the user navigates to the "Update Contact Info" page again
    And the updated information should appear in the profile
    When the user logs out and logs back in
    Then the updated contact info should persist

  @Accounts
  @Contact
  @Negative
  Scenario: Display validation message when Address is empty
    Given the user is on the Home Page
    When the user navigates to the "Update Contact Info" page
    And clears the "Address" field
    And clicks the "Update Profile" button
    Then a validation message should appear for the "Address" field
    And the contact information should not be updated



