package cleaning_company;

public class Product {
	
	protected String name;
	protected String description;
	protected String specialTraetment;
	protected Customer owner;

	public Product() {
    }
	
	 public String toString() {
	 	  return "Product name: "+this.name+" \nProduct Description: "+ this.description+" \nspecial treatment: "+this.specialTraetment
	 			  +"\nCustomer: "+this.owner;
	    }
	
	public Product( String _name, String _description, Customer _owner,String _specialTraetment) {
		this();
		specialTraetment = _specialTraetment;
		name = _name;
		description = _description;
		owner = _owner;
	}
	
//	public Customer Owner(Customer owner1) {
//		owner1 = this.owner;
//		return owner;
//	}
	
	public String getName() {
		return name;
	}
}
