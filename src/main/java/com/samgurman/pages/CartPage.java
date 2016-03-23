package com.samgurman.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by coder on 23.03.16.
 */
public class CartPage extends UniversalPage{
    @FindBy(how = How.ID, using = "sz-google-followers-2")
    private SelenideElement couponCodeField;

    @FindBy(how = How.XPATH, using = ".//*[@id='page-5']/div[2]/div[1]/form/table/tbody/tr[8]/td/div/input[2]")
    private SelenideElement couponButton;

    @FindBy(how = How.XPATH, using = ".//*[@id='page-5']/div[2]/div[1]/form/table/tbody/tr[8]/td/button")
    private SelenideElement refreshCartButton;

    @FindBy(how = How.XPATH, using = ".//*[@id='page-5']/div[2]/div[1]/form/table/tbody/tr[8]/td/input[1]")
    private SelenideElement submitOrderButton;
}
