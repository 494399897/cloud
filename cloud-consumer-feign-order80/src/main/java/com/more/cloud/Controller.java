package com.more.cloud;

import com.more.cloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class Controller {
    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/index")
    public String get() {
        return paymentFeignService.index();
    }

    @GetMapping("/time")
    public String time() {
        return paymentFeignService.timeout();
    }
}
