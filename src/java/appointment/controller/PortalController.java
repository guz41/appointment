/*
 * This class is used to render all JSP/HTML that may be required from the application.
 */
package appointment.controller;

import appointment.businessobject.BusinessObjectField;
import appointment.businessobject.BusinessObjectField.FieldType;
import appointment.businessobject.Customer;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

/**
 * Changes with Spring:
 * 1. JSP returned is through the Portal Controller (see below)
 * 2. URL pattern is mapped to the *-servlet.xml in the web.xml file
 * 3. Servlet is also declared in the web.xml file
 * 4. URL pattern is mapped to controller in the *-servlet.xml file
 * @author Marrows
 */

@Controller
public class PortalController {
    @RequestMapping(value={"/index.html","/"})
    public ModelAndView retrieveHome(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        ModelAndView model = new ModelAndView("homePage");
        model.addObject("acustomer", new Customer("Jack", "Marrows", 1));
        
        return model;
    }
    
        @RequestMapping(value={"/customer.html"})
    public ModelAndView retrieveCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        ModelAndView model = new ModelAndView("maintainCustomer");
        model.addObject("acustomer", new Customer("Jack", "Marrows", 1));
        
        model.addObject("baseResource", "customer");
        
        ArrayList<BusinessObjectField> fields = new ArrayList();
        fields.add(new BusinessObjectField(0, "customer", "id", "ID", FieldType.BASE,"",true,true));
        fields.add(new BusinessObjectField(1, "customer", "firstName", "First Name", FieldType.BASE,"",true,false));
        fields.add(new BusinessObjectField(2, "customer", "lastName", "Last Name", FieldType.BASE,"",true,false));
        
        model.addObject("baseResourceFields", fields);
        
        //Model requires a description of the object to be modified
        //Objects are broken into core fields and characteristics
        //These are all pulled from the display configuration object in the DB

        
        return model;
    }

}
