
package cleaning_company;

import java.util.ArrayList;
import java.util.logging.Logger;

public class CleaningCompanyApp {

	private CleaningCompanyApp() {
        // Constructor implementation (if needed)
    }
	
	private static final Logger logger = Logger.getLogger(CleaningCompanyApp.class.getName());
	public static boolean userLoaded = false;
	public static ArrayList<User> users= new ArrayList<>();
	public static ArrayList<Customer> customers = new ArrayList<>();
	public static ArrayList<Worker> workers = new ArrayList<>();
	public static ArrayList<Product> products = new ArrayList<>();
	
    static String num ="123123";
    static String pal ="Palestine";
    static String phone ="0569223344";
    static String name ="name is empty";
    static String address="address is empty";
    static String email="email is empty";
    static String pass ="password is empty";
    static String phoneEmpty="phone is empty";
    static String message ="this email used by another user";
    public static final String UPDATE_ORDER_RESULT = " ";
    
	public static boolean isUserLoaded() {
	    return userLoaded;
	}

	public static void setUserLoaded(boolean loaded) {
	    userLoaded = loaded;
	}

	public static void loadUsers() {
		if (userLoaded) {
			return;
		}
		
		logger.info("Load users");
		userLoaded = true;

		User admin = new User(1, "Admin", "admin@app.com", num );
		users.add(admin);

		newCustomer("Customer 1", "customer1@app.com", num , phone , pal );
		newCustomer("Customer new ", "customer2@app.com", num , phone, pal );
		newWorker("Worker 1", "worker1@app.com", num , phone , pal );
		newWorker("Worker 2", "worker2@app.com", num , phone , pal );

	}

	public static String addMessageToString(String str, String msg) {
		String result = str;
		if (result.isEmpty()) {
			result = msg;
		} else {
			result += ",\n\r";
			result += msg;
		}
		return result;
	}

	public static String updateOrder(int orderId, String name, String desc, int quantity, String address) {

		return UPDATE_ORDER_RESULT;
	}

	public static Product paidOrder(int orderId) {
		Product prod1 = getProduct(orderId);
		if (prod1 != null && prod1.totalAmount > 0) {
			prod1.isPaid = true;
		}
		return prod1;
	}

	public static Product createInvoice(int orderId, float cleanCost, float deliveryCost) {

		Product prod1 = getProduct(orderId);

		float totalAmount = deliveryCost + cleanCost;

		if (prod1 != null) {
			prod1.price = cleanCost;
		}

		float discount = 0;

		if (prod1 != null) {
			if (prod1.quantity > 3) {
				discount = totalAmount * 0.1f;
			}
			prod1.discount = discount;
			prod1.totalAmount = totalAmount - discount;
			prod1.deliveryCost = deliveryCost;
		}


		return prod1;
	}

	public static Worker getAvaliableWorker() {

		int minOrders = products.size() + 1;
		Worker worker = null;
		for (int i = 0; i < workers.size(); i++) {
			Worker temp = workers.get(i);
			int orders = 0;
			for (int j = 0; j < products.size(); j++) {
				Product p = products.get(j);
				if (p.worker_id == temp.id && !p.status.equals("complete")) {
					orders++;
				}
			}
			if (orders < minOrders) {
				worker = temp;
				minOrders = orders;
			}
		}

		return worker;
	}

	public static String newOrder(int customerId, String name, String desc, int quantity, String address) {
		loadUsers();
		String result = "";
		boolean found = false;
		for (int i = 0; i < customers.size(); i++) {
			Customer c = customers.get(i);
			if (c.id == customerId) {
				found = true;
				break;
			}
		}

		if (!found) {
			return "Customer not found";
		}

		if (name.isEmpty()) {
			result = addMessageToString(result, CleaningCompanyApp.name);
		}
		if (desc.isEmpty()) {
			result = addMessageToString(result, "description is empty");
		}
		if (quantity <= 0) {
			result = addMessageToString(result, "quantity less than 1");
		}
		if (address.isEmpty()) {
			result = addMessageToString(result, CleaningCompanyApp.address);
		}

		if (!result.isEmpty()) {
			return result;
		}
		int lastId = 0;
		for (int i = 0; i < products.size(); i++) {
			Product p = products.get(i);
			if (p.id > lastId) {
				lastId = p.id;
			}
		}

		Product order = new Product();
		order.id = lastId + 1;
		order.customer_id = customerId;
		order.worker_id = 0;
		order.name = name;
		order.description = desc;
		order.quantity = quantity;
		order.status = "waiting";
		order.address = address;
		Worker w = getAvaliableWorker();
		if (w != null) {
			order.worker_id = w.id;
		}

		order.loadCustomer();
		products.add(order);

		return "";
	}

	public static Product getProduct(int productId) {

		Product prod = null;
		for (int i = 0; i < CleaningCompanyApp.products.size(); i++) {
			Product p1 = CleaningCompanyApp.products.get(i);
			if (p1.id == productId) {
				prod = p1;
				logger.info(" s  : " + productId);
				break;
			}
		}
		return prod;
	}

	public static Product changeOrderStatus(int orderId, String status) {

		Product prod1 = getProduct(orderId);
		if (prod1 != null) {
			prod1.status = status;
		}

		return prod1;
	}

	public static ArrayList<Product> getOrderByStatus(String status) {

		ArrayList<Product> orders = new ArrayList<>();

		for (int i = 0; i < CleaningCompanyApp.products.size(); i++) {
			Product p1 = CleaningCompanyApp.products.get(i);
			if (p1.status.equals(status)  || status.equals("all")) {
				orders.add(p1);
			}
		}
		return orders;
	}

	public static Worker getWorker(int workerId) {

		Worker wrorker = null;
		for (int i = 0; i < CleaningCompanyApp.workers.size(); i++) {
			Worker w1 = CleaningCompanyApp.workers.get(i);
			if (w1.id == workerId) {
				wrorker = w1;
				break;
			}
		}
		return wrorker;
	}

	
	public static String newWorker(String name, String email, String password, String phone, String address) {
		loadUsers();
		String result = validateFields(name, email, password, phone, address);

		if (!result.isEmpty()) {
			return result;
		}
		int last_id = 0;
		for (int i = 0; i < workers.size(); i++) {
			Worker w = workers.get(i);
			if (w.email.equals(email)) {
				result = message ;
				break;
			}
			if (w.id > last_id) {
				last_id = w.id;
			}
		}

		for (int i = 0; i < users.size(); i++) {
			User u = users.get(i);
			if (u.email.equals(email)) {
				result = message ;
				break;
			}
		}

		for (int i = 0; i < customers.size(); i++) {
			Customer c = customers.get(i);
			if (c.email.equals(email)) {
				result = message ;
				break;
			}
		}

		if (!result.isEmpty()) {
			return result;
		}
		
		Worker worker = new Worker();
		worker.id = last_id + 1;
		worker.name = name;
		worker.email = email;
		worker.password = password;
		worker.phone = phone;
		worker.address = address;
		workers.add(worker);
		
		return "";
		
	}
	
	public static String newCustomer(String name, String email, String password, String phone, String address) {
		loadUsers();
		String result = validateFields(name, email, password, phone, address);

		if (!result.isEmpty()) {
			return result;
		}
		int last_id = 0;
		for (int i = 0; i < customers.size(); i++) {
			Customer c = customers.get(i);
			if (c.email.equals(email)) {
				result = message ;
				break;
			}
			if (c.id > last_id) {
				last_id = c.id;
			}
		}

		for (int i = 0; i < users.size(); i++) {
			User u = users.get(i);
			if (u.email.equals(email)) {
				result = message ;
				break;
			}
		}

		for (int i = 0; i < workers.size(); i++) {
			Worker w = workers.get(i);
			if (w.email.equals(email)) {
				result = message ;
				break;
			}
		}
		
		if (!result.isEmpty()) {
			return result;
		}
		
		Customer customer = new Customer();
		customer.id = last_id + 1;
		customer.name = name;
		customer.email = email;
		customer.password = password;
		customer.phone = phone;
		customer.address = address;
		customers.add(customer);
		
		return "";
	}
	
	
	private static String validateFields(String name, String email, String password, String phone, String address) {
		String result = "";
		if (name.isEmpty()) {
			result = addMessageToString(result, CleaningCompanyApp.name );
		}
		if (email.isEmpty()) {
			result = addMessageToString(result, CleaningCompanyApp.email);
		}

		if (password.isEmpty()) {
			result = addMessageToString(result, pass);
		}
		if (phone.isEmpty()) {
			result = addMessageToString(result, phoneEmpty);
		}
		if (address.isEmpty()) {
			result = addMessageToString(result, CleaningCompanyApp.address);
		}

		return result;
	}
	

	public static String updateCustomer(int id, String name, String email, String password, String phone,
			String address) {
		loadUsers();
		String result = validateFields(name, email, password, phone, address);
		if (!result.isEmpty()) {
			return result;
		}
		
		int index = -1;
		result = "Customer not found";
		for (int i = 0; i < customers.size(); i++) {
			Customer c = customers.get(i);
			if (c.id == id) {
				index = i;
				result = "";
				if (!c.email.equals(email)) {
					result = "cant change email";
				}
			}
		}

		if (!result.isEmpty()) {
			return result;
		}
		customers.get(index).name = name;
		customers.get(index).password = password;
		customers.get(index).phone = phone;
		customers.get(index).address = address;

		return "";
	}

	public static Object login(String email, String password) {
		loadUsers();
		logger.info(String.format("email is %s, password is: %s", email, password));
		for (int i = 0; i < users.size(); i++) {
			User u = users.get(i);
			if (u.email.equals(email) && u.password.equals(password)) {
				return u;
			}
		}

		for (int i = 0; i < customers.size(); i++) {
			Customer c = customers.get(i);
			if (c.email.equals(email) && c.password.equals(password)) {
				return c;
			}
		}

		for (int i = 0; i < workers.size(); i++) {
			Worker w = workers.get(i);
			if (w.email.equals(email) && w.password.equals(password)) {
				return w;
			}
		}

		return null;
	}

	public static String getUserType(Object obj) {
		String str = "null";
		if (obj instanceof User) {
			str = "Admin";
		} else if (obj instanceof Customer) {
			str = "Customer";
		} else if (obj instanceof Worker) {
			str = "Worker";
		}

		return str;
	}

	public static ArrayList<StatisticItem> getStatistics() {

		ArrayList<StatisticItem> statistics = new ArrayList<>();

		
		float totalCash = 0;
		int totalPaid = 0;
		float totalDebts = 0;
		int completed = 0;

		for (int i = 0; i < products.size(); i++) {
			Product p = products.get(i);
			totalCash += p.totalAmount;
			if (p.isPaid) {
				totalPaid += p.totalAmount;
			}
			if (p.status.equals("complete")) {
				completed++;
			}
		}

		totalDebts = totalCash - totalPaid;

		statistics.add(new StatisticItem("total Cash", "" + totalCash));
		statistics.add(new StatisticItem("total Paid", "" + totalPaid));
		statistics.add(new StatisticItem("Debts", "" + totalDebts));
		statistics.add(new StatisticItem("completed Orders", "" + completed));

		return statistics;
	}
}
