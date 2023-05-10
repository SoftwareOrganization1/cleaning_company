Feature: SignUp f1

  Scenario Outline: SignUp Check
    Given the applicatioen open on SignUp frame
    When user enter <name> and <email> and <password> and <phone> and <address> 
    Then SignUp result will be <result> empty result mean customer created successfully 

    Examples:
     |name    		| email                | password    | phone         | address  | result |
     |"user1" 		| "user1@app.com"      | "123123"    | "0592772194"  | "nablus" | ""     |
     |"user2" 		|  "user2@app.com"     | ""          | "0595280749"  | "awarta" | "password is empty"     |
     |""          |  "user3@app.com"     | "123123"    | "0598046816"  |"odala"   | "name is empty"     |
     |"Customer1" |  "customer1@app.com" | "123123"    | "0598046816"  |"odala"   | "this email used by another user"|
     
      