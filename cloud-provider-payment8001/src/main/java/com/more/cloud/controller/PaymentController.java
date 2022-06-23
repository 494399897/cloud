package com.more.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {


    @Autowired
    DiscoveryClient discoveryClient;


    @GetMapping(value = "/discovery")
    public Object discovery() {

        List<String> services = discoveryClient.getServices();
        for (String se : services
        ) {
            log.info("service:{}", se);
        }
        return this.discoveryClient;
    }

    @GetMapping("/index")
    public String index(){
        return "payment success";
    }


}
