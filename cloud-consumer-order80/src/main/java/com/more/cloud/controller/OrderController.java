package com.more.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequestMapping("/order")
@Slf4j
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/index")
    public String index() {
        String hostName = "CLOUD-PAYMENT-PROVIDER";
        String url = "/payment/index";
        List<ServiceInstance> list = discoveryClient.getInstances(hostName);
        ServiceInstance serviceInstance = list.get(0);
        System.out.println(serviceInstance.getUri());
        System.out.println(serviceInstance.getUri()+url);
        String re = restTemplate.getForObject(serviceInstance.getUri() + url, String.class);
        System.out.println(re);
        return re;
    }
}
