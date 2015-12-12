/*
 * This class is used to return all data resources required by the application.
 */
package appointment.controller;

import appointment.businessobject.BusinessObjectField;
import appointment.businessobject.Customer;
import appointment.businessobject.CustomerChar;
import appointment.businessobject.Resource;
import appointment.businessobject.ResourceChar;
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

    @RequestMapping(value = "/customers/{CustomerID}", method = RequestMethod.GET, produces = "application/json")
    public Customer readCustomer(@PathVariable long CustomerID) {
        ObjectFactory dataObjectFactory = new ObjectFactory();
        final Customer theCustomer = (Customer) dataObjectFactory.getDataResource(Customer.class, CustomerID);

        return theCustomer;
    }

    //The method below should be updated to PUT but can't be without effort
    @RequestMapping(value = "/customers", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public Customer maintainCustomer(@RequestBody Customer customer) {
        ObjectFactory dataObjectFactory = new ObjectFactory();
        final Customer theCustomer;
        customer.setChar();
        theCustomer = (Customer) dataObjectFactory.updateDataResource(customer);

        return theCustomer;
    }

    @RequestMapping(value = "/customers/{CustomerID}", method = RequestMethod.DELETE, produces = "application/json")
    public String deleteCustomer(@PathVariable String CustomerID) {
        Long customerID = Long.parseLong(CustomerID);
        Customer cannedCustomer = readCustomer(customerID);
        ObjectFactory aFactory = new ObjectFactory();
        cannedCustomer.setCustomerCharacteristics(new ArrayList<CustomerChar>());
        aFactory.updateDataResource(cannedCustomer);
        aFactory.deleteResource(cannedCustomer);

        return CustomerID;
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET, produces = "application/json")
    public List<Customer> readCustomers() {
        ObjectFactory dataObjectFactory = new ObjectFactory();
        List<Customer> theCustomers = (List<Customer>) (Object) dataObjectFactory.getDataResourceList(Customer.class);

        return theCustomers;
    }

    @RequestMapping(value = "/resources/{ResourceID}", method = RequestMethod.GET, produces = "application/json")
    public Resource readResource(@PathVariable long ResourceID) {
        ObjectFactory dataObjectFactory = new ObjectFactory();
        final Resource theResource = (Resource) dataObjectFactory.getDataResource(Resource.class, ResourceID);

        return theResource;
    }

    //The method below should be updated to PUT but can't be without effort
    @RequestMapping(value = "/resources", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public Resource maintainResource(@RequestBody Resource resource) {
        ObjectFactory dataObjectFactory = new ObjectFactory();
        final Resource theResource;
        resource.setChar();
        theResource = (Resource) dataObjectFactory.updateDataResource(resource);

        return theResource;
    }

    @RequestMapping(value = "/resources/{ResourceID}", method = RequestMethod.DELETE, produces = "application/json")
    public String deleteResource(@PathVariable String ResourceID) {
        Long resourceID = Long.parseLong(ResourceID);
        Resource cannedResource = readResource(resourceID);
        //cannedResource.setID(resourceID);

        ObjectFactory aFactory = new ObjectFactory();
        cannedResource.setResourceCharacteristics(new ArrayList<ResourceChar>());
        aFactory.updateDataResource(cannedResource);
        aFactory.deleteResource(cannedResource);

        return ResourceID;
    }

    @RequestMapping(value = "/resources", method = RequestMethod.GET, produces = "application/json")
    public List<Resource> readResources() {
        ObjectFactory dataObjectFactory = new ObjectFactory();
        List<Resource> theResources = (List<Resource>) (Object) dataObjectFactory.getDataResourceList(Resource.class);

        return theResources;
    }

    //Rest resources for business object field data object
    //The method below should be updated to PUT but can't be without effort

    @RequestMapping(value = "/businessobjectfields", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public BusinessObjectField maintainBusinessObjectField(@RequestBody BusinessObjectField businessobjectfield) {
        ObjectFactory dataObjectFactory = new ObjectFactory();
        final BusinessObjectField theBusinessObjectField;
        theBusinessObjectField = (BusinessObjectField) dataObjectFactory.updateDataResource(businessobjectfield);

        return theBusinessObjectField;
    }

    @RequestMapping(value = "/businessobjectfields/{BusinessObjectFieldID}", method = RequestMethod.DELETE, produces = "application/json")
    public String deleteBusinessObjectField(@PathVariable String BusinessObjectFieldID) {
        Integer businessobjectfieldID = Integer.parseInt(BusinessObjectFieldID);
        BusinessObjectField cannedBusinessObject = new BusinessObjectField();
        cannedBusinessObject.setID(businessobjectfieldID);
        new ObjectFactory().deleteResource(cannedBusinessObject);

        return BusinessObjectFieldID;
    }

    @RequestMapping(value = "/businessobjectfields", method = RequestMethod.GET, produces = "application/json")
    public List<BusinessObjectField> readBusinessObjectFields() {
        ObjectFactory dataObjectFactory = new ObjectFactory();
        List<BusinessObjectField> theBusinessObjectFields = (List<BusinessObjectField>) (Object) dataObjectFactory.getDataResourceList(BusinessObjectField.class);

        return theBusinessObjectFields;
    }
}
