package com.samgurman.products;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * Created by coder on 23.03.16.
 */
public class SimpleProduct extends BaseProduct{

    public SimpleProduct(SelenideElement element) {
        super(element);
    }

    @Override
    protected void build(SelenideElement element) {
        if (element.$(By.xpath("./div[2]/span/ins/span")).exists()){
            oldPrice=transformPriceToDouble(element.$(By.xpath("./div[2]/span/del/span")).getText());
            price=transformPriceToDouble(element.$(By.xpath("./div[2]/span/ins/span")).getText());
        } else {
            if (element.$(By.xpath("./div[2]/span[2]")).exists()) {
                price = transformPriceToDouble(element.$(By.xpath("./div[2]/span[1]")).getText());
                price2 = transformPriceToDouble(element.$(By.xpath("./div[2]/span[2]")).getText());
                productType="Complex";
             }
            else price = transformPriceToDouble(element.find(By.xpath("./div[2]/span/span")).getText());
        }

        text=element.$(By.xpath("./div[2]")).getText();
        if (element.$(By.xpath("./a/span[1]")).exists()) saleStatus="Распродажа";
        link=element.$(By.xpath("./a")).getAttribute(("href"));
        this.element=element;
    }

    @Override
    public void openItem() {
        try{
            element.$(By.xpath("./a")).click();
        }

        catch (Exception e){
            Assert.fail("This operation with element is obsolete. Suppose it is an error in creating of tests with Products actions");
        }
    }


    public void addToCart() {
        try{
            Actions action = new Actions(getWebDriver());
            action.moveToElement(element).build().perform();
            element.$(By.xpath("./div[1]/a[1]")).click();
        }

        catch (Exception e){
            Assert.fail("This operation with element is obsolete. Suppose it is an error in creating of tests with Products actions");
        }
    }
}
