package com.nttdata.stepsdefinitions;

import com.nttdata.steps.FlightSearchSteps;
import com.nttdata.steps.SearchGoogleSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.nttdata.core.DriverManager.getDriver;

public class FlightSearchStepdefs {

    private FlightSearchSteps flightSearchSteps;

    public FlightSearchStepdefs() {
        flightSearchSteps = new FlightSearchSteps(getDriver());
    }

    @Given("estoy en el navegador {string}")
    public void estoyEnElNavegador(String url) {
        flightSearchSteps.entryToGoogle(url);
    }

    @When("ingreso el vuelo {string} en Google")
    public void ingresoElVueloEnGoogle(String flightSearch) {
        flightSearchSteps.writeTextOnGoogle(flightSearch);
    }

    @Then("valido que deberia aparecer el titulo del widget de Google Flights")
    public void validoQueDeberiaAparecerElTituloDelWidgetDeGoogleFlights() {
        flightSearchSteps.validateWidgetGoogleFlights();
    }
}
