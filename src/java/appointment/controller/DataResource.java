/*
 * This class is used to return all data resources required by the application.
 */
package appointment.controller;

import appointment.businessobject.customer.Customer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Marrows
 */
@RestController
public class DataResource {
    
    @RequestMapping(value = "/customer.json", method = RequestMethod.GET, produces="application/json")
    public Customer getCustomer() {
        final Customer Jack = new Customer("Jack", "Marrows", 1);

        return Jack;
    }
    

}
