package com.samgurman.products;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by coder on 23.03.16.
 */
public class SaleProduct extends BaseProduct {
    public SaleProduct(SelenideElement element) {
        super(element);
    }

    @Override
    protected void build(SelenideElement element) {
        if (element.$(By.xpath("./ins/span")).exists()){
            oldPrice=transformPriceToDouble(element.$(By.xpath("./del/span")).getText());
            price=transformPriceToDouble(element.$(By.xpath("./ins/span")).getText());
        } else Assert.fail("A Wrong content type was sanded to the ProductType constructor from <Sale> section");

        text=element.$(By.xpath("./a[2]")).getText();
        saleStatus="Акция";
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
