package com.more.cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RabbitConsumer8002 {
    public static void main(String[] args) {
        SpringApplication.run(RabbitConsumer8002.class, args);
    }
}
