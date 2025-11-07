Feature: Loan Application Process


  Background: Login with valid data
    When navigate to the webpage
    Then enter the username and password
    Then Click login button
    Then verify Home Page Opened


  @Smoke
  Scenario: User successfully applies for a loan
    When The user clicks on the "Request Loan" link
    Then The user enters values in the "Loan Amount" and "Down Payment" fields
    Then The user selects an account number
    Then The user clicks the "Apply" button
    Then The user verifies under the "Loan Request Processed" heading that:
    Then The user verifies the message "Your credit transaction has been approved."
    Then The user clicks on the link for the newly created credit account number
    Then The user then verifies the information in the “Account Details” section and confirms the “No transactions found” message.


  @Smoke
  Scenario: User fails to apply for a loan due to insufficient funds
    When The user clicks on the "Request Loan" link
    Then The user enters the "Loan Amount" as "$1,000,000" and the "Down Payment" as "$10,000"
    Then The user selects an account number
    Then The user clicks the "Apply Now" button
    Then The user verifies under the "Loan Request Processed" heading that:
    Then The user verifies the error message "You do not have sufficient funds for the given down payment."


