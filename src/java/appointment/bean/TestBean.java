/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointment.bean;

import appointment.businessobject.Customer;
import appointment.data.ObjectFactory;

/**
 *
 * @author Gus
 */
public class TestBean {
   private String first_name = "No message specified";
   private String last_name = "No message specified";
   
   public String getFirst_name() {
      return(first_name);
   }
   public void setFirst_name(String first_name) {
      this.first_name = first_name;
   }   
   public String getLast_name() {
      return(last_name);
   }
   public void setLast_name(String last_name) {
      this.last_name = last_name;
   }
   
   public String commitToDb() {
       Long tempLong = new Long(3);
      Customer tempCust = new Customer(first_name ,last_name ,tempLong);
      ObjectFactory tempFactory = new ObjectFactory();
      
      //return  tempCust.getFirstName() + " " + tempCust.getLastName();
      return tempFactory.addCustomer(tempCust).getFirstName();   

   }
}
