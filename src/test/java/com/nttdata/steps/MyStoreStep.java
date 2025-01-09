package com.nttdata.steps;

import com.nttdata.page.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

import static com.nttdata.core.DriverManager.screenShot;

public class MyStoreStep {

    private WebDriver driver;
    private WebDriverWait wait;

    public MyStoreStep(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
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

    public void loginInMyStore() {
        wait.until(ExpectedConditions.elementToBeClickable(MyStoreLogin.loginButton)).click();
    }

    public void typeUser(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MyStoreLogin.emailField))
                .sendKeys(username);
    }

    public void typePassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MyStoreLogin.passwordField))
                .sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(MyStoreLogin.submitLogin)).click();
    }

    public void successfulLogin() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(MyStoreLogin.errorLoginMessage));
            System.out.println("Hubo un error en el inicio de sesión por credenciales incorrectas");
            Assertions.fail("El login falló debido a credenciales incorrectas");
        } catch (TimeoutException e) {
            System.out.println("Se inició sesión correctamente.");
        }
    }

    public void currencyExchange(String currency) {
        wait.until(ExpectedConditions.presenceOfElementLocated(MyStoreHomePage.logout));

        try {
            WebElement currencyDropdown = wait.until(ExpectedConditions.elementToBeClickable(MyStoreHomePage.currency));
            currencyDropdown.click();

            switch (currency) {
                case "USD":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(MyStoreHomePage.coinUSD));
                    WebElement usdOption = wait.until(ExpectedConditions.elementToBeClickable(MyStoreHomePage.coinUSD));
                    usdOption.click();
                    break;

                case "PEN":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(MyStoreHomePage.coinPEN));
                    WebElement penOption = wait.until(ExpectedConditions.elementToBeClickable(MyStoreHomePage.coinPEN));
                    penOption.click();
                    break;

                default:
                    System.out.println("Error: Moneda no reconocida: " + currency);
                    Assertions.fail("La moneda elegida no es válida: " + currency);
            }
        } catch (NoSuchElementException e) {
            System.out.println("Error: No se encontró un elemento necesario en la página: " + e.getMessage());
            Assertions.fail("Fallo debido a un elemento ausente en la página.");
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
            Assertions.fail("Error inesperado al seleccionar la moneda.");
        }
    }

    public void navigateToCategoryAndSubcategory(String category, String subcategory) {
        try {
            switch (category.toLowerCase()) {
                case "clothes":
                    WebElement clothesOption = wait.until(ExpectedConditions.elementToBeClickable(MyStoreHomePage.clothesCategory));
                    clothesOption.click();
                    break;

                case "accesorios":
                    WebElement accesoriesOption = wait.until(ExpectedConditions.elementToBeClickable(MyStoreHomePage.accesoryCategory));
                    accesoriesOption.click();
                    break;

                case "art":
                    WebElement artOption = wait.until(ExpectedConditions.elementToBeClickable(MyStoreHomePage.artCategory));
                    artOption.click();
                    break;

                default:
                    System.out.println("Error: Categoría no reconocida - " + category);
                    Assertions.fail("La categoría especificada no es válida: " + category);
                    return;
            }

        } catch (NoSuchElementException e) {
            System.out.println("Error: No se encontró el elemento para la categoría seleccionada.");
            Assertions.fail("No se encontró la categoría: " + category);
        } catch (TimeoutException e) {
            System.out.println("Error: Tiempo de espera agotado para encontrar la categoría");
            Assertions.fail("El tiempo de espera para la categoría se agotó: " + category);
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
            Assertions.fail("Ocurrió un error inesperado al navegar a la categoría");
        }

        try {
            switch (subcategory.toLowerCase()) {
                case "men":
                    WebElement menOption = wait.until(ExpectedConditions.elementToBeClickable(MyStoreSubcategory.subcategoryMen));
                    menOption.click();
                    break;

                case "women":
                    WebElement womenOption = wait.until(ExpectedConditions.elementToBeClickable(MyStoreSubcategory.subcategoryWomen));
                    womenOption.click();
                    break;

                case "stationery":
                    WebElement stationeryOption = wait.until(ExpectedConditions.elementToBeClickable(MyStoreSubcategory.subcategoryStationery));
                    stationeryOption.click();
                    break;

                case "home accesories":
                    WebElement homeAccesoriesOption = wait.until(ExpectedConditions.elementToBeClickable(MyStoreSubcategory.subcategoryHomeAccesories));
                    homeAccesoriesOption.click();
                    break;

                default:
                    System.out.println("Error: SubCategoria no reconocida - " + category);
                    Assertions.fail("La subCategoria especificada no es válida: " + category);
            }
        } catch (NoSuchElementException e) {
            System.out.println("Error: No se encontró el elemento para la subcategoría seleccionada.");
            Assertions.fail("No se encontró la subcategoría: " + subcategory);
        } catch (TimeoutException e) {
            System.out.println("Error: Tiempo de espera agotado para encontrar la subcategoría.");
            Assertions.fail("El tiempo de espera para la subcategoría se agotó: " + subcategory);
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
            Assertions.fail("Ocurrió un error inesperado al navegar a la subcategoría.");
        }
    }

    public void addUnitsOfFirstProduct(int units) {
        WebElement selectProduct = wait.until(ExpectedConditions.elementToBeClickable(MyStoreSubcategory.selectProduct));
        selectProduct.click();

        WebElement passInputElement = driver.findElement(MyStoreProductPage.addAmountProduct);
        int necessaryClicks = units - 1;
        for (int i = 0; i < necessaryClicks; i++) {
            passInputElement.click();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    public void confirmAddProduct() {
        driver.findElement(MyStoreProductPage.addCartButton).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(MyStoreProductPage.confirmationModal));
    }

    public void validateTotalAmount() {
        WebElement unitaryPrice = driver.findElement(MyStoreProductPage.unitaryPrice);
        WebElement numberOfProducts = driver.findElement(MyStoreProductPage.productQuantity);
        WebElement finalPrice = driver.findElement(MyStoreProductPage.productTotalPrice);

        String unitaryPriceText = unitaryPrice.getText();
        String numberOfProductsText = numberOfProducts.getText();
        String finalPriceText = finalPrice.getText();

        unitaryPriceText = unitaryPriceText.replaceAll("[^0-9]", "");
        numberOfProductsText = numberOfProductsText.replaceAll("[^0-9]", "");
        finalPriceText = finalPriceText.replaceAll("[^0-9]", "");

        int unitaryPriceInt = Integer.parseInt(unitaryPriceText);
        int numberOfProductsInt = Integer.parseInt(numberOfProductsText);
        int finalPriceInt = Integer.parseInt(finalPriceText);

        if (unitaryPriceInt * numberOfProductsInt == finalPriceInt){
            System.out.println("El precio está bien calculado");
        } else {
            System.out.println("El precio está mal calculado");
            Assertions.fail("El precio está mal calculado");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    public void finishPurchase() {
        driver.findElement(MyStoreProductPage.completePurchaseBtn).click();
    }

    public void validateCarTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MyStoreCarPage.carTitle));
        String carTitle = driver.findElement(MyStoreCarPage.carTitle).getText();
        Assertions.assertEquals("CARRITO", carTitle, "El titulo coincide con el esperado");
    }

    public void validateCarAmount() {
        WebElement unitaryPrice = driver.findElement(MyStoreCarPage.unitaryPrice);
        WebElement numberOfProducts = driver.findElement(MyStoreCarPage.productQuantity);
        WebElement finalPrice = driver.findElement(MyStoreCarPage.productTotalPrice);

        String unitaryPriceText = unitaryPrice.getText();
        String numberOfProductsText = numberOfProducts.getText();
        String finalPriceText = finalPrice.getText();

        unitaryPriceText = unitaryPriceText.replaceAll("[^0-9]", "");
        numberOfProductsText = numberOfProductsText.replaceAll("[^0-9]", "");
        finalPriceText = finalPriceText.replaceAll("[^0-9]", "");

        int unitaryPriceInt = Integer.parseInt(unitaryPriceText);
        int numberOfProductsInt = Integer.parseInt(numberOfProductsText);
        int finalPriceInt = Integer.parseInt(finalPriceText);

        if (unitaryPriceInt * numberOfProductsInt == finalPriceInt){
            System.out.println("El precio está bien calculado en el carrito");
        } else {
            System.out.println("El precio está mal calculado en el carrito");
            Assertions.fail("El precio está mal calculado en el carrito");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(MyStoreCarPage.finishPurchaseBtn).click();
    }
}
