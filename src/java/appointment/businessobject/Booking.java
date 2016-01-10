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
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.*;
import org.codehaus.jackson.annotate.JsonIgnore;
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
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start")
    private Date start;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end")
    private Date end;
    @Column(name = "cust_id")
    private Long cust_id;

    public Booking(Long ID, Date start, Date end, Long cust_id) {
        this.ID = ID;
        this.start = start;
        this.end = end;
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
    
    @JsonIgnore
    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }
    
    public void setFormattedStart(String start) {
        try {
            this.start = DateFormat.getDateTimeInstance().parse(start);
        } catch (ParseException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getFormattedStart() {
        return DateFormat.getDateTimeInstance().format(start);
    }

    @JsonIgnore
    public Date getEnd() {        
        return end;
    }

    public void setEnd(Date end) {
            this.end = end;
    }

    public void setFormattedEnd(String end) {
        try {
            
            this.end = DateFormat.getDateTimeInstance().parse(end);
        } catch (ParseException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getFormattedEnd() {
        return DateFormat.getDateTimeInstance().format(end);
    }
    
    public Long getCust_id() {
        return cust_id;
    }

    public void setCust_id(Long cust_id) {
        this.cust_id = cust_id;
    }

    

}
