/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointment.data;

import appointment.businessobject.customer.Customer;

/**
 *
 * @author Marrows
 */
public class ObjectFactory {
    public ObjectFactory (){
        
    }
    
    public Customer getCustomer(long ID){
        return new Customer("Angus", "Olsen", 1);
    }
}
