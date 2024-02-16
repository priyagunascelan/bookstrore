Feature: Test Book Catalog
  As a user of the Book Store App
  I want to Perform end-to-end testing for user registration, login, and password reset functionalities
  So that I can view result

  Scenario: Users can browse a catalog of available books
    Given I am on the Web page
    When I click Login in window
    And I navigate the Home page
    Then I check the available Book

  Scenario: Each book should have details like title, author, price, and availability
    Given I am on the Web page
    When I click Login in window
    And I navigate the Home page
    Then Each book should have details like title, author, price, and availability

  Scenario: Users can search for books by title or author
    Given I am on the Web page
    When I click Login in window
    And I Search with book name
    Then I search with author name

