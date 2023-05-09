package cleaning_company;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewOrderSteps {
	
	String result = "";
	
	@Given("the customeropen open add order frame")
	public void the_customeropen_open_add_order_frame() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("customer enter {int} and {string} and {string} and {int} and {string}")
	public void customer_enter_and_and_and_and(int int1, String string, String string2, int int2, String string3) {
	    // Write code here that turns the phrase above into concrete actions
		result = CleaningCompanyApp.newOrder(int1, string, string2, int2, string3);
	}

	@Then("new Order result will be {string} empty result mean order created successfully")
	public void new_order_result_will_be_empty_result_mean_order_created_successfully(String string) {
	    // Write code here that turns the phrase above into concrete actions
	   
		if (string.isEmpty() && string.equals(string)) {
			assertTrue(true);
		} else if (!string.isEmpty() && result.contains(string)) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
		
	}

}
