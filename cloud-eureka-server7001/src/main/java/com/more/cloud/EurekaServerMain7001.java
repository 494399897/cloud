package com.more.cloud;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@Slf4j
@EnableEurekaServer
public class EurekaServerMain7001 {

    public static void main(String[] args) {
           SpringApplication.run(EurekaServerMain7001.class,args);
           log.info("******服务启动成功*****");
    }
}
