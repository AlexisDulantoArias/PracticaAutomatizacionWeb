@seachGoogleTest
Feature: Busqueda en Google

  Scenario Outline: Ingreso al primer resultado que se muestre
    Given estoy en "https://www.google.com"
    When ingreso una busqueda "<textSearch>" en Google
    Then valido que debería aparecer la seccion de imagenes
    Examples:
      | textSearch                    |
      | Los mejores cantantes de rock |
      | Mejores juegos del 2024       |