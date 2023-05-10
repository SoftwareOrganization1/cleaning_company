/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cleaning_company;

/**
 *
 * @author Deaa
 */
public class User {
    int id;
    String name;
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
    
    public User(int _id, String _name, String _email, String _password) {
	        id = _id;
	        name = _name;
	        email = _email;
            password = _password;
    }
    
    
    @Override
    public String toString() {
       return String.format("admin name : %s ,email is %s",name, email);
    }
}
