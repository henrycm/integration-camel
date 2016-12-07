package io.clearwater.process.routes.patient;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.BindyType;
import org.springframework.stereotype.Component;

@Component
public class PatientImportRoute extends RouteBuilder
{

    @Override
    public void configure() throws Exception
    {

        from( "file:data/inbox?noop=true" )
            .unmarshal().bindy( BindyType.Csv, PatientCSVBean.class )
            .log( "After converting bean" );
    }

}
