
package cleaning_company;


public class User {
    int id;
    String name;
    protected String email;
    protected String password;

    
    public User() {

    }

    
    public User(String email, String password) {
           this.email = email;
            this.password = password;
    }
    
    public User(int id, String name, String email, String password) {
	        this.id = id;
	        this.name = name;
	        this.email = email;
            this.password = password;
    }
    
    
    @Override
    public String toString() {
       return String.format("admin name : %s ,email is %s",name, email);
    }
}
