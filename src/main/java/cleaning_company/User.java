package cleaning_company;

import java.util.ArrayList;
import java.util.Iterator;

public class User {
	protected int id;
	protected String email;
	protected String password;
	protected String name;
	protected String phone;
	protected String address;
	protected String type = "";

	public static ArrayList<User> allUsers;
	public User() {
		id = -1;
		allUsers = new ArrayList<User>();
		allUsers.add(new User(1, "admin@app.com", "12345", "admin", "123456789", "office", "admin"));
		allUsers.add(new User(2, "customer1@app.com", "12345", "customer 1", "123456789", "customer 1 addres", "customer"));
		allUsers.add(new User(3, "worker1@app.com", "12345", "worker1", "123456789", "wroker1 address", "worker"));
		allUsers.add(new User(4, "customer2@app.com", "12345", "customer 2", "123456789", "customer 2 address", "customer"));
		
	}
	
	public User(int _id, String _email, String _password,  String _name, String _phone, String _address, String _type) {
		//this();
		id = _id;
		name = _name;
		phone = _phone;
		address = _address;
		email = _email;
		password = _password;
		type = _type;
	}

	public void login(String email, String password) {
		// TODO Auto-generated method stub
		for (int i = 0; i < allUsers.size(); i++) {
			User user1 = allUsers.get(i);
			if (user1.email.equals(email) && user1.password.equals(password)) {
				id = user1.id;
				name = user1.name;
				phone = user1.phone;
				address = user1.address;
				email = user1.email;
				password = user1.password;
				type = user1.type;
				break;
			}
		} 
	}
}
