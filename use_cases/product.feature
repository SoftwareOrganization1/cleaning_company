 Feature: Product

  Scenario Outline: Create Product Check
    Given the customer go to add product page
    When customer enter <category> <name> and <description>
    Then customer should read product details as <result_category> <result_name> and <result_description>

    Examples:
      | category | name                 | description        | result_category | result_name          | result_description |
      | "carpet" | "living room carpet" | "3 * 4 m red"      | "carpet"        | "living room carpet" | "3 * 4 m red"      |
      | "cover"  | "bed cover"          | "1.5 * 2 m white"  | "cover"         | "bed cover"          | "1.5 * 2 m white"  |

      
	Scenario Outline: Update Product Details Check
    Given product with <category> <name> and <description>
    When customer enter <new_category> <new_name> and <new_description>
    Then customer should read product details as <result_category> <result_name> and <result_description>

    Examples:
      | category | name                 | description        | new_category | new_name             | new_description    | result_category | result_name          | result_description |
      | "carpet" | "living room carpet" | "3 * 4 m red"      | "cover"      | "bed cover"          | "1.5 * 2 m white"  | "cover"         | "bed cover"          | "1.5 * 2 m white"  |
      | "cover"  | "bed cover"          | "1.5 * 2 m white"  | "carpet"     | "living room carpet" | "3 * 4 m red"      | "carpet"        | "living room carpet" | "3 * 4 m red"      |
      
	Scenario Outline: Delete Product Check
     Given product with <category> <name> and <description>
    When customer delete the product
    Then product should be read as null

    Examples:
      | category | name                 | description       |
      | "carpet" | "living room carpet" | "3 * 4 m red"     |
      | "cover"  | "bed cover"          | "1.5 * 2 m white" |
     