/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointment.data;

import appointment.businessobject.customer.Customer;
import simplemysql.SimpleMySQL;
import simplemysql.SimpleMySQLResult;

/**
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
    
    public Customer addCustomer(Customer newCustomer){
        
        SimpleMySQLResult result;
        result = mysql.Query ("INSERT INTO customer (first_name, last_name) VALUES(\"" + newCustomer.getFirstName() + "\", \"" + newCustomer.getLastName() + "\"");
        
        return newCustomer;
    }
}
