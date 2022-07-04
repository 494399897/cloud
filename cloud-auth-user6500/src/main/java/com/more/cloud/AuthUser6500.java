package com.more.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AuthUser6500 {
    public static void main(String[] args) {
        SpringApplication.run(AuthUser6500.class,args);
    }
}
