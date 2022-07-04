package com.more.cloud.controller;

import com.more.cloud.service.PaymentFeignService;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

@RequestMapping("/order")
@RestController
@Slf4j
public class Controller {

    @Autowired
    PaymentFeignService paymentFeignService;

    @GetMapping("/timeout")
    @TimeLimiter(name = "delay", fallbackMethod = "timeoutFallback")
    public CompletableFuture<String> timeout() {
        log.info("******进入方法*****");
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(
            () -> (paymentFeignService.timeout()));
        log.info("********离开方法*********");
        return completableFuture;
    }


    @GetMapping("/retry")
    @Retry(name = "backendA")
    public CompletableFuture<String> retry() {
        log.info("*****进入方法");
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(
            () -> paymentFeignService.index());
        log.info("*****出去方法");
        return completableFuture;
    }


    @GetMapping("/citcuitBackend")
    @CircuitBreaker(name = "backendA")
    public String citcuiBackend() {
        log.info("-----------进入方法--------");
        String index = paymentFeignService.index();
        log.info("-----------出来方法--------");
        return index;
    }


    /**
     *     * 测试信号量隔离
     *     * @return
     *    
     */
    @Bulkhead(name = "backendC", type = Bulkhead.Type.SEMAPHORE)
    @GetMapping("/bulkheac")
    public String bulkhead() throws
        InterruptedException {
        log.info("************** 进入方法 *******");
        TimeUnit.SECONDS.sleep(10);
        String index = paymentFeignService.index();
        log.info("************** 离开方法 *******");
        return index;
    }

    public CompletableFuture<String> timeoutFallback(Exception e) {
        e.printStackTrace();
        return CompletableFuture.completedFuture("超时");
    }
}
