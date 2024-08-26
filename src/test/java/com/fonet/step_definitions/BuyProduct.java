package com.fonet.step_definitions;

import com.fonet.pages.IndexPage;
import com.fonet.pages.ProductPage;
import com.fonet.pages.CartPage;
import com.fonet.utilities.Driver;
import com.fonet.utilities.Utilities;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import java.util.Map;

public class BuyProduct {

    IndexPage indexPage = new IndexPage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();

    private String firstProductText;

    @When("the user selects a product from the product listing")
    public void user_selects_a_product_from_the_product_listing() {
        firstProductText = indexPage.firstProduct.getText();
        indexPage.firstProduct.click();
        Utilities.sleep(2);
        String firstProductInfo = productPage.productName.getText();
        if (!firstProductText.equals(firstProductInfo)) {
            throw new AssertionError("Product mismatch. Expected: " + firstProductText + ", but got: " + firstProductInfo);
        }
    }

    @When("the user clicks on the {string} button on the product page")
    public void the_user_clicks_on_the_button_on_the_product_page(String string) {
        productPage.addToCartButton.click();

    }


    @Then("an alert should be displayed with the message {string}")
    public void the_an_alert_should_be_displayed_with_the_message(String expectedMessage) {
        Utilities.sleep(2);
        String alertMessage = Driver.getDriver().switchTo().alert().getText();
        if (!alertMessage.equals(expectedMessage)) {
            throw new AssertionError("Alert message mismatch. Expected: " + expectedMessage + ", but got: " + alertMessage);
        }
    }

    @When("the user confirms the alert by clicking OK")
    public void the_user_confirms_the_alert_by_clicking_ok() {
        Driver.getDriver().switchTo().alert().accept();
    }

    @When("the user navigates to the Cart menu")
    public void user_navigates_to_the_cart_menu() {
        indexPage.CartNavButton.click(); // Locator for the "Cart" menu
        Utilities.sleep(2);
    }

    @When("the user clicks on the {string} button")
    public void the_user_clicks_on_the_button(String string) {
        cartPage.placeOrderButton.click();
        Utilities.sleep(2);
    }

    @Then("the selected product should be displayed in the cart")
    public void the_selected_product_should_be_displayed_in_the_cart() {
        if (!cartPage.cartProductTitle.getText().equals(firstProductText)) {
            throw new AssertionError("Product mismatch. Expected: " + firstProductText + ", but got: " + firstProductText);
        }
    }

    @When("the user fills in the following details in the order form:")
    public void the_user_fills_in_the_following_details_in_the_order_form(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> formData = dataTable.asMap(String.class, String.class);
        cartPage.fillForm(formData);
        // Also, we can test the fields
    }

    @When("the user submits the order by clicking the Purchase button")
    public void the_user_submits_the_order_by_clicking_the_button() {
        cartPage.purchaseButton.click();
    }


    @Then("the order confirmation page should be displayed")
    public void the_order_confirmation_page_should_be_displayed() {
        cartPage.purchaseMessage.isDisplayed();
        // We can improve this step by checking if it's the right product
    }

}
