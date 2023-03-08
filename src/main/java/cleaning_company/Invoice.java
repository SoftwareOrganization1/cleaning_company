package cleaning_company;

public class Invoice {
	protected Order order;
	protected double price = 0.0;
	protected double discount = 0.0;
	
	public Invoice () {
		
	}
	
	public void setOrder(Order o) {
		order = o;
	}
	
	public void setPrice(double p) {
		price = p;
	}
	
	public double calculateDiscount() {
		discount = price * 0.1;
		return discount;
	}
	
	public Customer getCustomer() {
		return order.getCustomer();
	}
	
	public double getFinalPrice() {
		return price - discount;
	}

}
