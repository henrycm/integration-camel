package io.clearwater.process.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.sqs.AmazonSQSAsyncClient;

@Configuration
public class AppConfig
{

    @Bean
    AmazonSQSAsyncClient sqsClient()
    {
        return new AmazonSQSAsyncClient( new ProfileCredentialsProvider() );
    }

    @Bean
    AmazonS3Client s3Client()
    {
        return new AmazonS3Client( new ProfileCredentialsProvider() );
    }
}
