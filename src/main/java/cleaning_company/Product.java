package cleaning_company;

public class Product {
	protected String category;
	protected String name;
	protected String description;
	protected Customer customer;

	public Product() {
		
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCategory(String category2) {
		this.category = category2;
		
	}

	public void setDescription(String description2) {
		this.description = description2;
		
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}
	
	public String getDescription() {
		return description;
	}
}
