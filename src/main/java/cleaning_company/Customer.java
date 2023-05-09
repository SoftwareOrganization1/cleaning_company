/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cleaning_company;

/**
 *
 * @author Deaa
 */
public class Customer {
    
    int id;
    String name;
    String email;
    String password;
    String phone;
    String address;
    
    public Customer() {

    }
    
    public Customer(String _email, String _password) {
            email = _email;
            password = _password;
    }
    
    public String[] toArrayString() {
        String [] row = {String.valueOf(id),name,email,phone, address};
        return row;
    }
    
    @Override
    public String toString() {
       return String.format("name : %s ,email is %s, phone : %s, address: %s",name, email, phone, address);
    }
}
