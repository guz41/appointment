/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointment.data;

import appointment.businessobject.customer.Customer;
import java.util.ArrayList;
import java.util.List;
import simplemysql.SimpleMySQL;
import simplemysql.SimpleMySQLResult;

/**
 *http://stackoverflow.com/questions/6272861/how-to-prevent-sql-injection-in-jsp
 * http://www.javacodegeeks.com/2012/11/sql-injection-in-java-application.html
 * 
 * @author Marrows
 */
public class ObjectFactory {
    private SimpleMySQL mysql;
    public ObjectFactory (){
        mysql = new SimpleMySQL();
        mysql.connect("52.27.193.81:3306", "sysuser", "sysuser00", "base");
    }
    
    public Customer getCustomer(long ID){
        Customer returnCustomer = null;
        
        SimpleMySQLResult result;
        result = mysql.Query ("SELECT * FROM customer WHERE cust_id = " + Long.toString(ID));

     
        while (result.next()){
            returnCustomer = new Customer(result.getString("first_name"), result.getString("last_name"), ID);
            break;
        }
        
        return returnCustomer;
    }
    
    public List<Customer> getAllCustomers(){
        ArrayList<Customer> allCustomers = new ArrayList();
        
        SimpleMySQLResult result;
        result = mysql.Query ("SELECT * FROM customer");

        while (result.next()){       
            allCustomers.add(new Customer(result.getString("first_name"), result.getString("last_name"), Long.parseLong(result.getString("cust_id"))));
        }
        
        return allCustomers;
    }
    
    public Customer addCustomer(Customer newCustomer){
        
        SimpleMySQLResult result;
        result = mysql.Query ("INSERT INTO customer (first_name, last_name) VALUES(\"" + newCustomer.getFirstName() + "\", \"" + newCustomer.getLastName() + "\"");
        return newCustomer;
    }
}
