
package cleaning_company;


public class Customer {
    
    int id;
    String name;
    String email;
    String password;
    String phone;
    String address;
    
    public Customer() {

    }
    
    public Customer(String email, String password) {
           this.email = email;
            this.password = password;
    }
    
    public String[] toArrayString() {
        return new String[]{String.valueOf(id), name, email, phone, address};
    }
    
    @Override
    public String toString() {
       return String.format("name : %s ,email is %s, phone : %s, address: %s",name, email, phone, address);
    }
}
