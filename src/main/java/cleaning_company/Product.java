
package cleaning_company;

import static cleaning_company.CleaningCompanyApp.customers;
import static cleaning_company.CleaningCompanyApp.workers;


public class Product {
    
    int id;
    int customerId;
    int workerId;
    int invoiceId;
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
            if (c.id == customerId) {
                customerName = c.name;
                break;
            }
        }
        
        for (int i = 0; i < workers.size(); i++) {
            Worker w = workers.get(i);
            if (w.id == workerId) {
                workerName = w.name;
                break;
            }
        }
    }
    
    public Product() {
        // This default constructor is intentionally left empty
    }
    
    public String[] toArrayString() {
        return new String[] {
            String.valueOf(id),
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
    }

    
    public String[] toArrayString(boolean showCustomer) {
        if (showCustomer) {
            return new String[] {
                String.valueOf(id),
                customerName,
                name,
                description,
                String.valueOf(quantity),
                workerName,
                status,
                address,
                String.valueOf(price),
                String.valueOf(deliveryCost),
                String.valueOf(discount),
                String.valueOf(totalAmount),
                isPaid ? "yes" : "No"
            };
        } else {
            return new String[] {
                String.valueOf(id),
                name,
                description,
                String.valueOf(quantity),
                workerName,
                status,
                address,
                String.valueOf(price),
                String.valueOf(deliveryCost),
                String.valueOf(discount),
                String.valueOf(totalAmount),
                isPaid ? "yes" : "No"
            };
        }
    }

    
    @Override
    public String toString() {
       return String.format("name : %s ,address is %s, status : %s",name, address, status);
    }
}
