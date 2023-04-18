package cleaning_company;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Customer extends User {
	
	protected String firstName;
	protected String lastName;
	protected String phone;
	protected String address;
	public static ArrayList<Customer> allCustomers
	= new ArrayList<Customer>();
	
	
	public Customer() {
		//super();
		allCustomers = new ArrayList<Customer>();
		
		}
	 
	 public String toString() {
			return "name: "+this.firstName + " "+this.lastName+" \nemail:"+this.email +"\nphone: "+this.phone +"\naddress: "+this.address;
    }
	
	public Customer(String _firstName, String _lastName, String _email, String _password) {
		lastName= _lastName;
		firstName = _firstName;
    	email = _email;
		password = _password;
		
	}
	
	 public Customer getCustomer() {
		 Customer customer = new Customer();
		 customer.firstName = this.firstName;
		 customer.lastName = this.lastName;
		 customer.email = this.email;
		 customer.address = this.address;
	     customer.phone = this.phone;
			return this;
	    }
	 
	 
		public void login(String email, String password) {
			for(Customer customer: allCustomers) {
				if (customer.email.equals(email) && customer.password.equals(password)) {
					System.out.println("all is Good");
					//Customer customer = new Customer();
					
					String name = customer.firstName+customer.lastName;
					phone = customer.phone;
					address = customer.address;
					email = customer.email;
					password = customer.password;
					
					getCustomer();
					
					  AddProductFrame product = new AddProductFrame();
					   product.show();
					break;
				}
				
				else
					JOptionPane.showMessageDialog(null," Email or password is uncorrect!" );
			}
		}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
