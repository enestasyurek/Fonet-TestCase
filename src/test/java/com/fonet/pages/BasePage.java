package com.fonet.pages;

import com.fonet.utilities.Driver;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}