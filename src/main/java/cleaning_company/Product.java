package cleaning_company;

public class Product {
	protected String category;
	protected String name;
	protected String description;
	protected Customer customer;

	public Product() {
		
	}
	
	public Product(String _category, String _name, String _description, Customer _customer) {
		this();
		category = _category;
		name = _name;
		description = _description;
		customer = _customer;
	}
	
	public String getName() {
		return name;
	}
}
