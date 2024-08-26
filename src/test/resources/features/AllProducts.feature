@AllProducts
Feature: All products should be listed in the related pages

  Background: User should be in the "index" page
    Given User is on the index page

  Scenario: Validate total product count matches sum of all categories with pagination
    When I click on the "Categories" menu
    Then I should collect all product titles and prices from the categories page
    Then I should collect all product titles and prices across all sections
    And I should verify that the sum of all products collected matches the displayed total
