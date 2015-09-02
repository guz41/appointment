/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointment.businessobject;

/**
 *
 * @author Gus
 */
/**
 * Make this data object self describing, including mapping to DB and ability to
 * list all fields (inc, characteristics) Create an interface called
 * self-describing base object, has methods that detail mapping to DB and
 * complete char lists Create an implementation of interface that extends base
 * objects (Customer Object), keep separate to allow object searliasiatiion??
 * May not matter because methods are static.
 *
 * @author Marrows
 */

import java.util.Collection;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name="customer")
public class Customer {

    @OneToMany(mappedBy = "customer", cascade = {CascadeType.ALL})
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,
                org.hibernate.annotations.CascadeType.DELETE,
                org.hibernate.annotations.CascadeType.MERGE,
                org.hibernate.annotations.CascadeType.PERSIST,
                org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
    private Collection<CustomerChar> customerCharacteristics;
    
    @Column(name = "first_name")
    private String firstName;

    public Customer(Collection<CustomerChar> customerCharacteristics, String firstName, String lastName, long ID) {
        this.customerCharacteristics = customerCharacteristics;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
    }
     @Column(name = "last_name")
    private String lastName;
    @Id @GeneratedValue
    @Column(name = "cust_id")
    private Long ID;
    
    public Customer(){
        
    }
    
    public Customer(String FirstName, String LastName, Long ID) {
        this.firstName = FirstName;
        this.lastName = LastName;

    }
    
    public Customer(String FirstName, String LastName) {
        this.firstName = FirstName;
        this.lastName = LastName;

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

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    /**
     * @return the customerCharacteristics
     */
    public Collection<CustomerChar> getCustomerCharacteristics() {
        return customerCharacteristics;
    }
    
    public void setCharPerson(){
        if (this.customerCharacteristics != null) {
            for (CustomerChar Char:this.customerCharacteristics) {
                Char.setCustomer(this);
            }
        }
    }
    /**
     * @param customerCharacteristics the customerCharacteristics to set
     */
    public void setCustomerCharacteristics(Collection<CustomerChar> customerCharacteristics) {
        this.customerCharacteristics = customerCharacteristics;
    }
}
