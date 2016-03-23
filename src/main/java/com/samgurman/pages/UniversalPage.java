package com.samgurman.pages;

import org.testng.Assert;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
/**
 * Created by coder on 17.03.16.
 */
public class UniversalPage extends PermanentUI{

    public String getUrl(){
        return getWebDriver().getCurrentUrl();
    }
}
