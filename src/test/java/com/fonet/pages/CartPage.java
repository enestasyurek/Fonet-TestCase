package com.fonet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class CartPage extends BasePage {

    @FindBy(xpath = "//button[text()='Place Order']")
    public WebElement placeOrderButton;

    @FindBy(xpath = "//tr[@class='success']//td[2]")
    public WebElement cartProductTitle;

    @FindBy(id = "name")
    public WebElement formName;

    @FindBy(id = "country")
    public WebElement formCountry;

    @FindBy(id = "city")
    public WebElement formCity;

    @FindBy(id = "card")
    public WebElement formCard;

    @FindBy(id = "month")
    public WebElement formMonth;

    @FindBy(id = "year")
    public WebElement formYear;

    @FindBy(xpath = "//button[@onclick=\"purchaseOrder()\"]")
    public WebElement purchaseButton;

    @FindBy(xpath = "//h2[text()=\"Thank you for your purchase!\"]")
    public WebElement purchaseMessage;

    public void fillForm(Map<String, String> formData) {
        formName.sendKeys(formData.get("Name"));
        formCountry.sendKeys(formData.get("Country"));
        formCity.sendKeys(formData.get("City"));
        formCard.sendKeys(formData.get("Card"));
        formMonth.sendKeys(formData.get("Month"));
        formYear.sendKeys(formData.get("Year"));
    }
}
