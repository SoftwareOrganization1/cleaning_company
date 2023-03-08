package cleaning_company;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderTest {
	Order order;
	Worker worker;
	Customer customer;
	String address;
	ArrayList<Product> products;

	public OrderTest(Worker w) {
		worker = w;
	}

	@Given("customer adress and products")
	public void customer_adress_and_products() {
		customer = new Customer();
		address = "Ad";
		products = new ArrayList<Product>();
	}

	@When("creating new order")
	public void creating_new_order() {
		order = new Order(customer, address, products);
	}

	@Then("Order status should be waiting")
	public void order_status_should_be_waiting() {
		assertTrue(OrderStatus.WAITING == order.getStatus());
	}

	@Given("i have an order and products")
	public void i_have_an_order_and_products() {
		customer = new Customer();
		address = "Ad";
		products = new ArrayList<Product>();
		order = new Order(customer, address, products);
	}

	@When("Adding products to order")
	public void adding_products_to_order() {
		ArrayList<Product> ps = new ArrayList<Product>();		
		Product p = new Product();
		ps.add(p);
		order.setProducts(ps);
	}

	@Then("i should get the products")
	public void i_should_get_the_products() {
		ArrayList<Product> ps = order.getProducts();
		assertTrue(ps != null && ps.size() == 1);
	}

	@Given("i have an order")
	public void i_have_an_order() {
		order = new Order();
	}

	@When("Start treatment order")
	public void start_treatment_order() {
		order.startOrder(worker);
	}

	@Then("Order status should be in treatmen")
	public void order_status_should_be_in_treatmen() {
		assertTrue(order.getStatus() == OrderStatus.IN_TREATMENT);
	}

}
