package cleaning_company;

import java.util.ArrayList;

public class Worker extends User {
	protected ArrayList<Order> completedOrders = new ArrayList<Order>();
	protected Order currendOrder = null;
	
	public Worker() {
		super();
		
	}
	
	public Worker(int _id, String _password, String _firstName,String _lastName, String _phone) {
			//this();
			id = _id;
			lastName= _lastName;
			firstName = _firstName;
			phone = _phone;
			password = _password;
	}
	
	
	
	public boolean setCurrentOrder(Order o) {
		if (currendOrder != null) {
			currendOrder = o;
			currendOrder.startOrder(this);
			return true;
		}
		return false;
	}
	
	public void setCompletedOrders(ArrayList<Order> _completedOrders) {
		completedOrders = _completedOrders;
	}
}
