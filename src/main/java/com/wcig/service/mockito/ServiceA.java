package com.wcig.service.mockito;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ServiceA {
    @Autowired
    private ServiceB serviceB;

    public int testA() {
        log.info(">> testA");
        return serviceB.testB();
    }
}
