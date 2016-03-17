package com.samgurman.pages;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
/**
 * Created by coder on 17.03.16.
 */
public class UniversalPage{

    public String getUrl(){
        return getWebDriver().getCurrentUrl();
    }

}
