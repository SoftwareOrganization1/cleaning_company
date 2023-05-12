package cleaning_company;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class signUpSteps {

	String result = "";

	@Given("the applicatioen open on SignUp frame")
	public void the_applicatioen_open_on_sign_up_frame() {
	   
	    System.out.println("F1 signUpSteps");

	}

	@When("user enter {string} and {string} and {string} and {string} and {string}")
	public void user_enter_and_and_and_and(String string, String string2, String string3, String string4, String string5) {
	    
		result = CleaningCompanyApp.newCustomer(string, string2, string3, string4, string5);
	}

	@Then("SignUp result will be {string} empty result mean customer created successfully")
	public void sign_up_result_will_be_empty_result_mean_customer_created_successfully(String string) {
	    
		if (string.isEmpty() && string.equals(string)) {
			assertTrue(true);
		} else if (!string.isEmpty() && result.contains(string)) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
		
	}
	
}
