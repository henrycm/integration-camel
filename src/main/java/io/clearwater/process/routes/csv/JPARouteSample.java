package io.clearwater.process.routes.csv;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.BindyType;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class JPARouteSample extends RouteBuilder
{
    private @Value("${app.input.directory}") String inputDirectory;

    @Override
    public void configure() throws Exception
    {
        from( "file:" + inputDirectory )
            .log( "Init" )
            // .transacted()
            .split( body().tokenize( "\n", 1, true ) ).streaming().parallelProcessing()
            .unmarshal().bindy( BindyType.Csv, Patient.class )
            .to( "jpa:Patient" )
            .end()
            .to( "sql:select count(1) from patient?dataSource=dataSource" )
            .marshal().json( JsonLibrary.Jackson )
            .log( "Number of rows in database: ${body}" )
            .log( "Finish" );
    }

}
