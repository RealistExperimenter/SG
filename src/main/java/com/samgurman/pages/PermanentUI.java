package com.samgurman.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * Created by coder on 16.03.16.
 */
public class PermanentUI extends UniversalPage {
    @FindBy(how = How.CLASS_NAME, using = "top_account")
    private SelenideElement myAccount;

    @FindBy(how = How.CLASS_NAME, using = "top_account")
    private SelenideElement loginRegister;

    @FindBy(how = How.CLASS_NAME, using = "top_account logout")
    private SelenideElement logout;

    @FindBy(how = How.CLASS_NAME, using = "top_cart")
    private SelenideElement cart;

    @FindBy(how = How.CLASS_NAME, using = "html/body/div[1]/div/div[1]/div[1]/div[1]/div/p[2]/a/em/strong")
    private SelenideElement skype;

    @FindBy(how = How.CLASS_NAME, using = "html/body/div[1]/div/div[1]/div[1]/div[1]/div/p[1]")
    private SelenideElement telephones;

    @FindBy(how = How.XPATH, using = ".//*[@id='menu-%d0%b2%d1%81%d0%b5-%d1%82%d0%be%d0%b2%d0%b0%d1%80%d1%8b-1']/li[1]/a")
    private SelenideElement assortiment;

    @FindBy(how = How.XPATH, using = ".//*[@id='menu-%d0%b2%d1%81%d0%b5-%d1%82%d0%be%d0%b2%d0%b0%d1%80%d1%8b-1']/li[1]/ul")
    private ElementsCollection assortimentContent;

    @FindBy(how = How.XPATH, using = ".//*[@id='menu-%d0%b2%d1%81%d0%b5-%d1%82%d0%be%d0%b2%d0%b0%d1%80%d1%8b-1']")
    private ElementsCollection leftMenuContent;

    @FindBy(how = How.XPATH, using = ".//*[@id='menu-account-1']")
    private ElementsCollection rightMenuContent;

    @FindBy(how = How.XPATH, using = "..//*[@id='jivo-label-text']")
    private SelenideElement jivosvitMessanger;

    @FindBy(how = How.XPATH, using = ".//*[@id='rev_slider_1_1_wrapper']/div[3]/span/")
    private ElementsCollection slidelinkLinksControls;

    @FindBy(how = How.XPATH, using = ".//*[@id='rev_slider_1_1']/ul")
    private ElementsCollection slidelinkElements;

    @FindBy(how = How.ID, using = "advancedcustomfacebooklikeboxwidget-2")
    private ElementsCollection facebookWidget;

    @FindBy(how = How.ID, using = "sz-google-followers-2")
    private ElementsCollection googlePlusWidget;



    public PermanentUI() {
     //   PageFactory.initElements(getWebDriver(),this);
    }

    @Step("Check for: Not any of users is logged")
    public void userNotLoggedIn(){
        loginRegister.shouldHave(Condition.text("Войти / Зарегистрироваться"));
     }

    @Step("Go to login page")
    public LoginRegisterPage goToLoginPage(){
        userNotLoggedIn();
        loginRegister.click();
        return page(LoginRegisterPage.class);


        /*
        Actions action = new Actions(getWebDriver());
        action.moveToElement(assortiment).build().perform();
       */
    }

}
