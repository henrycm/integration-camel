package io.clearwater.process.routes.patient;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.amazonaws.services.s3.AmazonS3Client;

@Component
public class PatientImportRoute extends RouteBuilder
{
    private final static String QUEUE_NAME = "testQueue";
    private final static String BUCKET_NAME = "testBucket";

    @Override
    public void configure() throws Exception
    {
        /*
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
         */

        from( "aws-sqs://" + QUEUE_NAME + "?amazonSQSClient=#sqsClient" )
            // .filter( simple( "${header.identity} == 'login'" ) )
            // .log( "We have a message! ${body}" )
            .setBody().jsonpath( "$.Message" )
            .setHeader( "S3Key" ).jsonpath( "$.Records[*].s3.object.key" )
            .setHeader( "EventName" ).jsonpath( "$.Records[*].eventName" )
            .log( "S3Key: ${header.S3Key}, EventName: ${header.EventName}" )
            .choice()
            .when( header( "EventName" ).isEqualTo( "ObjectCreated:Put" ) )
            .bean( AmazonS3Client.class, "deleteObject( '" + BUCKET_NAME + "', ${header.S3Key} )" )
            .otherwise()
            .log( "Deleting event: ${header.S3Key}" );
    }
}
