
Feature: invoice 


  Scenario: create invoice
 		Given customer create order and the admin open create invoice frame for created order
    When  admin enter <cleanCost> and <deliveryCost>
    Then the invoice total amount will be <result> 

    Examples:
     | cleanCost |deliveryCost| result |
     |50         |5           | 55     |
     |70         |0           | 70  	 |
     |100        |10          | 110  	 |
     
