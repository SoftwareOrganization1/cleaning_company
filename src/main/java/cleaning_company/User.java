package cleaning_company;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class User extends SignUpJFrame{
	
	protected String email;
	protected String password;
		
	//public static ArrayList<User> allUsers;
	public User() {

	}
	
	//User type is ADMIN
	public User(String _email, String _password) {
		email = _email;
		password = _password;
	}
 
}
