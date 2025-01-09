package com.nttdata.page;

import org.openqa.selenium.By;

public class MyStoreCarPage {
    public static By carTitle = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[1]/h1");
    public static By unitaryPrice = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[2]/div[2]/div[2]/span");
    public static By productQuantity = By.xpath("//*[@id=\"cart-subtotal-products\"]/span[1]");
    public static By productTotalPrice = By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[1]/div[2]/div[1]/span[2]");
    public static By finishPurchaseBtn = By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a");
}
