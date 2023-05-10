Feature: CreateOrderF2

  Scenario Outline: NewOrder Check
    Given the customeropen open add order frame
    When  customer enter <customer_id> and <name> and <desc> and <quantity> and <address> 
    Then new Order result will be <result> empty result mean order created successfully 

    Examples:
     |customer_id | name              | desc        | quantity | address      | result |
     |1 		      |"order1"           | "desc1"     | 1        | "address1"   | ""     |
     |200 		    |"order2"           | "desc2"     | 2  			 | "address2"   | "Customer not found" |
     |2 		      |""                 | "desc3"     | 3  			 | "address3"   | "name is empty"   |
     