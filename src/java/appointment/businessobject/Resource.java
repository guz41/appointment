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

import java.util.Collection;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name="resource")
public class Resource {

    @OneToMany(mappedBy = "resource", cascade = {CascadeType.ALL})
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,
                org.hibernate.annotations.CascadeType.DELETE,
                org.hibernate.annotations.CascadeType.MERGE,
                org.hibernate.annotations.CascadeType.PERSIST,
                org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
    private Collection<ResourceChar> resourceCharacteristics;
    
    @Id @GeneratedValue
    @Column(name = "resource_id")
    private Long ID;
    @Column(name = "resource_name")
    private String resourceName;
    @Column(name = "description")
    private String description;
    @Column(name = "type")
    private String type;
       
    
    public Resource(){
        
    }
    
        public Resource(Collection<ResourceChar> resourceCharacteristics, String resourceName, String description, String type, long ID) {
        this.resourceCharacteristics = resourceCharacteristics;
        this.resourceName = resourceName;
        this.description = description;
        this.type = type;        
        this.ID = ID;
    }

    public Collection<ResourceChar> getResourceCharacteristics() {
        return resourceCharacteristics;
    }

    public void setResourceCharacteristics(Collection<ResourceChar> resourceCharacteristics) {
        this.resourceCharacteristics = resourceCharacteristics;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * For hibernate to know the relationship between characteristics and persons
     */
    public void setChar(){
        if (this.resourceCharacteristics != null) {
            for (ResourceChar Char:this.resourceCharacteristics) {
                Char.setResource(this);
            }
        }
    }
}
