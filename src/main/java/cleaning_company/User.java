package cleaning_company;

public class User {
	protected int id;
	protected String name;
	protected String phone;
	protected String address;

	public User() {
		
	}
	
	public User(int _id, String _name, String _phone, String _address) {
		this();
		id = _id;
		name = _name;
		phone = _phone;
		address = _address;
	}
}
