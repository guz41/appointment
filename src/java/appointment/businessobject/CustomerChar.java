/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointment.businessobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Marrows
 */
@Entity
@Table(name="customer_char")
public class CustomerChar {
    @Column(name = "char_type")
    private String charType;
     @Column(name = "char_value")
    private String charValue;
    @Id @GeneratedValue
    @Column(name = "char_id")
    private Long ID;
    @ManyToOne
    @JoinColumn(name="cust_id")
    private Customer customer;

    public CustomerChar() {
    }

    public CustomerChar(String charType, String charValue, Long ID, Customer customer) {
        this.charType = charType;
        this.charValue = charValue;
        this.ID = ID;
        this.customer = customer;
    }

    /**
     * @return the charType
     */
    public String getCharType() {
        return charType;
    }

    /**
     * @param charType the charType to set
     */
    public void setCharType(String charType) {
        this.charType = charType;
    }

    /**
     * @return the charValue
     */
    public String getCharValue() {
        return charValue;
    }

    /**
     * @param charValue the charValue to set
     */
    public void setCharValue(String charValue) {
        this.charValue = charValue;
    }

    /**
     * @return the ID
     */
    public Long getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(Long ID) {
        this.ID = ID;
    }


    /**
     * @param customerId the customerId to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
}
