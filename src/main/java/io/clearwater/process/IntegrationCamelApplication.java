package io.clearwater.process;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntegrationCamelApplication
{

    public static void main( String[] args ) throws InterruptedException
    {
        SpringApplication.run( IntegrationCamelApplication.class, args );
    }
}
