Feature: Login Feature

  Scenario Outline: Login is unsuccessful with invalid credentials
    When user enters username "<username>" and password "<password>"
    And click on login button
    Then user should get error message "<error>"

    Examples:
    |username         | password        | error                                                        |
    | invalidUserName | secret_sauce    | Username and password do not match any user in this service. |
    | standard_user   | invalidPassword | Username and password do not match any user in this service. |
    @test
    Scenario Outline: Login is successful with valid credentials
      When user enters username "<username>" and password "<password>"
      And click on login button
      Then user should see product page with title "<title>"

      Examples:
        | username       | password      | title    |
        | standard_user  | secret_sauce  | PRODUCTS |



