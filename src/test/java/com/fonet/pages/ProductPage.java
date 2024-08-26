package com.fonet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

    @FindBy(xpath = "//a[@onclick='addToCart(1)']")
    public WebElement addToCartButton;

    @FindBy(xpath = "//h2[@class='name']")
    public WebElement productName;

    @FindBy(xpath = "//h3[@class='price-container']")
    public WebElement productPrice;

}
