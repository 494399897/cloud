package com.more.cloud.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "cloud-payment-provider")
public interface PaymentFeignService {

    @GetMapping("/payment/index")
    String index();


    @GetMapping("/payment/timeout")
    String timeout();

}
