
package cleaning_company;


public class Worker {
    int id;
    String name;
    String email;
    String password;
    String phone;
    String address;
    int numberOfOrder=0;
     

   
    public Worker() {

    }

    
    public Worker(String _email, String _password) {
            email = _email;
            password = _password;
    }
    
    @Override
    public String toString() {
       return String.format("id: %d , name : %s ,email is %s, phone : %s, address: %s",id, name, email, phone, address);
    }
    
    public String[] toArrayString() {
        String [] row = {String.valueOf(id),name,email,phone, address};
        return row;
    }
}
