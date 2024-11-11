Feature: Sign-in Functionality

  Scenario: Sign-in
    Given I am at the sign in screen
    When I sign in as a standard user
    Then I should be at the products page
