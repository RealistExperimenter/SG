package com.samgurman.products;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by coder on 23.03.16.
 */
public class TopMenuCartProduct extends BaseProduct {
    public TopMenuCartProduct(SelenideElement element) {
        super(element);
    }

    @Override
    protected void build(SelenideElement element) {
        price=transformPriceToDouble(element.$(By.xpath("./span/span")).getText());

        String[] temp=element.$(By.xpath("./span")).getText().split(" × ");
        productQuantity=Integer.parseInt(temp[0]);

        text=element.$(By.xpath("./a[2]")).getText();
        saleStatus="Корзина";
        link=element.$(By.xpath("./a")).getAttribute(("href"));
        this.element=element;
    }

    @Override
    protected void openItem() {
        try{
            element.$(By.xpath("./a[1]")).click();
        }

        catch (Exception e){
            Assert.fail("This operation with element is obsolete. Suppose it is an error in creating of tests with Products actions");
        }
    }
}
