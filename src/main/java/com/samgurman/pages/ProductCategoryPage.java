package com.samgurman.pages;

import com.codeborne.selenide.ElementsCollection;
import com.samgurman.products.BaseProduct;
import com.samgurman.products.SimpleProduct;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by coder on 23.03.16.
 */
public class ProductCategoryPage extends UniversalPage {

    @FindBy(how = How.XPATH, using = "html/body/div[1]/div/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/ul/li")
    private ElementsCollection listOfProductsOnThePage;

    @Step("Click on top menu item")
    public BaseProduct addToCartProduct(int item) {
        SimpleProduct product= new SimpleProduct(listOfProductsOnThePage.get(item));
        product.addToCart();
        return product;
    }


}
