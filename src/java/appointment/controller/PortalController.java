/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointment.controller;

import appointment.businessobject.customer.Customer;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * Changes with Spring:
 * 1. JSP returned is through the Portal Controller (see below)
 * 2. URL pattern is mapped to the *-servlet.xml in the web.xml file
 * 3. Servlet is also declared in the web.xml file
 * 4. URL pattern is mapped to controller in the *-servlet.xml file
 * @author Marrows
 */

public class PortalController implements Controller {

    

    @RequestMapping("/index.html")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        ModelAndView model = new ModelAndView("index.jsp");
        model.addObject("acustomer", new Customer("Jack", "Marrows", 1));
        
        return model;
    }
    
}
