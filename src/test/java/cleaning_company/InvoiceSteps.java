package cleaning_company;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InvoiceSteps {
	String result = "";
	float total = 0;

	@Given("customer create order and the admin open create invoice frame for created order")
	public void customer_create_order_and_the_admin_open_create_invoice_frame_for_created_order() {

		result = CleaningCompanyApp.newOrder(1, "order1", "desc1", 1, "address1");
	}

	@When("admin enter {float} and {float}")
	public void admin_enter_and(float float1, float float2) {
	   
		total = float1 + float2;
	}

	@Then("the invoice total amount will be {float}")
	public void the_invoice_total_amount_will_be(float float1) {
	    
		if (total == float1) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}
	
}
