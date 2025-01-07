package com.nttdata.stepsdefinitions;

import com.nttdata.steps.MyStoreStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

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
}
