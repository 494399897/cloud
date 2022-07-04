package com.more.cloud.conf;


import lombok.Data;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class LogGatewayFilterFactory extends AbstractGatewayFilterFactory<LogGatewayFilterFactory.Config> {
    public LogGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("consoleLog","cacheLog");
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchage,chain) ->{
            if (config.consoleLog){
                System.out.println("console日志已开启...");
            }
            return chain.filter(exchage);
        };
    }



    @Data
    public static class Config {
        private boolean consoleLog;
    }

}
