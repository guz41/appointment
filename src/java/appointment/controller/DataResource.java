/*
 * This class is used to return all data resources required by the application.
 */
package appointment.controller;

import appointment.businessobject.customer.Customer;
import appointment.data.ObjectFactory;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Marrows
 */
@RestController
public class DataResource {
    
    @RequestMapping(value = "/customers/{CustomerID}", method = RequestMethod.GET, produces="application/json")
    public Customer readCustomer(@PathVariable long CustomerID) {
        ObjectFactory dataObjectFactory = new ObjectFactory();
        final Customer theCustomer = dataObjectFactory.getCustomer(CustomerID);

        return theCustomer;
    }
    
    //The method below should be updated to PUT but can't be without effort
    @RequestMapping(value = "/customers", method = RequestMethod.POST, produces="application/json", consumes="application/json")
    public Customer maintainCustomer(@RequestBody Customer customer) {
        ObjectFactory dataObjectFactory = new ObjectFactory();
        final Customer theCustomer;
        if (customer.getID() == 0L) {
            theCustomer = dataObjectFactory.addCustomer(customer);
        } else {
           // theCustomer = dataObjectFactory.updateCustomer(customer);
            theCustomer = customer;
        }

        return theCustomer;
    }
    
    @RequestMapping(value = "/customers/{CustomerID}", method = RequestMethod.DELETE, produces="application/json")
    public String deleteCustomer(@PathVariable String CustomerID) {
        long customerID = Long.parseLong(CustomerID);
        new ObjectFactory().deleteCustomer(customerID);

        return CustomerID;
    }
    
    @RequestMapping(value = "/customers", method = RequestMethod.GET, produces="application/json")
    public ArrayList<Customer> readCustomers() {
        ObjectFactory dataObjectFactory = new ObjectFactory();
        ArrayList<Customer> theCustomers = (ArrayList<Customer>) dataObjectFactory.getAllCustomers();
        
        return theCustomers;
    }

}
