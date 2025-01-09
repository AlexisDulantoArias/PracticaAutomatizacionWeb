package com.nttdata.stepsdefinitions;

import com.nttdata.steps.MyStoreStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.nttdata.core.DriverManager.getDriver;

public class MyStoreStepdefs {

    private MyStoreStep myStoreStep;

    public MyStoreStepdefs() {
        myStoreStep = new MyStoreStep(getDriver());
    }

    @Given("estoy en la página de la tienda")
    public void estoyEnLaPaginaDeLaTienda() {
        myStoreStep.navigateToTheWebpage();
    }

    @And("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String username, String password) {
        myStoreStep.loginWithUsernameAndPassword(username, password);
    }

    @When("cambio el tipo de moneda a {string}")
    public void cambioElTipoDeMonedaA(String currency) {
        myStoreStep.currencyExchange(currency);
    }

    @And("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String category, String subcategory) {
        myStoreStep.navigateToCategoryAndSubcategory(category, subcategory);
    }

    @And("agrego {} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int units) {
        myStoreStep.addUnitsOfFirstProduct(units);
    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmacionDelProductoAgregado() {
        myStoreStep.confirmAddProduct();
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        myStoreStep.validateTotalAmount();
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        myStoreStep.finishPurchase();
    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        myStoreStep.validateCarTitle();
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        myStoreStep.validateCarAmount();
    }
}
