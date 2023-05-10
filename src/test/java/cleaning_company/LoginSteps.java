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
	    
	    System.out.println("F1 step 1");
	}

	@When("user enter {string} and {string}")
	public void user_enter_and(String string, String string2) {
	    
		System.out.println("F1 step 2");
		
		LoginResult = CleaningCompanyApp.login(string, string2);
	}

	@Then("user should login as {string}")
	public void user_should_login_as(String string) {
	    
		System.out.println("F1 step 3");
		String userType = CleaningCompanyApp.getUserType(LoginResult);
		System.out.println(userType);
		if (userType.equals(string)) {
			assertTrue(true);
		} else {
			assertTrue(false);
			
		}
		
	}
	  
}
