Feature: Cart Operations

  Scenario: Add items to cart
    Given I am signed in as a standard user
    When I add items
      | Sauce Labs Bike Light       |
      | Sauce Labs Bolt T-Shirt     |
      | Sauce Labs Fleece Jacket    |
    And I view my cart
    Then the items should be in the cart
      | Sauce Labs Bike Light       |
      | Sauce Labs Bolt T-Shirt     |
      | Sauce Labs Fleece Jacket    |
    And the total price should match
      | $9.99  |
      | $15.99 |
      | $49.99 |

  Scenario: Add and remove items from cart
    Given I am signed in as a standard user
    When I add items
      | Sauce Labs Bike Light       |
      | Sauce Labs Bolt T-Shirt     |
      | Sauce Labs Fleece Jacket    |
    And I remove item "Sauce Labs Bike Light"
    And I view my cart
    Then the item "Sauce Labs Bike Light" should not be in the cart
    And the total price should match
      | $15.99 |
      | $49.99 |

  Scenario: Add, remove and add more items to cart
    Given I am signed in as a standard user
    When I add items
      | Sauce Labs Bike Light       |
      | Sauce Labs Bolt T-Shirt     |
      | Sauce Labs Fleece Jacket    |
    And I remove item "Sauce Labs Bike Light"
    And I add item "Sauce Labs Onesie"
    And I view my cart
    Then the item "Sauce Labs Onesie" should be in the cart
    And the total price should match
      | $15.99 |
      | $49.99 |
      | $7.99  |
