package com.samgurman.pages;

import com.codeborne.selenide.Selenide;
import com.samgurman.products.TopMenuCartProduct;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.LinkedList;

/**
 * Created by coder on 22.03.16.
 */
public class Cart {
    private double cartAmount=0.0;
    private LinkedList<TopMenuCartProduct> products=new LinkedList<TopMenuCartProduct>();

    public Cart(double cartAmount, LinkedList<TopMenuCartProduct> products) {
        this.cartAmount = cartAmount;
        this.products = products;
    }

    public void goToCart(){
        try{
        Selenide.$(By.xpath("html/body/div[1]/div/div[1]/div[1]/div[2]/div/div/div/div/p[2]/a[1]")).click();
    }

    catch (Exception e){
        Assert.fail("This operation with element is obsolete. Suppose it is an  error in creating of tests with cart");
    }

    }

    public void proceedPurchase(){
        try{
            Selenide.$(By.xpath("html/body/div[1]/div/div[1]/div[1]/div[2]/div/div/div/div/p[2]/a[2]")).click();
        }

        catch (Exception e){
            Assert.fail("This operation with element is obsolete. Suppose it is an error in creating of tests with cart");
        }
    }

    public double getCartAmount() {
        return cartAmount;
    }

    public LinkedList<TopMenuCartProduct> getProducts() {
        return products;
    }
}
