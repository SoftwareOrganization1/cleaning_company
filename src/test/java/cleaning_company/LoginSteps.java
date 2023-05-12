package cleaning_company;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import cleaning_company.CleaningCompanyApp;

public class LoginSteps {

	Object LoginResult = null;
	
	@Given("the applicatioen open on Login frame")
	public void the_applicatioen_open_on_login_frame() {
	    
	}

	@When("user enter {string} and {string}")
	public void user_enter_and(String string, String string2) {
	    
		
		LoginResult = CleaningCompanyApp.login(string, string2);
	}

	@Then("user should login as {string}")
	public void user_should_login_as(String string) {
	    
		String userType = CleaningCompanyApp.getUserType(LoginResult);

		if (userType.equals(string)) {
			assertTrue(true);
		} else {
			assertTrue(false);
			
		}
		
	}
	  
}
