package io.clearwater.process.routes.patient;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PatientEntity
{
    @Id
    @GeneratedValue
    private Integer id;

    private String uuid;
    private String externalId;

    private String firstName;
    private String lastName;
    private String middleName;
    private String gender;

    private Date dateOfBirth;
    private Date hireDate;
    private Date lastTestDate;
    private String email;
    private String postalCode;
    private String cellPhone;

    private boolean toUpdate = false;

    public Integer getId()
    {
        return id;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }

    public String getUuid()
    {
        return uuid;
    }

    public void setUuid( String uuid )
    {
        this.uuid = uuid;
    }

    public String getExternalId()
    {
        return externalId;
    }

    public void setExternalId( String externalId )
    {
        this.externalId = externalId;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName( String firstName )
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName( String lastName )
    {
        this.lastName = lastName;
    }

    public String getMiddleName()
    {
        return middleName;
    }

    public void setMiddleName( String middleName )
    {
        this.middleName = middleName;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender( String gender )
    {
        this.gender = gender;
    }

    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth( Date dateOfBirth )
    {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getHireDate()
    {
        return hireDate;
    }

    public void setHireDate( Date hireDate )
    {
        this.hireDate = hireDate;
    }

    public Date getLastTestDate()
    {
        return lastTestDate;
    }

    public void setLastTestDate( Date lastTestDate )
    {
        this.lastTestDate = lastTestDate;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }

    public String getPostalCode()
    {
        return postalCode;
    }

    public void setPostalCode( String postalCode )
    {
        this.postalCode = postalCode;
    }

    public String getCellPhone()
    {
        return cellPhone;
    }

    public void setCellPhone( String cellPhone )
    {
        this.cellPhone = cellPhone;
    }

    public boolean isToUpdate()
    {
        return toUpdate;
    }

    public void setToUpdate( boolean toUpdate )
    {
        this.toUpdate = toUpdate;
    }

}
