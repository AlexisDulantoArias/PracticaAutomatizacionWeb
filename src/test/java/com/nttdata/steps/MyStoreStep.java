package com.nttdata.steps;

import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.screenShot;

public class MyStoreStep {
    private WebDriver driver;

    public MyStoreStep(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToTheWebpage() {
        driver.get("https://qalab.bensg.com/store/pe/");
        screenShot();
    }

    public void loginWithUsernameAndPassword(String username, String password) {
        loginInMyStore();
        typeUser(username);
        typePassword(password);
        clickLoginButton();
        successfulLogin();
    }

    public void loginInMyStore(){}
    public void typeUser(String username){}
    public void typePassword(String password){}
    public void clickLoginButton(){}
    public void successfulLogin(){}
}
