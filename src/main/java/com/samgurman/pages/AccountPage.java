package com.samgurman.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by coder on 17.03.16.
 */
public class AccountPage extends PermanentUI {
    @FindBy(how = How.XPATH, using = ".//*[@id='page-7']/div[2]/div[1]/div[1]")
    private SelenideElement successLoginMessage;




    @Step("Check success message")
    public void checkSuccessMessage(String message){
        successLoginMessage.shouldBe(Condition.visible);
        successLoginMessage.shouldHave(Condition.text(message));
    }
}


