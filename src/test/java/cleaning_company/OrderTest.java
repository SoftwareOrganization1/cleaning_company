package cleaning_company;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderTest {
	Worker worker;
	Order order;
	String address;
	ArrayList<Product> products = new ArrayList<Product>();
	double price;
	
	public OrderTest(Order o) {
		order = o;
	}
	
	@Given("products list with {string} {string} and {string}")
	public void products_list_with_details(String category, String name, String description) {
		System.out.printf("given product details with datials %s %s %s\n", category, name, description);
		Product product = new Product();
		product.setName(name);
		product.setCategory(category);
		product.setDescription(description);
		products.add(product);
	}

	@When("customer enter {string}")
	public void customer_enter_address(String address) {
		System.out.println("the customer enters address");
		this.address = address;
	}

	@When("customer create order")
	public void customer_create_order() {
		System.out.println("the customer creates order");
		order.setProducts(products);
		order.setAddress(address);
	}

	@Then("order address should be {string}")
	public void order_address_should_be(String address) {
		if (order.getAddress().equals(address)) {
			System.out.println("order address is correct");
			assertTrue(true);
		}
		else {
			assertTrue(false);
		}
	}

	@Then("order status should be waiting")
	public void order_status_should_be_waiting() {
		if (order.getStatus() == OrderStatus.WAITING) {
			System.out.println("order status is waiting");
			assertTrue(true);
		}
		else {
			assertTrue(false);
		}
	}

	@Then("order product details should be as {string} {string} and {string}")
	public void order_product_details_should_be_as_and(String category, String name, String description) {
	    Product p = order.getProducts().get(0);
	    if (p.getName().equals(name) && p.getCategory().equals(category) && p.getDescription().equals(description)) {
			System.out.println("order product details are correct");
			assertTrue(true);
		}
		else {
			assertTrue(false);	
		}
	}
	
	@Given("order with address {string} and products list details {string} {string} {string}")
	public void order_with_address_and_products_list_details(String address, String category, String name, String description) {
		System.out.println("given order");
		products.clear();
		Product product = new Product();
		product.setName(name);
		product.setCategory(category);
		product.setDescription(description);
		products.add(product);
		
		order.setAddress(address);
		order.setProducts(products);;
	}

	@When("admin enter price {double}")
	public void admin_enter_price(Double double1) {
		System.out.println("admin enter price");
	    price = double1;
	}

	@When("admin choose worker")
	public void admin_choose_worker() {
		System.out.println("admin choose worker");
		worker = new Worker();
	}


	@When("admin accept order")
	public void admin_accept_order() {
		System.out.println("admin accept order");
	    order.startOrder(worker, price);
	}

	@Then("order status should be in treatment")
	public void order_status_should_be_in_treatment() {
		if (order.getStatus() == OrderStatus.IN_TREATMENT) {
			System.out.println("order status is in treatment");
			assertTrue(true);
		}
		else {
			assertTrue(false);
		}
	}
	
	
	
	@When("admin reject order")
	public void admin_reject_order() {
		System.out.println("admin reject order");
		order.rejectOrder();
	}
	
	@Then("order status should be declined")
	public void order_status_should_be_declined() {
		if (order.getStatus() == OrderStatus.DECLINED) {
			System.out.println("order status is declined");
			assertTrue(true);
		}
		else {
			assertTrue(false);
		}
	}

}
