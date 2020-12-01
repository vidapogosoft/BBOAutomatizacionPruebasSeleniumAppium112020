Feature: Funcionalidad de login page
  Scenario Outline: Verificacion de ingreso de credenciales
    Given Abre el web browser Chrome y direcciona a la aplicacion
    When Ingresa el username <username> y password <password>
    Then Estamos en la pagina principal
    And Cierro web browser

    Examples:
      | username | password |
      | user1    | pwd1     |
      | user2    | pwd      |
      | demo     | 0430     |