@seachGoogleTest
Feature: Busqueda en Google

  Scenario Outline: Busqueda en Google
    Given estoy en "https://www.google.com"
    When ingreso una busqueda "<textSearch>" en Google
    Then valido que debería aparecer la seccion de imagenes
    Examples:
      | textSearch                    |
      | Los mejores cantantes de rock |
      | Mejores juegos del 2024       |


  Scenario Outline: Busqueda de vuelos
    Given estoy en el navegador "https://www.google.com"
    When ingreso el vuelo "<flightSearch>" en Google
    Then valido que deberia aparecer el titulo del widget de Google Flights
    Examples:
      | flightSearch                |
      | Vuelos de Lima a Bogota     |
      | Vuelos de Lima a Nueva York |
