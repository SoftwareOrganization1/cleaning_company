Feature: Login

  Scenario Outline: Login Check
    Given the applicatioen open on Login frame
    When user enter <email> and <password>
    Then user should login as <result>

    Examples:
      | email               | password   | result   |
      | "admin@app.com"       | "123123"      | "Admin"    |
      | "worker1@app.com"     | "123123"      | "Worker"   |
      | "customer1@app.com"     | "123123"      | "Customer" |
      | "customer1@app.com"     | "123455"      | "" |