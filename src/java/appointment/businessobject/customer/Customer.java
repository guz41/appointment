/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointment.businessobject.customer;

/**
 *
 * @author Gus
 */

/**
 * Make this data object self describing, including mapping to DB and ability to list all fields (inc, characteristics)
 * Create an interface called self-describing base object, has methods that detail mapping to DB and complete char lists
 * Create an implementation of interface that extends base objects (Customer Object), keep seperate to allow object searliasiatiion?? May not matter because mthods are static.
 * @author Marrows
 */
public class Customer {
     private String firstName;
    private String lastName;
    private long ID;
    
    public Customer (String FirstName,String LastName,long iD) {
        this.firstName = FirstName;
        this.lastName = LastName;
        this.ID = iD;
    }
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the ID
     */
    public long getID() {
        return ID;
    }
}
