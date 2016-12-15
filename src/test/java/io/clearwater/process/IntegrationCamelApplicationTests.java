package io.clearwater.process;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.NotifyBuilder;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.clearwater.process.routes.csv.CsvAgregatorRoute;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CsvAgregatorRoute.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
@EnableAutoConfiguration
public class IntegrationCamelApplicationTests
{
    private @Value("${app.input.directory}") String inputDirectory;

    @Autowired
    CamelContext camelContext;

    @Test
    public void testLoad10_000Records() throws Exception
    {
        createHeavyFile();

        // new NotifyBuilder( camelContext ).whenDone( 1 ).create();
    }

    private String createHeavyFile() throws IOException
    {
        File result = new File( inputDirectory + "/csvTest.csv" );
        FileUtils.forceMkdirParent( result );

        FileUtils.copyFile( new File( this.getClass().getResource( "/ImportTest.csv" ).getFile() ), result );

        List<String> lines = Files.readAllLines( result.toPath() );

        for ( int i = 0; i < 1_000; i++ ) {
            lines.add( lines.get( 1 ) );
        }

        FileUtils.writeStringToFile( result, "\n" + String.join( "\n", lines ), "UTF-8", false );

        return result.getAbsolutePath();

    }
}
