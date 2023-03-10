package cleaning_company;

import java.util.ArrayList;

enum OrderStatus {
	WAITING,
	IN_TREATMENT,
	DECLINED,
	COMPLETE
};

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
	
	public void startOrder(Worker w, double price) {
		worker = w;
		this.setStatus(OrderStatus.IN_TREATMENT);
		invoice = new Invoice();
		invoice.setPrice(price);
		invoice.setOrder(this);
	}
	
	public void rejectOrder() {
		this.setStatus(OrderStatus.DECLINED);
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setAddress(String address2) {
		address = address2;
	}

	public String getAddress() {
		return address;
	}
}
