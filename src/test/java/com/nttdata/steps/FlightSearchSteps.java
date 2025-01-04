package com.nttdata.steps;

import com.nttdata.page.GooglePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.nttdata.core.DriverManager.screenShot;

public class FlightSearchSteps {
    private WebDriver driver;
    private WebDriverWait wait;

    public FlightSearchSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
    }

    public void entryToGoogle(String url) {
        driver.get(url);
        screenShot();
    }

    public void writeTextOnGoogle(String flightSearch) {
        wait.until(ExpectedConditions.presenceOfElementLocated(GooglePage.searchBox));
        this.driver.findElement(GooglePage.searchBox).sendKeys(flightSearch);
        this.driver.findElement(GooglePage.searchBox).sendKeys(Keys.ENTER);
    }

    public void validateWidgetGoogleFlights() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GooglePage.widgetGoogleFlight));
        boolean isToolBarDisplayed = driver.findElement(GooglePage.widgetGoogleFlight).isDisplayed();
        Assertions.assertTrue(isToolBarDisplayed, "El titulo del whdget está presente.");
    }
}
