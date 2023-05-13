
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

    
    public Worker(String email, String password) {
            this.email = email;
            this.password = password;
    }
    
    @Override
    public String toString() {
       return String.format("id: %d , name : %s ,email is %s, phone : %s, address: %s",id, name, email, phone, address);
    }
    
    public String[] toArrayString() {
        return new String[]{String.valueOf(id), name, email, phone, address};
    }

}
