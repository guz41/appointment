/*
 * This class is used to render all JSP/HTML that may be required from the application.
 */
package appointment.controller;

import appointment.businessobject.customer.Customer;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
            
        ModelAndView model = new ModelAndView("/jsp/home.jsp");
        model.addObject("acustomer", new Customer("Jack", "Marrows", 1));
        
        return model;
    }
    
        @RequestMapping(value={"/customer.html"})
    public ModelAndView retrieveCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        ModelAndView model = new ModelAndView("/jsp/customer.jsp");
        model.addObject("acustomer", new Customer("Jack", "Marrows", 1));
        
        return model;
    }

}
