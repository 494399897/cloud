package com.more.cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RabbitConsumer8003 {
    public static void main(String[] args) {
        SpringApplication.run(RabbitConsumer8003.class, args);
    }
}
