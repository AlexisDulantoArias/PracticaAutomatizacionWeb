package com.nttdata.page;

import org.openqa.selenium.By;

public class MyStoreHomePage {
    public static By logout = By.xpath("//*[@id=\"_desktop_user_info\"]/div/a[1]");
    public static By currency = By.xpath("//*[@id=\"_desktop_currency_selector\"]/div/button");
    public static By coinPEN = By.xpath("//*[@id=\"_desktop_currency_selector\"]/div/ul/li[1]/a");
    public static By coinUSD = By.xpath("//*[@id=\"_desktop_currency_selector\"]/div/ul/li[2]/a");
    public static By clothesCategory = By.id("category-3");
    public static By accesoryCategory = By.id("category-6");
    public static By artCategory = By.id("category-9");
}
