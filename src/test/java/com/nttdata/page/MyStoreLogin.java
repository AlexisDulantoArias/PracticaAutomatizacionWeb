package com.nttdata.page;

import org.openqa.selenium.By;

public class MyStoreLogin {
    public static By loginButton = By.xpath("//*[@id=\"_desktop_user_info\"]/div/a");
    public static By emailField = By.id("field-email");
    public static By passwordField = By.id("field-password");
    public static By submitLogin = By.id("submit-login");
    public static By errorLoginMessage = By.xpath("//*[@id=\"content\"]/section/div/ul/li");
}
