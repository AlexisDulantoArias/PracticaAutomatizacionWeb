package com.nttdata.stepsdefinitions;

import com.nttdata.steps.SearchGoogleSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.nttdata.core.DriverManager.getDriver;

public class SearchGoogleStepdefs {

    private SearchGoogleSteps searchGoogleSteps;

    public SearchGoogleStepdefs() {
        searchGoogleSteps = new SearchGoogleSteps(getDriver());
    }

    @Given("estoy en {string}")
    public void estoyEn(String url) {
        searchGoogleSteps.entryToGoogle(url);
    }

    @When("ingreso una busqueda {string} en Google")
    public void ingresoUnaBusquedaEnGoogle(String searchText) {
        searchGoogleSteps.writeTextOnGoogle(searchText);
    }

    @Then("valido que debería aparecer la seccion de imagenes")
    public void validoQueDeberiaAparecerLaSeccionDeImagenes() {
        searchGoogleSteps.validateImagesSection();
    }
}
