package com.samgurman.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.samgurman.products.TopMenuCartProduct;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;
import org.testng.Assert;

import java.util.LinkedList;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by coder on 16.03.16.
 */
public class PermanentUI {
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
    private ElementsCollection slideLinkLinksControls;

    @FindBy(how = How.XPATH, using = ".//*[@id='rev_slider_1_1']/ul")
    private ElementsCollection slideLinkElements;

    @FindBy(how = How.ID, using = "advancedcustomfacebooklikeboxwidget-2")
    private SelenideElement facebookWidget;

    @FindBy(how = How.ID, using = "sz-google-followers-2")
    private SelenideElement googlePlusWidget;

    @FindBy(how = How.XPATH, using = "html/body/div[1]/div/div[1]/header/div/div/div/div/div[1]/a/img")
    private SelenideElement mainPage;


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
    }

    @Step("Go to main page")
    public MainPage goToMainPage(){
        mainPage.click();
        return page(MainPage.class);
    }

    @Step("Open product category page through top menu")
    private void openProductCategoryOnTopMenu(int item) {
        Actions action = new Actions(getWebDriver());
        action.moveToElement(assortiment).build().perform();

        assortimentContent=$$(By.xpath(".//*[@id='menu-%d0%b2%d1%81%d0%b5-%d1%82%d0%be%d0%b2%d0%b0%d1%80%d1%8b-1']/li[1]/ul/li"));
        assortimentContent.get(item).click();
        //Assert.assertTrue(assortimentContent.size() == ProductCategory.NONE.ordinal(), "Count of products categories is not correct");
    }

    @Step("Open product category page")
    public ProductCategoryPage openProductCategoryPage(String category){

        ProductCategory selectedCategory;

        switch (category) {
            case "Подарочки": selectedCategory=ProductCategory.PRAZDNICHNYJ_ASSORTIMENT;  break;
            case "Закваски": selectedCategory=ProductCategory.ZAKVASKI; break;
            case "Сухофрукты": selectedCategory=ProductCategory.SUHOFRUKTY_OREHI; break;
            case "Морепродукты": selectedCategory=ProductCategory.MOREPRODUKTY; break;
            case "Мясо": selectedCategory=ProductCategory.MJASO_KOLBASY; break;
            case "Сыры": selectedCategory=ProductCategory.SYRY; break;
            case "Паста": selectedCategory=ProductCategory.PASTA; break;
            case "Масло": selectedCategory=ProductCategory.MASLO_SOUSY; break;
            case "Специи": selectedCategory=ProductCategory.SOL_SAHAR_SPECYI; break;
            case "Консервы": selectedCategory=ProductCategory.KONSERVATSIYA; break;
            case "Кофе": selectedCategory=ProductCategory.COFFEE; break;
            case "Чай": selectedCategory=ProductCategory.TEA; break;
            case "Сладости": selectedCategory=ProductCategory.SLADOSTI; break;
            case "Крупы": selectedCategory=ProductCategory.KRUPY; break;
            case "Хлебцы": selectedCategory=ProductCategory.HLEBCY; break;
        default: selectedCategory=ProductCategory.NONE;
        }
        openProductCategoryOnTopMenu(selectedCategory.ordinal());
       // Assert.assertTrue(getWebDriver().getTitle().toLowerCase().contains(category.toLowerCase()), "Wrong category selected, or wrong page title");
        return page(ProductCategoryPage.class);
    }

    @Step("Click on top menu item")
    public UniversalPage openTopMenuItem(String item){

        ProductCategory selectedCategory;
        switch (item) {
            case "Наш ассортимент": leftMenuContent.get(0).click(); return page(LoginRegisterPage.class);
            case "Оплата и доставка": leftMenuContent.get(1).click(); return page(LoginRegisterPage.class);
            case "Скидки": leftMenuContent.get(2).click(); return page(LoginRegisterPage.class);
            case "Наши рецепты": leftMenuContent.get(3).click(); return page(LoginRegisterPage.class);


            case "Наши новинки": rightMenuContent.get(0).click();return page(LoginRegisterPage.class);
            case "Кабинет": rightMenuContent.get(1).click(); return page(LoginRegisterPage.class);
            case "Оформить заказ": rightMenuContent.get(2).click(); return page(LoginRegisterPage.class);
            case "Корзина": rightMenuContent.get(3).click(); return page(CartPage.class);
        }

       Assert.fail("Wrong item of top menu tries to open");
        return null;
    }

    @Step("Verifying is correct page opened")
    public void verifyPage(String expected)
    {
        Assert.assertTrue(getWebDriver().getTitle().toLowerCase().contains(expected.toLowerCase()), "Wrong page opened, or wrong page title");
    }

    @Step("View and cart content")
    public Cart viewAndGetCartContent()
    {
        Actions action = new Actions(getWebDriver());
        action.moveToElement(cart).build().perform();


         LinkedList<TopMenuCartProduct> listOfItems=new LinkedList<TopMenuCartProduct>();
                for (SelenideElement i:$$(By.xpath("html/body/div[1]/div/div[1]/div[1]/div[2]/div/div/div/div/ul/li")))
                listOfItems.add(new TopMenuCartProduct(i));

        return new Cart(Double.parseDouble(cart.$(By.xpath("./div/div/p[1]/span")).getText().replaceFirst(" грн","")),listOfItems);
    }

    private int getItemsInCart()
    {
        return Integer.parseInt(cart.getText().replaceFirst("Корзина -", ""));
    }
}
