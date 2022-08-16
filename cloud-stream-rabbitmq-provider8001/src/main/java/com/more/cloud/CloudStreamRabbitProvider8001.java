package com.more.cloud;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@Slf4j
public class CloudStreamRabbitProvider8001 {
    public static void main(String[] args) {
        SpringApplication.run(CloudStreamRabbitProvider8001.class,args);
        System.out.println("项目启动了");
    }

}
