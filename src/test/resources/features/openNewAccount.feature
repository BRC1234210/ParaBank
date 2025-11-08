Feature: Open New Account

  Background: Login with valid data
    When navigate to the webpage
    Then enter the username and password
    Then Click login button
    Then verify Home Page Opened


  @Checking
  Scenario: Open a new Checking Account
    Given User is on the Homepage
    When User navigates to the "Open New Account" page
    Then User selects the account type:Checking
    And  Verify user's amount of balance
    And  Click on the "Open New Account" button
    Then Verify that the new Checking account is successfully created

  @Savings
  Scenario: Open a new Saving Account
    Given User is on the Homepage
    When User navigates to the "Open New Account" page
    Then User selects the account type:Savings
    And Verify user's amount of balance
    And Click on the "Open New Account" button
    Then Then Verify that the new Saving account is successfully created
