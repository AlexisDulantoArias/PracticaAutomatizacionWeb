package com.nttdata.steps;

import com.nttdata.page.GooglePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.nttdata.core.DriverManager.screenShot;

public class SearchGoogleSteps {

    private WebDriver driver;
    private WebDriverWait wait;

    public SearchGoogleSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
    }

    public void entryToGoogle(String url) {
        driver.get(url);
        screenShot();
    }

    public void writeTextOnGoogle(String searchText) {
        wait.until(ExpectedConditions.presenceOfElementLocated(GooglePage.searchBox));
        this.driver.findElement(GooglePage.searchBox).sendKeys(searchText);
        this.driver.findElement(GooglePage.searchBox).sendKeys(Keys.ENTER);
    }

    public void validateImagesSection() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePage.toolBar));
        boolean isToolBarDisplayed = driver.findElement(GooglePage.toolBar).isDisplayed();
        Assertions.assertTrue(isToolBarDisplayed, "La barra de herramientas no está visible en la página.");
    }
}
