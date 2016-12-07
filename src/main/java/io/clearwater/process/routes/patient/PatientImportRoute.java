package io.clearwater.process.routes.patient;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.BindyType;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class PatientImportRoute extends RouteBuilder
{

    @Override
    public void configure() throws Exception
    {
        from( "file:data/inbox?noop=true" )
            .unmarshal().bindy( BindyType.Csv, Patient.class )
            .log( "After CSV" )
            .to( "jpa:Patient" )
            .log( "After JPA" )
            .to( "sql:select * from patient?dataSource=dataSource" )
            .log( "After QUERY" )
            .marshal().json( JsonLibrary.Jackson )
            .to( "stream:out" )
            .log( "Finish" );
    }
}
