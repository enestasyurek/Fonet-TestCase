@BuyProduct
Feature: Product Purchase Workflow

  Background: User should be in the "index" page
    Given User is on the index page

  Scenario: User successfully adds a product to the cart and places an order
    When the user selects a product from the product listing
    And the user clicks on the "Add to Cart" button on the product page
    Then an alert should be displayed with the message "Product added"
    When the user confirms the alert by clicking OK
    And the user navigates to the Cart menu
    Then the selected product should be displayed in the cart
    When the user clicks on the "Place Order" button
    And the user fills in the following details in the order form:
      | Field Name | Value         |
      | Name       | Enes          |
      | Country    | United States |
      | City       | New York      |
      | Card       | 10001         |
      | Month      | 5             |
      | Year       | 1995          |

    And the user submits the order by clicking the Purchase button
    Then the order confirmation page should be displayed

