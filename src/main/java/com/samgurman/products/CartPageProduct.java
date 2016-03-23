package com.samgurman.products;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by coder on 23.03.16.
 */
public class CartPageProduct extends BaseProduct {
    private int quantity=1;
    public CartPageProduct(SelenideElement element) {
        super(element);
    }

    @Override
    protected void build(SelenideElement element) {
        price=transformPriceToDouble(element.$(By.xpath("./td[5]/span[2]")).getText());
        productQuantity=Integer.parseInt(element.$(By.xpath("./td[4]/div/input")).getValue());
        text=element.$(By.xpath("./td[2]/a")).getText();
        saleStatus="Корзина";
        link=element.$(By.xpath("./td[2]/a")).getAttribute(("href"));
        this.element=element;
        quantity=Integer.parseInt(element.$(By.xpath("./td[2]/dl")).getText());
    }



    @Override
    protected void openItem() {
        try{
            element.$(By.xpath("./div[1]/a[1]")).click();
        }

        catch (Exception e){
            Assert.fail("This operation with element is obsolete. Suppose it is an error in creating of tests with Products actions");
        }
    }

    protected void deleteItem(){
        try{
            element.$(By.xpath("/td[6]/a")).click();
        }

        catch (Exception e){
            Assert.fail("This operation with element is obsolete. Suppose it is an error in creating of tests with Products actions");
        }
    }

    protected void increaseQuantity(int how){
        try{
            element.$(By.xpath("./td[4]/div/input")).setValue(String.valueOf(how));
        }

        catch (Exception e){
            Assert.fail("This operation with element is obsolete. Suppose it is an error in creating of tests with Products actions");
        }

    }
}
