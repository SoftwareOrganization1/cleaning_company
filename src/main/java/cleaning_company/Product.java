
package cleaning_company;

import static cleaning_company.CleaningCompanyApp.customers;
import static cleaning_company.CleaningCompanyApp.workers;


public class Product {
    
    int id;
    int customer_id;
    int worker_id;
    int invoice_id;
    String status;
    String name;
    String description;
    String address;
    int quantity;
    float price = 0;
    float deliveryCost = 0;
    float discount = 0;
    float totalAmount = 0;
    boolean isPaid = false;
    
    String customerName;
    String workerName;
    
    public void loadCustomer() {
        for (int i = 0; i < customers.size(); i++) {
            Customer c = customers.get(i);
            if (c.id == customer_id) {
                customerName = c.name;
                break;
            }
        }
        
        for (int i = 0; i < workers.size(); i++) {
            Worker w = workers.get(i);
            if (w.id == worker_id) {
                workerName = w.name;
                break;
            }
        }
    }
    
    public Product() {

    }
    
    public String[] toArrayString() {
        String [] row = {String.valueOf(id),
            customerName,
            name,
            description,
            String.valueOf(quantity),
            workerName,
            status,
            address,
            String.valueOf(price),
            isPaid ? "yes" : "No"
        };
        return row;
    }
    
    public String[] toArrayString(boolean showCustomer) {
        if (showCustomer){
            String [] row = {String.valueOf(id),customerName, name,description,String.valueOf(quantity),workerName, status,
                address,
                String.valueOf(price),
                String.valueOf(deliveryCost),
                String.valueOf(discount),
                String.valueOf(totalAmount),
                isPaid ? "yes" : "No"
            };
            return row;
        }
        String [] row = {String.valueOf(id),name,description,String.valueOf(quantity),workerName, status, address,
            String.valueOf(price),
            String.valueOf(deliveryCost),
            String.valueOf(discount),
            String.valueOf(totalAmount),
            isPaid ? "yes" : "No"
        };
        return row;
    }
    
    @Override
    public String toString() {
       return String.format("name : %s ,address is %s, status : %s",name, address, status);
    }
}
