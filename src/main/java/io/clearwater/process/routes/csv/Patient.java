package io.clearwater.process.routes.csv;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@Entity
@CsvRecord(separator = ",", crlf = "UNIX")
public class Patient
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @DataField(pos = 1)
    private String externalId;

    @DataField(pos = 2)
    private String lastName;

    @DataField(pos = 3)
    private String firstName;

    @DataField(pos = 4)
    private String middleName;

    @DataField(pos = 5)
    private String gender;

    @DataField(pos = 6)
    private String dateOfBirth;

    @DataField(pos = 7)
    private String hireDate;

    @DataField(pos = 8)
    private String postalCode;

    @DataField(pos = 9)
    private String email;

    @DataField(pos = 10)
    private String lastTestDate;

    @DataField(pos = 11)
    private String cellPhone;

    public String getExternalId()
    {
        return externalId;
    }

    public void setExternalId( String externalId )
    {
        this.externalId = externalId;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName( String lastName )
    {
        this.lastName = lastName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName( String firstName )
    {
        this.firstName = firstName;
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

    public String getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth( String dateOfBirth )
    {
        this.dateOfBirth = dateOfBirth;
    }

    public String getHireDate()
    {
        return hireDate;
    }

    public void setHireDate( String hireDate )
    {
        this.hireDate = hireDate;
    }

    public String getPostalCode()
    {
        return postalCode;
    }

    public void setPostalCode( String postalCode )
    {
        this.postalCode = postalCode;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }

    public String getLastTestDate()
    {
        return lastTestDate;
    }

    public void setLastTestDate( String lastTestDate )
    {
        this.lastTestDate = lastTestDate;
    }

    public String getCellPhone()
    {
        return cellPhone;
    }

    public void setCellPhone( String cellPhone )
    {
        this.cellPhone = cellPhone;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }

}
