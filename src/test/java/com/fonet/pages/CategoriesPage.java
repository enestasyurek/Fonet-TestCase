package com.fonet.pages;

import com.fonet.utilities.Utilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoriesPage extends BasePage {

    @FindBy(className = "card")
    public List<WebElement> products;

    @FindBy(className = "card-title")
    public List<WebElement> productTitles;

    @FindBy(xpath = "//div[@class='card-block']/h5")
    public List<WebElement> productsPrices;

    @FindBy(xpath = "//a[@onclick=\"byCat('notebook')\"]")
    public WebElement laptopsButton;

    @FindBy(xpath = "//a[@onclick=\"byCat('phone')\"]")
    public WebElement phonesButton;

    @FindBy(xpath = "//a[@onclick=\"byCat('monitor')\"]")
    public WebElement monitorsButton;

    // Class-level variables to store product details and section counts
    private List<Map<String, String>> allCategoriesDetails = new ArrayList<>();
    private List<Map<String, String>> sectionDetails = new ArrayList<>();

    public void collectAllCategoriesDetails() {
        collectDetailsFromSection(productTitles, productsPrices, allCategoriesDetails);
    }

    // Method to collect product details for a specific section or category
    public void collectDetailsFromSection(List<WebElement> titles, List<WebElement> prices, List<Map<String, String>> targetList) {
        for (int i = 0; i < titles.size(); i++) {
            String title = titles.get(i).getText();
            String price = prices.get(i).getText();

            Map<String, String> details = new HashMap<>();
            details.put("title", title);
            details.put("price", price);

            targetList.add(details);
        }
    }

    // Methods to click section buttons and collect their items
    public void collectLaptopsDetails() {
        laptopsButton.click();
        Utilities.sleep(2);  // Wait for the page to load
        collectDetailsFromSection(productTitles, productsPrices, sectionDetails);
    }

    public void collectPhonesDetails() {
        phonesButton.click();
        Utilities.sleep(2);  // Wait for the page to load
        collectDetailsFromSection(productTitles, productsPrices, sectionDetails);
    }

    public void collectMonitorsDetails() {
        monitorsButton.click();
        Utilities.sleep(2);  // Wait for the page to load
        collectDetailsFromSection(productTitles, productsPrices, sectionDetails);
    }

    // Getter methods to access collected product details
    public List<Map<String, String>> getAllCategoriesDetails() {
        return allCategoriesDetails;
    }

    public List<Map<String, String>> getSectionDetails() {
        return sectionDetails;
    }

    // Method to reset collected data
    public void resetProductDetails() {
        allCategoriesDetails.clear();
        sectionDetails.clear();
    }
}
