package com.nttdata.page;

import org.openqa.selenium.By;

public class MyStoreSubcategory {
    public static By subcategoryMen = By.xpath("//*[@id=\"subcategories\"]/ul/li[1]/div[1]/a");
    public static By subcategoryWomen = By.xpath("//*[@id=\"subcategories\"]/ul/li[2]/div[1]/a");
    public static By subcategoryStationery = By.xpath("//*[@id=\"subcategories\"]/ul/li[1]/div[1]/a");
    public static By subcategoryHomeAccesories = By.xpath("//*[@id=\"subcategories\"]/ul/li[2]/div[1]/a");
    public static By selectProduct = By.xpath("//*[@id=\"js-product-list\"]/div[1]/div/article");
}
