Feature: login functionality

  Scenario: Login with valid data
    When navigate to the webpage
    Then enter the username and password
    Then Click login button
    Then verify Home Page Opened