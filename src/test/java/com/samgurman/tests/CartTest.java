package com.samgurman.tests;

import com.samgurman.pages.MainPage;
import com.samgurman.pages.Cart;
import com.samgurman.pages.ProductCategoryPage;
import com.samgurman.products.BaseProduct;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;

import java.util.LinkedList;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * Created by coder on 23.03.16.
 */
public class CartTest {
    private MainPage mainPage;
    @BeforeTest
    public void initSteps(){
       mainPage= open("http://samgurman.com", MainPage.class);
        // loginPage=mainPage.goToLoginPage();
    }
    @Severity(SeverityLevel.BLOCKER)
    @Title("Tests of cart functionality")
    @Description("Add few products to cart from different categories")
    @Test
    public void simpleCartTest(){
        String username="gelezo.refresh@gmail.com";
        List<BaseProduct> list=new LinkedList<BaseProduct>();
        double amount;
        ProductCategoryPage productPage= mainPage.openProductCategoryPage("Морепродукты");

        list.add(productPage.addToCartProduct(3));
        amount=list.get(0).getPrice();
        productPage= productPage.openProductCategoryPage("Паста");
        list.add(productPage.addToCartProduct(5));
        amount+=list.get(1).getPrice();
        sleep(1000);
        Cart cartContent = productPage.viewAndGetCartContent();

        Assert.assertTrue(cartContent.getCartAmount()==amount,"Amount is not equal");

       // loginPage=mainPage.goToLoginPage();


    }

}
