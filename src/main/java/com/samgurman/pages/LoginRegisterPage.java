package com.samgurman.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.model.Failure;

import static com.codeborne.selenide.Selenide.page;

/**
 * Created by coder on 17.03.16.
 */
public class LoginRegisterPage extends PermanentUI {

    private String uri="my-account/";

    @FindBy(how = How.XPATH, using = ".//*[@id='page-7']/div[2]/div[1]/ul/li")
    private SelenideElement errorMessage;

    @FindBy(how = How.XPATH, using = ".//*[@id='page-7']/div[2]/div[1]/div[1]")
    private SelenideElement successMessage;




    @FindBy(how = How.ID, using = "username")
    private SelenideElement userNameFieldForLogin;

    @FindBy(how = How.ID, using = "password")
    private SelenideElement userPasswordFieldForLogin;

    @FindBy(how = How.XPATH, using = ".//*[@id='customer_login']/div[1]/form/p[3]/input[3]")
    private SelenideElement authorisationButton;

    @FindBy(how = How.XPATH, using = ".//*[@id='customer_login']/div[1]/form/p[3]/label")
    private SelenideElement rememberMeCheckBox;

    @FindBy(how = How.XPATH, using = ".//*[@id='customer_login']/div[1]/form/p[4]/a")
    private SelenideElement forgotPasswordLink;



    @FindBy(how = How.ID, using = "reg_email")
    private SelenideElement userNameFieldForRegister;

    @FindBy(how = How.ID, using = "reg_password")
    private SelenideElement userPasswordFieldForRegister;

    @FindBy(how = How.XPATH, using = ".//*[@id='customer_login']/div[2]/form/p[3]/input[3]")
    private SelenideElement registrationButton;




    @Step("Click on authorise button")
    public void clickOnAuthorisationButton(){
        authorisationButton.click();
    }

    @Step("Enter username for logging")
    public void enterDataToUserNameFieldForLogin(String username){
        userNameFieldForLogin.setValue(username);
    }

    @Step("Enter password for logging")
    public void enterDataToUserPasswordFieldForLogin(String password){
        userPasswordFieldForLogin.setValue(password);
    }

    @Step("Try to login with user credentials")
    public void tryToLoginWithUser(String username,String password){
        enterDataToUserNameFieldForLogin(username);
        enterDataToUserPasswordFieldForLogin(password);
        clickOnAuthorisationButton();
    }

    @Step("Login with user credentials")
    public AccountPage loginWithUser(String username,String password){
        tryToLoginWithUser(username,password);
        if (successMessage.is(Condition.exist)&& successMessage.is(Condition.text("Вы вошли как")))
            return page(AccountPage.class);
            else return null;

    }

    @Step("Check logging error message")
    public void checkErrorMessage(String message){
        errorMessage.shouldBe(Condition.visible);
        errorMessage.shouldHave(Condition.text(message));
    }

    @Step("Check for: Forgot Password link works")
    public void forgotPasswordLinkWorks(){
        forgotPasswordLink.should(Condition.exist);
        forgotPasswordLink.shouldHave(Condition.attribute("href","http://samgurman.com/my-account/lost-password/"));
        forgotPasswordLink.click();
    }
}
