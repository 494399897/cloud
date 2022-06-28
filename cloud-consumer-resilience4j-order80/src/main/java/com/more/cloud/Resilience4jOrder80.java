package com.more.cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Resilience4jOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(Resilience4jOrder80.class,args);
    }
}
