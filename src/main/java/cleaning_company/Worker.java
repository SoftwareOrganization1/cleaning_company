package cleaning_company;

import java.util.ArrayList;

public class Worker extends User {
	protected ArrayList<Order> completedOrders = new ArrayList<Order>();
	protected Order currendOrder = null;
	
	public Worker() {
		super();
	}
	
	public Worker(int _id, String _name, String _phone, String _address) {
		super(_id, _name, _phone, _address);
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
