package cleaning_company;

import java.util.ArrayList;

enum OrderStatus {
	  WAITING,
	  IN_TREATMENT,
	  COMPLETE
	}

public class Order {
	protected ArrayList<Product> products = new ArrayList<Product>();
	protected OrderStatus status;
	protected String address;
	protected Invoice invoice;
	protected Customer customer;
	protected Worker worker;
	
	public Order() {
		status = OrderStatus.WAITING;
	}
	
	public Order(Customer _customer, String _address, ArrayList<Product> _products) {
		this();
		customer = _customer;
		address = _address;
		products = _products;
	}
	
	
	public void setStatus(OrderStatus s) {
		status = s;
	}
	
	public OrderStatus getStatus() {
		return status;
	}
	
	public void setProducts(ArrayList<Product> _products) {
		products = _products;
	}
	
	public ArrayList<Product> getProducts() {
		return products;
	}
	
	public void setInvoice(Invoice i) {
		invoice = i;
	}
	
	public void setWorker(Worker w) {
		worker = w;
	}
	
	public void startOrder(Worker w) {
		worker = w;
		this.setStatus(OrderStatus.IN_TREATMENT);
	}
	
	public Customer getCustomer() {
		return customer;
	}
}
