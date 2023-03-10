 Feature: Order

  Scenario Outline: Customer Create Order
    Given products list with <category> <name> and <description>
    When customer enter <address>
    And customer create order
    Then order status should be waiting
    And order product details should be as <result_category> <result_name> and <result_description>
    And order address should be <result_address>
    

    Examples:
      | category | name                 | description        | address           | result_category | result_name          | result_description | result_address    |
      | "carpet" | "living room carpet" | "3 * 4 m red"      | "Nablus - Baita"  | "carpet"        | "living room carpet" | "3 * 4 m red"      | "Nablus - Baita"  |
      | "cover"  | "bed cover"          | "1.5 * 2 m white"  | "Nablus - awarta" | "cover"         | "bed cover"          | "1.5 * 2 m white"  | "Nablus - awarta" |
      
	Scenario Outline: Admin Accept Order
    Given order with address <address> and products list details <category> <name> <description>
    When admin enter price <price>
    And admin choose worker
    And admin accept order
    Then order status should be in treatment
    

    Examples:
      | category | name                 | description        | address           | price |
      | "carpet" | "living room carpet" | "3 * 4 m red"      | "Nablus - Baita"  | 70.5  |
      | "cover"  | "bed cover"          | "1.5 * 2 m white"  | "Nablus - awarta" | 50.5  |
      
	Scenario Outline: Admin reject Order
    Given order with address <address> and products list details <category> <name> <description>
    When admin reject order
    Then order status should be declined
    

    Examples:
      | category | name                 | description        | address           |
      | "carpet" | "living room carpet" | "3 * 4 m red"      | "Nablus - Baita"  |
      | "cover"  | "bed cover"          | "1.5 * 2 m white"  | "Nablus - awarta" |
      