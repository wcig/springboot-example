package com.wcig.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HealthService {
    @Resource
    private AsyncService asyncService;

    @Resource(name = "threadPoolTaskExecutor")
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    public void check() {
        log.info(">> check start");
        asyncCall();
        asyncService.asyncCall();
        log.info(">> check end");
    }

    public void asyncCall() {
        // 使用注入ThreadPoolTaskExecutor变量方式, 调用方和被调用方可以为同一个类
        threadPoolTaskExecutor.execute(() -> {
            log.info(">> asyncCall start");
            try {
                Thread.sleep(3 * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info(">> asyncCall end");
        });
    }
}
