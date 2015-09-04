/*
 * This class is used to return all data resources required by the application.
 */
package appointment.controller;

import appointment.businessobject.BusinessObjectField;
import appointment.businessobject.Customer;
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
        final Customer theCustomer = (Customer) dataObjectFactory.getDataResource(Customer.class, CustomerID);

        return theCustomer;
    }
    
    //The method below should be updated to PUT but can't be without effort
    @RequestMapping(value = "/customers", method = RequestMethod.POST, produces="application/json", consumes="application/json")
    public Customer maintainCustomer(@RequestBody Customer customer) {
        ObjectFactory dataObjectFactory = new ObjectFactory();
        final Customer theCustomer;
            customer.setCharPerson();
           theCustomer = (Customer) dataObjectFactory.updateDataResource(customer);

        return theCustomer;
    }
    
    @RequestMapping(value = "/customers/{CustomerID}", method = RequestMethod.DELETE, produces="application/json")
    public String deleteCustomer(@PathVariable String CustomerID) {
        Long customerID = Long.parseLong(CustomerID);
        new ObjectFactory().deleteCustomer(customerID);

        return CustomerID;
    }
    
    @RequestMapping(value = "/customers", method = RequestMethod.GET, produces="application/json")
    public List<Customer> readCustomers() {
        ObjectFactory dataObjectFactory = new ObjectFactory();
        List<Customer> theCustomers = (List<Customer>)(Object) dataObjectFactory.getDataResourceList(Customer.class);
        
        return theCustomers;
    }
    
    //Rest resources for business object field data object
    
    //for test only
        @RequestMapping(value = "/businessobjectfields/{BusinessObjectFieldID}", method = RequestMethod.GET, produces="application/json")
    public BusinessObjectField readBusinessObjectField(@PathVariable long BusinessObjectFieldID) {
        //ObjectFactory dataObjectFactory = new ObjectFactory();
        final BusinessObjectField theBusinessObjectField = (BusinessObjectField) new BusinessObjectField(0, "businessobjectfield", "id", "ID", BusinessObjectField.FieldType.BASE,"",true,true,"");

        return theBusinessObjectField;
    }
    
    //The method below should be updated to PUT but can't be without effort
    @RequestMapping(value = "/businessobjectfields", method = RequestMethod.POST, produces="application/json", consumes="application/json")
    public BusinessObjectField maintainBusinessObjectField(@RequestBody BusinessObjectField businessobjectfield) {
        ObjectFactory dataObjectFactory = new ObjectFactory();
        final BusinessObjectField theBusinessObjectField;
           theBusinessObjectField = (BusinessObjectField) dataObjectFactory.updateDataResource(businessobjectfield);

        return theBusinessObjectField;
    }
    
    @RequestMapping(value = "/businessobjectfields/{BusinessObjectFieldID}", method = RequestMethod.DELETE, produces="application/json")
    public String deleteBusinessObjectField(@PathVariable String BusinessObjectFieldID) {
        Integer businessobjectfieldID = Integer.parseInt(BusinessObjectFieldID);
        BusinessObjectField cannedBusinessObject = new BusinessObjectField();
        cannedBusinessObject.setID(businessobjectfieldID);
        new ObjectFactory().deleteResource(cannedBusinessObject);

        return BusinessObjectFieldID;
    }
    
    @RequestMapping(value = "/businessobjectfields", method = RequestMethod.GET, produces="application/json")
    public List<BusinessObjectField> readBusinessObjectFields() {
        ObjectFactory dataObjectFactory = new ObjectFactory();
        List<BusinessObjectField> theBusinessObjectFields = (List<BusinessObjectField>)(Object) dataObjectFactory.getDataResourceList(BusinessObjectField.class);
        
        return theBusinessObjectFields;
    }
}
