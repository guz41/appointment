/*
 * This class is used to render all JSP/HTML that may be required from the application.
 */
package appointment.controller;

import appointment.businessobject.BusinessObjectField;
import appointment.businessobject.BusinessObjectField.FieldType;
import appointment.businessobject.Customer;
import appointment.data.ObjectFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

/**
 * Changes with Spring: 1. JSP returned is through the Portal Controller (see
 * below) 2. URL pattern is mapped to the *-servlet.xml in the web.xml file 3.
 * Servlet is also declared in the web.xml file 4. URL pattern is mapped to
 * controller in the *-servlet.xml file
 *
 * @author Marrows
 */
@Controller
public class PortalController {

    @RequestMapping(value = {"/index.html", "/"})
    public ModelAndView retrieveHome(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ModelAndView model = new ModelAndView("homePage");
        model.addObject("acustomer", new Customer("Jack", "Marrows", Long.parseLong("1")));

        return model;
    }

    @RequestMapping(value = {"/customer.html"})
    public ModelAndView retrieveCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ModelAndView model = new ModelAndView("maintainCustomer");
        model.addObject("acustomer", new Customer("Jack", "Marrows", Long.parseLong("1")));
        model.addObject("baseResource", "customer");
        model.addObject("baseResourceFields", getBusinessObjectFields(FieldType.BASE, "customer"));
        model.addObject("charResourceFields", getBusinessObjectFields(FieldType.CHAR, "customer"));
        return model;
    }

    @RequestMapping(value = {"/resource.html"})
    public ModelAndView retrieveResource(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ModelAndView model = new ModelAndView("maintainResource");
        model.addObject("acustomer", new Customer("Jack", "Marrows", Long.parseLong("1")));
        model.addObject("baseResource", "resource");
        model.addObject("baseResourceFields", getBusinessObjectFields(FieldType.BASE, "resource"));
        model.addObject("charResourceFields", getBusinessObjectFields(FieldType.CHAR, "resource"));
        return model;
    }
    
        @RequestMapping(value = {"/booking.html"})
    public ModelAndView book(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ModelAndView model = new ModelAndView("book");
        model.addObject("acustomer", new Customer("Jack", "Marrows", Long.parseLong("1")));
        model.addObject("baseResource", "booking");
        model.addObject("baseResourceFields", getBusinessObjectFields(FieldType.BASE, "booking"));
        //model.addObject("charResourceFields", getBusinessObjectFields(FieldType.CHAR, "resource"));
        return model;
    }

    @RequestMapping(value = {"/businessobjectfield.html"})
    public ModelAndView maintainBusinessObjectField(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //The view below references the view defined in definitions.xml
        ModelAndView model = new ModelAndView("maintainBusinessObjectField");

        //This customer is used by the template to display a customers name
        model.addObject("acustomer", new Customer("Jack", "Marrows", Long.parseLong("1")));

        //must match the endpoints that will be defined in DataResource for the rest requests
        model.addObject("baseResource", "businessobjectfield");

        //This is built upon the data framework and therefore the BASE and CHAR fields supported 
        //by the data object must be defined and passed to the view
        //The supported fields are stored in the DB, the steps below pull the 
        //supported fields and add them to the model used by the view
        model.addObject("baseResourceFields", getBusinessObjectFields(FieldType.BASE, "businessobjectfield"));
        model.addObject("charResourceFields", getBusinessObjectFields(FieldType.CHAR, "businessobjectfield"));

        return model;
    }

    private List<BusinessObjectField> getBusinessObjectFields(FieldType type, String baseObject) {
        ObjectFactory dataObjectFactory = new ObjectFactory();
        HashMap<String, Object> fieldFilterCriteria = new HashMap();
        fieldFilterCriteria.put("parentObject", baseObject);
        fieldFilterCriteria.put("fieldType", type);

        List<BusinessObjectField> FieldsDefinedInDB = (List<BusinessObjectField>) (Object) dataObjectFactory.getDataResourceList(BusinessObjectField.class, fieldFilterCriteria);

        return FieldsDefinedInDB;
    }
}
