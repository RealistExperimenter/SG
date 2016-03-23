package com.samgurman.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by coder on 22.03.16.
 */
public class ProductPreview {
    private double price=0.0;
    private double price2=0.0;
    private double oldPrice=0.0;
    private String text;
    private String saleStatus="Обычный";
    private String link;
    private String productType="Simple";
    private int productQuantity=1;
    SelenideElement element;

    ProductPreview(SelenideElement element, int type){
       switch (type){
           case 1: { //product from additional lists(--Sale--)
               if (element.$(By.xpath("/ins/span")).exists()){
               oldPrice=transformPriceToDouble(element.$(By.xpath("/del/span")).getText());
               price=transformPriceToDouble(element.$(By.xpath("/ins/span")).getText());
           } else Assert.fail("A Wrong content type was sanded to the ProductType constructor from <Sale> section");

               text=element.$(By.xpath("/a[2]")).getText();
               saleStatus="Акция";
               link=element.$(By.xpath("/a")).getAttribute(("href"));
               this.element=element;} break;

           case 2:{ //product from cart
               price=transformPriceToDouble(element.$(By.xpath("/span/span")).getText());
               productQuantity=Integer.valueOf(element.$(By.xpath("/span")).getValue());
               text=element.$(By.xpath("/a[2]")).getText();
               saleStatus="Корзина";
               link=element.$(By.xpath("/a")).getAttribute(("href"));
               this.element=element;} break;

           default: { //product from page content
               if (element.$(By.xpath("/div[2]/span/ins/span")).exists()){
                   oldPrice=transformPriceToDouble(element.$(By.xpath("/div[2]/span/del/span")).getText());
                   price=transformPriceToDouble(element.$(By.xpath("/div[2]/span/ins/span")).getText());
               } else {
                   if (element.$(By.xpath("/div[2]/span[2]")).exists()) {
                       price = transformPriceToDouble(element.$(By.xpath("/div[2]/span[1]")).getText());
                       price2 = transformPriceToDouble(element.$(By.xpath("/div[2]/span[2]")).getText());
                       productType="Complex";
                   }
                   else price = transformPriceToDouble(element.$(By.xpath("/div[2]/span")).getText());
               }

               text=element.$(By.xpath("/div[2]")).getText();
               if (element.$(By.xpath("/a/span[1]")).exists()) saleStatus="Распродажа";
               link=element.$(By.xpath("/a")).getAttribute(("href"));
               this.element=element;} break;
       }
    }

    public void openItem(){
        try{
            element.$(By.xpath("/a")).click();
        }

        catch (Exception e){
            Assert.fail("This operation with element is obsolete. Suppose it is an error in creating of tests with Products actions");
        }
    }

    public void addToCart(){
        try{
            element.$(By.xpath("/div[1]/a[1]")).click();
        }

        catch (Exception e){
            Assert.fail("This operation with element is obsolete. Suppose it is an error in creating of tests with Products actions");
        }
    }

    private double transformPriceToDouble(String price)
    {
        String[] temp=price.split(" грн");
        return Double.valueOf(temp[0]);
    }

    public double getPrice() {
        return price;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public String getText() {
        return text;
    }

    public String getSaleStatus() {
        return saleStatus;
    }

    public String getLink() {
        return link;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public double getSecondPrice() {
        return price2;
    }

    public String getProductType() {
        return productType;
    }
}
