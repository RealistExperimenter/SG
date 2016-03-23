package com.samgurman.tests;


import com.samgurman.pages.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.Failure;
import ru.yandex.qatools.allure.model.SeverityLevel;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

/**
 * Created by coder on 16.03.16.
 */
public class LoginTest {
    private UniversalPage mainPage;
    LoginRegisterPage loginPage;

    @BeforeTest
    public void initSteps(){
        mainPage= open("http://samgurman.com", MainPage.class);
       // loginPage=mainPage.goToLoginPage();
    }
    @Severity(SeverityLevel.BLOCKER)
    @Title("Negative login tests")
    @Description("Set of negative tests")
    @Test
    public void negativeLoginTests(){
        String username="gelezo.refresh@gmail.com";

        loginPage=mainPage.goToLoginPage();

            MainPage main = (MainPage)mainPage.goToMainPage();


        loginPage.clickOnAuthorisationButton();
        loginPage.checkErrorMessage("Ошибка: Необходимо ввести имя пользователя.");
        loginPage.tryToLoginWithUser("1", "");
        loginPage.checkErrorMessage("Ошибка: Необходимо ввести пароль.");
        loginPage.tryToLoginWithUser("", "1");
        loginPage.checkErrorMessage("Ошибка: Необходимо ввести имя пользователя.");
        loginPage.tryToLoginWithUser("1", "1");
        loginPage.checkErrorMessage("ОШИБКА: Неверное имя пользователя. Потеряли пароль?");
        loginPage.tryToLoginWithUser(username, "1");
        loginPage.checkErrorMessage("ОШИБКА: Введённый вами пароль пользователя " + username + " неверен. Потеряли пароль?");
        //positive
}
    @Severity(SeverityLevel.BLOCKER)
    @Title("Forgot password link tests")
    @Description("Test for ability to logging successfully")
    @Test
    public void forgotPasswordLinkTests() {

        loginPage=mainPage.goToLoginPage();
        loginPage.forgotPasswordLinkWorks();

    }

    @Severity(SeverityLevel.BLOCKER)
    @Title("Positive login tests")
    @Description("Test for ability to logging successfully")
    @Test
    public void positiveLoginTests() {
        String username="gelezo.refresh@gmail.com";
        String password="mypassword";


        loginPage=mainPage.goToLoginPage();
        AccountPage accountPage = loginPage.loginWithUser(username,password);
        if (accountPage == null) {
            Assert.assertTrue(false,"Break test:Cant logging with user");
        }
        accountPage.checkSuccessMessage("Вы вошли как gelezo.refresh");
    }

}
