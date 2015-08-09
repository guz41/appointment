/*
 * This class is used to return all data resources required by the application.
 */
package appointment.controller;

import appointment.businessobject.customer.Customer;
import appointment.data.ObjectFactory;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Marrows
 */
@RestController
public class DataResource {
    
    @RequestMapping(value = "/customer/{CustomerID}", method = RequestMethod.GET, produces="application/json")
    public Customer getCustomer(@PathVariable long CustomerID) {
        ObjectFactory dataObjectFactory = new ObjectFactory();
        final Customer theCustomer = dataObjectFactory.getCustomer(CustomerID);

        return theCustomer;
    }
    
    @RequestMapping(value = "/customers", method = RequestMethod.GET, produces="application/json")
    public ArrayList<Customer> getCustomers() {
        ObjectFactory dataObjectFactory = new ObjectFactory();
        ArrayList<Customer> theCustomers = (ArrayList<Customer>) dataObjectFactory.getAllCustomers();
        
        return theCustomers;
    }

}
