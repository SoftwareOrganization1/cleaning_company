Feature: Login

  Scenario Outline: Login Check
    Given the applicatioen open
    #When user go to Login page
    When user enter <email> and <password>
    #And user enter <email> and <password>
    Then user should login as <result>

    Examples:
      | email               | password   | result   |
      | "admin@app.com"       | "12345"      | "admin"    |
      | "worker1@app.com"     | "12345"      | "worker"   |
      | "customer1@app.com"     | "12345"      | "customer" |
      | "customer1@app.com"     | "123455"      | "" |