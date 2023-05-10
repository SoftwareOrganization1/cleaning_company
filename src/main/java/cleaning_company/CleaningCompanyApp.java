/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cleaning_company;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class CleaningCompanyApp {
    
    public static boolean userLoaded = false;
    public static ArrayList<User> users;
    public static ArrayList<Customer> customers;
    public static ArrayList<Worker> workers;
    public static ArrayList<Product> products;
    
    public static void loadUsers() {
        if (userLoaded) {
            return;
        }
        System.out.println(String.format("Load users"));
        users = new ArrayList<>();
        customers = new ArrayList<>();
        workers = new ArrayList<>();
        products = new ArrayList<>();
        userLoaded = true;
        
        User admin = new User();
        admin.id = 1;
        admin.name = "Admin";
        admin.email = "admin@app.com";
        admin.password = "123123";
        users.add(admin);
        
        newCustomer("Customer 1", "customer1@app.com", "123123","0569223344","Palestine");
        newCustomer("Customer new ", "customer2@app.com", "123123","0569223344","Palestine");
        newWorker("Worker 1", "worker1@app.com", "123123","0569223344","Palestine");
        newWorker("Worker 2", "worker2@app.com", "123123","0569223344","Palestine");
        
    }
    
    public static String addMessageToString(String  str, String msg) {
        String result = str;
        if (result.isEmpty()) {
           result = msg;
        } else {
           result += ",\n\r"; 
           result += msg;
        }
        return result;
    }
    
    public static String updateOrder(int order_id,String name,String desc,int quantity , String address) {

        return "";
    }
    
    
    
    public static Product paidOrder(int order_id) {
        Product prod1 = getProduct(order_id);
        if (prod1.totalAmount > 0) {
            prod1.isPaid = true;
        }
        return prod1; 
    }
    
    public static Product createInvoice(int order_id,float cleanCost,float deliveryCost) {

        Product prod1 = getProduct(order_id);
        
        float totalAmount = deliveryCost + cleanCost;
        prod1.price = cleanCost;
        float discount = 0;
        if (prod1.quantity > 3) {
            discount = totalAmount * 0.1f;
        }
        prod1.discount = discount;
        prod1.totalAmount = totalAmount - discount;
        prod1.deliveryCost = deliveryCost;
                
//        for (int i = 0; i < CleaningCompanyApp.products.size(); i++) {
//            Product temp = CleaningCompanyApp.products.get(i);
//            if (temp.id == prod1.id) {
//                temp.price = cleanCost;
//                float discount = 0;
//                if (temp.quantity > 3) {
//                    discount = totalAmount * 0.1f;
//                }
//                temp.discount = discount;
//                temp.totalAmount = totalAmount - discount;
//                temp.deliveryCost = deliveryCost;
//                break;
//            }
//        }
        return prod1;
    }
    
    
    
    public static Worker getAvaliableWorker() {
        
        int minOrders = products.size() +1;
        Worker worker = null;
        for (int i = 0; i < workers.size(); i++) {
            Worker temp = workers.get(i);
            int orders = 0;
            for (int j = 0; j < products.size(); j++) {
                Product p = products.get(j);
                if (p.worker_id == temp.id && !p.status.equals("complete")) {
                   orders++;
                }
            }
            if (orders < minOrders) {
                worker = temp;
                minOrders = orders; 
            }
        }
        
        return worker;
    }
    
    public static String newOrder(int customer_id,String name,String desc,int quantity , String address) {
        loadUsers();
        String result = "";
        boolean found = false;
        for (int i = 0; i < customers.size(); i++) {
            Customer c = customers.get(i);
            if (c.id == customer_id) {
                found = true;
                break;
            }
        }
        
        if (!found) {
            return "Customer not found";
        }
        
        if (name.isEmpty()) {
            result = addMessageToString(result, "name is empty");
        }
        if (desc.isEmpty()) {
            result = addMessageToString(result, "description is empty");
        }
        if (quantity <= 0 ) {
            result = addMessageToString(result, "quantity less than 1");
        }
        if (address.isEmpty()) {
            result = addMessageToString(result, "address is empty");
        }
        
        if (!result.isEmpty()) {
            return result;
        }
        int last_id = 0;
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            if (p.id > last_id) {
                last_id = p.id;
            }
        }
        
        Product order = new Product();
        order.id = last_id+1;
        order.customer_id = customer_id;
        order.worker_id = 0;
        order.name = name;
        order.description = desc;
        order.quantity = quantity;
        order.status = "waiting";
        order.address = address;
        Worker w = getAvaliableWorker();
        if (w != null) {
           order.worker_id = w.id; 
        }
                
        order.loadCustomer();
        products.add(order);
        
        return "";
    }
    
    
    public static Product getProduct(int product_id) {
        
        Product prod = null;
        for (int i = 0; i < CleaningCompanyApp.products.size(); i++) {
            Product p1 = CleaningCompanyApp.products.get(i);
            if (p1.id == product_id){
                prod = p1;
                System.out.println(" s  : " + product_id);
                break;
            }
        }
        return prod;
    }
    
    public static Product changeOrderStatus(int order_id,String status) {
        
        Product prod1 = getProduct(order_id);
        prod1.status = status;
        
        return prod1;
    }
            
    public static ArrayList<Product> getOrderByStatus(String status) {
        
        ArrayList<Product> orders = new ArrayList<>();
        
        for (int i = 0; i < CleaningCompanyApp.products.size(); i++) {
            Product p1 = CleaningCompanyApp.products.get(i);
            if (p1.status == status || status == "all"){
                orders.add(p1);
            }
        }
        return orders;
    }
    
    public static Worker getWorker(int worker_id) {
        
        Worker wrorker = null;
        for (int i = 0; i < CleaningCompanyApp.workers.size(); i++) {
            Worker w1 = CleaningCompanyApp.workers.get(i);
            if (w1.id == worker_id){
                wrorker = w1;
                break;
            }
        }
        return wrorker;
    }
    
    public static String newWorker(String name,String email, String password, String phone, String address) {
        loadUsers();
        String result = "";
        if (name.isEmpty()) {
            result = addMessageToString(result, "name is empty");
        }
        if (email.isEmpty()) {
            result = addMessageToString(result, "email is empty");
        }
        
        if (password.isEmpty()) {
            result = addMessageToString(result, "password is empty");
        }
        if (phone.isEmpty()) {
            result = addMessageToString(result, "phone is empty");
        }
        if (address.isEmpty()) {
            result = addMessageToString(result, "address is empty");
        }
        
        if (!result.isEmpty()) {
            return result;
        }
        int last_id = 0;
        for (int i = 0; i < workers.size(); i++) {
            Worker w = workers.get(i);
            if (w.email.equals(email)) {
                result = "this email used by another user";
                break;
            }
            if (w.id > last_id) {
                last_id = w.id;
            }
        }
        
        for (int i = 0; i < users.size(); i++) {
            User u = users.get(i);
            if (u.email.equals(email)) {
                result = "this email used by another user";
                break;
            }
        }
        
        for (int i = 0; i < customers.size(); i++) {
            Customer c = customers.get(i);
            if (c.email.equals(email)) {
                result = "this email used by another user";
                break;
            }
        }
        
        if (!result.isEmpty()) {
            return result;
        }
        
        Worker worker = new Worker();
        worker.id = last_id+1;
        worker.name = name;
        worker.email = email;
        worker.password = password;
        worker.phone = phone;
        worker.address = address;
        workers.add(worker);
        
        return "";
    }
    
    public static String newCustomer(String name,String email, String password, String phone, String address) {
        loadUsers();
        String result = "";
        if (name.isEmpty()) {
            result = addMessageToString(result, "name is empty");
        }
        if (email.isEmpty()) {
            result = addMessageToString(result, "email is empty");
        }
        
        if (password.isEmpty()) {
            result = addMessageToString(result, "password is empty");
        }
        if (phone.isEmpty()) {
            result = addMessageToString(result, "phone is empty");
        }
        if (address.isEmpty()) {
            result = addMessageToString(result, "address is empty");
        }
        
        if (!result.isEmpty()) {
            return result;
        }
        int last_id = 0;
        for (int i = 0; i < customers.size(); i++) {
            Customer c = customers.get(i);
            if (c.email.equals(email)) {
                result = "this email used by another user";
                break;
            }
            if (c.id > last_id) {
                last_id = c.id;
            }
        }
        
        for (int i = 0; i < users.size(); i++) {
            User u = users.get(i);
            if (u.email.equals(email)) {
                result = "this email used by another user";
                break;
            }
        }
        
        for (int i = 0; i < workers.size(); i++) {
            Worker w = workers.get(i);
            if (w.email.equals(email)) {
                result = "this email used by another user";
                break;
            }
        }
        
        if (!result.isEmpty()) {
            return result;
        }
        
        Customer customer = new Customer();
        customer.id = last_id+1;
        customer.name = name;
        customer.email = email;
        customer.password = password;
        customer.phone = phone;
        customer.address = address;
        customers.add(customer);
        
        return "";
    }
    
    public static String updateCustomer(int id,String name,String email, String password, String phone, String address) {
        loadUsers();
        String result = "";
        if (name.isEmpty()) {
            result = addMessageToString(result, "name is empty");
        }
        if (email.isEmpty()) {
            result = addMessageToString(result, "email is empty");
        }
        
        if (password.isEmpty()) {
            result = addMessageToString(result, "password is empty");
        }
        if (phone.isEmpty()) {
            result = addMessageToString(result, "phone is empty");
        }
        if (address.isEmpty()) {
            result = addMessageToString(result, "address is empty");
        }
        
        if (!result.isEmpty()) {
            return result;
        }
        int last_id = 0;
        int index = -1;
        result = "Customer not found";
        for (int i = 0; i < customers.size(); i++) {
            Customer c = customers.get(i);
            if (c.id == id) {
                index = i;
                result = "";
                if (!c.email.equals(email)) {
                   result = "cant change email";
                }
            } 
        }
        
        if (!result.isEmpty()) {
            return result;
        }
        customers.get(index).name = name;
        customers.get(index).password = password;
        customers.get(index).phone = phone;
        customers.get(index).address = address;
        
        return "";
    }
    
    public static Object login(String email, String password) {
        loadUsers();
        System.out.println(String.format("email is %s, password is : %s",email, password));
        for (int i = 0; i < users.size(); i++) {
              User u = users.get(i);
              if (u.email.equals(email) &&  u.password.equals(password)) {
                  return u;
              }
        }
        
        for (int i = 0; i < customers.size(); i++) {
              Customer c = customers.get(i);
              if (c.email.equals(email) &&  c.password.equals(password)) {
                  return c;
              }
        }
        
        for (int i = 0; i < workers.size(); i++) {
              Worker w = workers.get(i);
              if (w.email.equals(email) &&  w.password.equals(password)) {
                  return w;
              }
        }
        
        return null;
    }
    
    public static String getUserType (Object obj) {
        String str = "";
        if (obj instanceof User) {
            str = "Admin";
        } else if (obj instanceof Customer) {
            str = "Customer";
        } else if (obj instanceof Worker) {
            str = "Worker";
        }
        
        return str;
    }
    
    public static ArrayList<StatisticItem> getStatistics () {
        
        ArrayList<StatisticItem> statistics = new ArrayList<>();

        // total cash 
        float totalCash = 0;
        int totalPaid = 0;
        float totalDebts = 0;
        int completed = 0;
                
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            totalCash +=  p.totalAmount;
            if (p.isPaid) {
               totalPaid +=  p.totalAmount;
            }
            if (p.status.equals("complete")) {
               completed ++;
            }
        }
        
        totalDebts = totalCash - totalPaid;
        
        statistics.add(new StatisticItem("total Cash", ""+totalCash));
        statistics.add(new StatisticItem("total Paid", ""+totalPaid));
        statistics.add(new StatisticItem("Debts", ""+totalDebts));
        statistics.add(new StatisticItem("completed Orders", ""+completed));
        
        return statistics;
    }
}
