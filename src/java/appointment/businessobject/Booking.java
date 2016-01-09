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
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "booking")
public class Booking {

    //This will need to be uncommented when it is updated to have characteristics
 /*   @OneToMany(mappedBy = "booking", cascade = {CascadeType.ALL})
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,
        org.hibernate.annotations.CascadeType.DELETE,
        org.hibernate.annotations.CascadeType.MERGE,
        org.hibernate.annotations.CascadeType.PERSIST,
        org.hibernate.annotations.CascadeType.DELETE_ORPHAN})*/

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long ID;
    @Column(name = "start")
    private Long resourceName;
    @Column(name = "end")
    private Long description;
    @Column(name = "cust_id")
    private Long cust_id;

    public Booking(Long ID, Long resourceName, Long description, Long cust_id) {
        this.ID = ID;
        this.resourceName = resourceName;
        this.description = description;
        this.cust_id = cust_id;
    }
    public Booking() {

    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getResourceName() {
        return resourceName;
    }

    public void setResourceName(Long resourceName) {
        this.resourceName = resourceName;
    }

    public Long getDescription() {
        return description;
    }

    public void setDescription(Long description) {
        this.description = description;
    }

    public Long getCust_id() {
        return cust_id;
    }

    public void setCust_id(Long cust_id) {
        this.cust_id = cust_id;
    }

}
