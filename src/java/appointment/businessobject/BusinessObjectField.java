/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointment.businessobject;

/**
 *
 * @author Marrows
 */
public class BusinessObjectField {
    //An ID is required because this will be stored in the DB
    private int ID;
    
    //This is the parent business object as expressed in JS
    private String parentObject;
    
    //This is the name that the object would be referred to in javascript
    private String fieldName;
    
    //This is what would be displayed at the top of table or label next to the text box
    private String fieldLabel;
    
    //Field type is required to determine if the field should be stored in the char table or regular table
    private FieldType fieldType;
    
    //Regex expressed as a string when displaying the field
    private String fieldValidation;
    
    //Boolean to indicate whether the field should be displayed in the table
    private Boolean displayInTable;
    
    //Boolean to indicate whether the field should be read only
    private Boolean readOnly;
    
    public BusinessObjectField(){
        
    }
    
    public BusinessObjectField(int ID, String parentObject, String fieldName, String fieldLabel, FieldType fieldType, String fieldValidation, Boolean displayInTable, Boolean readOnly) {
        this.ID = ID;
        this.parentObject = parentObject;
        this.fieldName = fieldName;
        this.fieldLabel = fieldLabel;
        this.fieldType = fieldType;
        this.fieldValidation = fieldValidation;
        this.displayInTable = displayInTable;
        this.readOnly = readOnly;
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
    public String getFeildLabel() {
        return fieldLabel;
    }

    /**
     * @param feildLabel the feildLabel to set
     */
    public void setFeildLabel(String feildLabel) {
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
            
    public enum FieldType {
        BASE, CHAR
    }
    
    
    
    
    
    
}
