package io.clearwater.process.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.BindyType;
import org.springframework.stereotype.Component;

import io.clearwater.process.routes.patient.PatientCSVBean;

@Component
public class PatientImportRoute extends RouteBuilder
{

    @Override
    public void configure() throws Exception
    {
        from( "file:data/inbox?noop=true" ).marshal().bindy( BindyType.Csv, PatientCSVBean.class )
            .log( "After converting bean" )
            .to( "log:bean?level=INFO&showAll=true" );
    }

}
