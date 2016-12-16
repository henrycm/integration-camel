package io.clearwater.process.routes.csv;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.BindyType;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JDBCRouteSample extends RouteBuilder
{
    private @Value("${app.input.directory}") String inputDirectory;

    @Override
    public void configure() throws Exception
    {
        String insertSQL = "INSERT INTO patient (email) VALUES (:#email)";

        from( "file:" + inputDirectory )
            .log( "Init" )
            .transacted()
            .split( body().tokenize( "\n", 1, true ) ).streaming()
            .unmarshal().bindy( BindyType.Csv, Patient.class )
            // .setHeader( "email" ).simple( "${body.email}" )
            .bean( BeanUtils.class, "describe" )
            // .log( "Object: ${body}" )
            .to( "sql:" + insertSQL + "?dataSource=dataSource&batch=true" )
            .end()
            .to( "sql:select count(1) from patient?dataSource=dataSource" )
            .log( "Number of rows in database: ${body[0]}" )
            .log( "Finish" );
    }
}
