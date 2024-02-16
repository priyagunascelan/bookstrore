Feature: Test User Authentication of Online Book store Application
  As a user of the Book Store App
  I want to Perform end-to-end testing for user registration, login, and password reset functionalities
  So that I can view result

  Scenario: Users can create accounts and log in
    Given I am on the Web page
    When I click Login in window
    Then I Register a Account

  Scenario: Passwords should be securely stored.
    Given I am on the Web page
    When I click Login in window
    Then I enter Different password

  Scenario: Users should be able to reset their passwords.
    Given I am on the Web page
    When I click Login in window
    Then I reset password

  Scenario: login with correct username and password.
    Given I am on the Web page
    When I click Login in window
    Then I navigate the Home page











