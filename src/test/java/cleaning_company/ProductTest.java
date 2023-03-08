package cleaning_company;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductTest {
	
	
	Customer customer;
	Product product;
	protected String category;
	protected String name;
	protected String description;
	
	
	public ProductTest(Customer c) {
		customer = c;
	}

	@Given("category {string} name {string} description {string}")
	public void category_name_description(String cat, String n, String d) {
	    name = n;
	    category = cat;
	    description = d;
	}

	@When("I create a product")
	public void i_create_a_product() {
	    product = new Product(category, name, description, customer);
	}

	@Then("I should read the name")
	public void i_should_read_the_name() {
	    assertTrue(product.getName() == name);
	}
}
