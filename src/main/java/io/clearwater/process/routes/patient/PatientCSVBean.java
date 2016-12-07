package io.clearwater.process.routes.patient;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator = ",", crlf = "UNIX")
public class PatientCSVBean
{
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

}
