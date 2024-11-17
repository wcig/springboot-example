package com.wcig.service.mockito;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ServiceB {
    @Autowired
    private ServiceC serviceC;

    public int testB() {
        log.info(">> testB");
        return serviceC.testC();
    }
}
