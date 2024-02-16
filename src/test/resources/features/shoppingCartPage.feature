Feature: Test Book Catalog
  As a user of the Book Store App
  I want to Perform end-to-end testing for user registration, login, and password reset functionalities
  So that I can view result

  Scenario: Users can add books to their shopping cart
    Given I am on the Web page
    When I click Login in window
    And I navigate the Home page
    Then I can add books to their shopping cart

  Scenario: The cart should display the selected items and the total price
    Given I am on the Web page
    When I click Login in window
    And I navigate the Home page
    And I can add books to their shopping cart
    Then I check the card

  Scenario: I can remove items from the cart
    Given I am on the Web page
    When I click Login in window
    And I navigate the Home page
    And I can add books to their shopping cart
    But I check the card
    Then I remove the items form the cart

  Scenario: I can update items from the cart
    Given I am on the Web page
    When I click Login in window
    And I navigate the Home page
    And I can add books to their shopping cart
    But I check the card
    Then I update the items form the cart