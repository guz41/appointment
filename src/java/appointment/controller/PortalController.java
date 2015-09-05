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
        model.addObject("acustomer", new Customer("Jack", "Marrows", Long.parseLong("1")));
        
        return model;
    }
    
    @RequestMapping(value={"/customer.html"})
    public ModelAndView retrieveCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        ModelAndView model = new ModelAndView("maintainCustomer");
        model.addObject("acustomer", new Customer("Jack", "Marrows", Long.parseLong("1")));
        
        model.addObject("baseResource", "customer");
        
        ArrayList<BusinessObjectField> fields = new ArrayList();
        fields.add(new BusinessObjectField(0, "customer", "id", "ID", FieldType.BASE,"",true,true,""));
        fields.add(new BusinessObjectField(1, "customer", "firstName", "First Name", FieldType.BASE,"",true,false,""));
        fields.add(new BusinessObjectField(2, "customer", "lastName", "Last Name", FieldType.BASE,"",true,false,""));
        ArrayList<BusinessObjectField> charFields = new ArrayList();
        charFields.add(new BusinessObjectField(3, "customer_char", "phone", "Phone Number", FieldType.CHAR,"",true,false,""));
        charFields.add(new BusinessObjectField(3, "customer_char", "suburb", "Suburb", FieldType.CHAR,"",true,false,""));
        model.addObject("baseResourceFields", fields);
        model.addObject("charResourceFields", charFields);
        //Model requires a description of the object to be modified
        //Objects are broken into core fields and characteristics
        //These are all pulled from the display configuration object in the DB

        
        return model;
    }
    
    @RequestMapping(value={"/businessobjectfield.html"})
    public ModelAndView maintainBusinessObjectField(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        ModelAndView model = new ModelAndView("maintainBusinessObjectField");
        model.addObject("acustomer", new Customer("Jack", "Marrows", Long.parseLong("1")));
        
        //must match the endpoints that will be defined in DataResource for the rest requests
        model.addObject("baseResource", "businessobjectfield");
        
        //A list of all of the fields to be displayed on the table
        ObjectFactory dataObjectFactory = new ObjectFactory();
//        HashMap<String, String> fieldFilterCriteria = new HashMap<String, String>();
//        fieldFilterCriteria.put("parentObject", "businessobjectfield");
//        fieldFilterCriteria.put("fieldType", "BASE");
//        List<BusinessObjectField> fields = (List<BusinessObjectField>)(Object) dataObjectFactory.getDataResourceList(BusinessObjectField.class,fieldFilterCriteria);
        List<BusinessObjectField> fields = (List<BusinessObjectField>)(Object) dataObjectFactory.getDataResourceList(BusinessObjectField.class,"parentObject","businessobjectfield");
//        fields.add(new BusinessObjectField(0, "businessobjectfield", "id", "ID", FieldType.BASE,"",true,true,""));
//        fields.add(new BusinessObjectField(1, "businessobjectfield", "parentObject", "Parent Object", FieldType.BASE,"",true,false,""));
//        fields.add(new BusinessObjectField(2, "businessobjectfield", "fieldName", "Field Name", FieldType.BASE,"",true,false,""));
//        fields.add(new BusinessObjectField(3, "businessobjectfield", "fieldLabel", "Field Label", FieldType.BASE,"",true,false,""));
//        fields.add(new BusinessObjectField(4, "businessobjectfield", "fieldType", "Field Type", FieldType.BASE,"",true,false,""));
//        fields.add(new BusinessObjectField(5, "businessobjectfield", "fieldValidation", "Field Validation", FieldType.BASE,"",false,false,""));
//        fields.add(new BusinessObjectField(6, "businessobjectfield", "displayInTable", "Display In Table", FieldType.BASE,"",false,false,""));
//        fields.add(new BusinessObjectField(7, "businessobjectfield", "readOnly", "Read Only", FieldType.BASE,"",false,false,""));
//        fields.add(new BusinessObjectField(8, "businessobjectfield", "fieldValidationLabel", "Field Validation Label", FieldType.BASE,"",false,false,""));
//        
        
        //A list of all of the characteristics supported
        ArrayList<BusinessObjectField> charFields = new ArrayList();
        model.addObject("baseResourceFields", fields);
        model.addObject("charResourceFields", charFields);
        //Model requires a description of the object to be modified
        //Objects are broken into core fields and characteristics
        //These are all pulled from the display configuration object in the DB

        
        return model;
    }

}
