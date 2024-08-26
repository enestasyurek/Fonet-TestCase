package com.fonet.step_definitions;

import com.fonet.pages.CategoriesPage;
import com.fonet.pages.IndexPage;
import com.fonet.utilities.ConfigurationReader;
import com.fonet.utilities.Driver;
import com.fonet.utilities.Utilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AllProducts {

    IndexPage indexPage = new IndexPage();
    CategoriesPage categoriesPage = new CategoriesPage();

    @Given("User is on the index page")
    public void user_is_on_the_index_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("URL"));
    }

    @When("I click on the {string} menu")
    public void i_click_on_the_menu(String string) {
        indexPage.categoriesButton.click();
    }

    @Then("I should collect all product titles and prices from the categories page")
    public void i_should_collect_all_product_titles_and_prices_from_the_categories_page() {
        do {
            categoriesPage.collectAllCategoriesDetails();
            if (indexPage.NextButton.isDisplayed()) {
                indexPage.NextButton.click();
                Utilities.sleep(2);
            } else {
                break;
            }
        } while (true);
    }

    @Then("I should collect all product titles and prices across all sections")
    public void i_should_collect_all_product_titles_and_prices_across_all_sections() {
        categoriesPage.collectLaptopsDetails();
        categoriesPage.collectPhonesDetails();
        categoriesPage.collectMonitorsDetails();
    }

    @Then("I should verify that the sum of all products collected matches the displayed total")
    public void i_should_verify_that_the_sum_of_all_products_collected_matches_the_displayed_total() {
        int allCategoriesCount = categoriesPage.getAllCategoriesDetails().size();
        int sectionCount = categoriesPage.getSectionDetails().size();

        if (sectionCount != allCategoriesCount) {
            throw new AssertionError("Product count mismatch. All Categories: " + allCategoriesCount + ", Section Total: " + sectionCount);
        } else {
            System.out.println("Product count matches across all sections.");
        }
    }

}


