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
@Table(name="resource_char")
public class ResourceChar {
    @Column(name = "char_type")
    private String charType;
     @Column(name = "char_value")
    private String charValue;
    @Id @GeneratedValue
    @Column(name = "char_id")
    private Long ID;
    @ManyToOne
    @JoinColumn(name="resource_id")
    private Resource resource;

    public ResourceChar() {
    }

    public ResourceChar(String charType, String charValue, Long ID, Resource resource) {
        this.charType = charType;
        this.charValue = charValue;
        this.ID = ID;
        this.resource = resource;
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
     * @param resourceId the resourceId to set
     */
    public void setResource(Resource resource) {
        this.resource = resource;
    }
    
}
