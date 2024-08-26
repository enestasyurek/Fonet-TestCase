package com.fonet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class IndexPage extends BasePage {

    @FindBy(id = "cat")
    public WebElement categoriesButton;

    @FindBy(id = "next2")
    public WebElement NextButton;

    @FindBy(id = "cartur")
    public WebElement CartNavButton;

    @FindBy(xpath = "//h4[@class='card-title']")
    public WebElement firstProductTitle;

    @FindBy(xpath = "//h4[@class='card-title'][1]//a")
    public WebElement firstProduct;
}
