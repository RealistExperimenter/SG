package com.samgurman.products;

import com.codeborne.selenide.SelenideElement;

/**
 * Created by coder on 23.03.16.
 */
public abstract class BaseProduct {
    protected double price=0.0;
    protected double price2=0.0;
    protected double oldPrice=0.0;
    protected String text;
    protected String saleStatus="Обычный";
    protected String link;
    protected int productQuantity=1;
    protected String productType="Simple";
    SelenideElement element;


    protected BaseProduct(SelenideElement element) {
        build(element);
    }

    protected abstract void build(SelenideElement element);

    protected abstract void openItem();

    protected double transformPriceToDouble(String price)
    {
        String[] temp=price.split(" грн");
        return Double.parseDouble(temp[0]);
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
}
