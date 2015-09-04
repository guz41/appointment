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
@Table(name="business_object_field")
public class BusinessObjectField {
    //An ID is required because this will be stored in the DB
    @Id @GeneratedValue
    @Column(name = "bof_id")
    private int ID;
    
    //This is the parent business object as expressed in JS
    @Column(name = "parent_object")
    private String parentObject;
    
    //This is the name that the object would be referred to in javascript
    @Column(name = "field_name")
    private String fieldName;
    
    //This is what would be displayed at the top of table or label next to the text box
    @Column(name = "field_label")
    private String fieldLabel;
    
    //Field type is required to determine if the field should be stored in the char table or regular table
    @Column(name = "field_type")
    private FieldType fieldType;
    
    //Regex expressed as a string when displaying the field
    @Column(name = "field_validation")
    private String fieldValidation;
    
    //Message displayed to user when the field doesn't validate
    @Column(name = "field_validation_label")
    private String fieldValidationLabel;
    
    //Boolean to indicate whether the field should be displayed in the table
    @Column(name = "display_in_table")
    private Boolean displayInTable;
    
    //Boolean to indicate whether the field should be read only
    @Column(name = "read_only")
    private Boolean readOnly;
    
    public BusinessObjectField(){
        
    }
    
    public BusinessObjectField(int ID, String parentObject, String fieldName, String fieldLabel, FieldType fieldType, String fieldValidation, Boolean displayInTable, Boolean readOnly, String fieldValidationLabel) {
        this.ID = ID;
        this.parentObject = parentObject;
        this.fieldName = fieldName;
        this.fieldLabel = fieldLabel;
        this.fieldType = fieldType;
        this.fieldValidation = fieldValidation;
        this.displayInTable = displayInTable;
        this.readOnly = readOnly;
        this.fieldValidationLabel = fieldValidationLabel;
    }
    
    /**
     * @return the parentObject
     */
    public String getParentObject() {
        return parentObject;
    }


        
    /**
     * @param aParentObject the parentObject to set
     */
    public void setParentObject(String aParentObject) {
        parentObject = aParentObject;
    }
    

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the fieldName
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * @param fieldName the fieldName to set
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * @return the feildLabel
     */
    public String getFieldLabel() {
        return fieldLabel;
    }

    /**
     * @param feildLabel the feildLabel to set
     */
    public void setFieldLabel(String feildLabel) {
        this.fieldLabel = feildLabel;
    }

    /**
     * @return the fieldType
     */
    public FieldType getFieldType() {
        return fieldType;
    }

    /**
     * @param fieldType the fieldType to set
     */
    public void setFieldType(FieldType fieldType) {
        this.fieldType = fieldType;
    }

    /**
     * @return the fieldValidation
     */
    public String getFieldValidation() {
        return fieldValidation;
    }

    /**
     * @param fieldValidation the fieldValidation to set
     */
    public void setFieldValidation(String fieldValidation) {
        this.fieldValidation = fieldValidation;
    }

    /**
     * @return the displayInTable
     */
    public Boolean isDisplayInTable() {
        return displayInTable;
    }

    /**
     * @param displayInTable the displayInTable to set
     */
    public void setDisplayInTable(Boolean displayInTable) {
        this.displayInTable = displayInTable;
    }

    /**
     * @return the readOnly
     */
    public Boolean isReadOnly() {
        return readOnly;
    }

    /**
     * @param readOnly the readOnly to set
     */
    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    /**
     * @return the fieldValidationLabel
     */
    public String getFieldValidationLabel() {
        return fieldValidationLabel;
    }

    /**
     * @param fieldValidationLabel the fieldValidationLabel to set
     */
    public void setFieldValidationLabel(String fieldValidationLabel) {
        this.fieldValidationLabel = fieldValidationLabel;
    }
            
    public enum FieldType {
        BASE, CHAR
    }
    
    
    
    
    
    
}
