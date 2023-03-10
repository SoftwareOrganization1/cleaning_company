package cleaning_company;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductTest {

	Product product;

	public ProductTest(Product p) {
		product = p;
	}

	@Given("the customer go to add product page")
	public void the_customer_go_to_add_product_page() {
		System.out.println("the customer go to add product page:");
	}

	@When("customer enter {string} {string} and {string}")
	public void customer_enter_product_details(String category, String name, String description) {
		System.out.printf("the customer enters product details %s %s %s\n", category, name, description);
		product.setName(name);
		product.setCategory(category);
		product.setDescription(description);
	}
	
	@Given("product with {string} {string} and {string}")
	public void product_with_details(String category, String name, String description) {
		System.out.printf("given product details with datials %s %s %s\n", category, name, description);
		product.setName(name);
		product.setCategory(category);
		product.setDescription(description);
	}
	
	@Then("customer should read product details as {string} {string} and {string}")
	public void customer_should_read_product_details_as(String category, String name, String description) {
		if (product.getName().equals(name) && product.getCategory().equals(category) && product.getDescription().equals(description)) {
			System.out.println("the customer reads the product details successfully");
			assertTrue(true);
		}
		else {
			assertTrue(false);	
		}
	}
	
	@When("customer delete the product")
	public void customer_delete_the_product() {
		System.out.println("customer delete the product");
		product = null;
	}

	@Then("product should be read as null")
	public void product_should_be_read_as_null() {
		if (product == null) {
			System.out.println("the product deleted successfully");
			assertTrue(true);
		}
		else {
			assertTrue(false);	
		}
	}


}
