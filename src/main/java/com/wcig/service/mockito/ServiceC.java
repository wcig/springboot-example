package com.wcig.service.mockito;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ServiceC {
    public int testC() {
        log.info(">> testC");
        return 0;
    }
}
