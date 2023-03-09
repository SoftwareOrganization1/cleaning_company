package cleaning_company;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	User user;
	
	public LoginSteps(User u) {
		user = u;	
	}
	@Given("the applicatioen open")
	public void the_applicatioen_open() {
	   System.out.println("application is open::");
	}

	@When("user enter {string} and {string}")
	public void user_enter_email_and_password(String email, String password) {
		System.out.println("user enter pp email");
		user.login(email, password);
		if(user.id != -1) {
			System.out.println("user login success" + user.id);
		}
		
	}

	@Then("user should login as {string}")
	public void user_should_login_as_admin(String result) {
		assertTrue(user.type.equals(result));
	}

}
