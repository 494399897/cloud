package com.more.cloud.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@Slf4j
public class Concumer {

    @Bean
    public Consumer<MyMessage> mybroadcast() {
        return messgae -> {
            log.info("接收到广播消息：{}", messgae.getPayload());
        };
    }

    @Bean
    public Consumer<MyMessage> myGroup() {
        return messgae -> {
            log.info("接收到分组消息：{}", messgae.getPayload());
        };
    }
}
