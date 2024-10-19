package com.wcig.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AsyncService {
    // 使用@Async注解, 调用方和被调用方需为不同类
    @Async(value = "threadPoolTaskExecutor")
    public void asyncCall() {
        log.info(">> asyncCall start");
        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info(">> asyncCall end");
    }
}
