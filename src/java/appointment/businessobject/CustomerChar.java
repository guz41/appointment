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
    private long ID;
//    @ManyToOne
//    @JoinColumn(name="cust_id")
    @Column(name = "cust_id")
    private long customerId;

    public CustomerChar() {
    }

    public CustomerChar(String charType, String charValue, long ID, long customerId) {
        this.charType = charType;
        this.charValue = charValue;
        this.ID = ID;
        this.customerId = customerId;
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
    public long getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(long ID) {
        this.ID = ID;
    }

    /**
     * @return the customerId
     */
    public long getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
    
}
