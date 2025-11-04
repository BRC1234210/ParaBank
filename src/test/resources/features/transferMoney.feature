Feature: Transfer Money Functionality

  Background:
    When Navigate to the webpage
    Then enter the username and password
    Then Click login button
    Then verify Home Page Opened

  @Payment
  @Regression
  Scenario: Transfer Money
    When Click Transfer Funds
    Then Fill amount and choose accounts
    Then Click Transfer Button
    Then Check Transfer Message

  @Payment
  @Regression
  Scenario: Check Transfer Money
    When Click Find Transactions
    Then Complete Find Transactions Section
    Then Click Find Transactions
    Then Check Transaction Results








