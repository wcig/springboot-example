package com.wcig.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HealthController {

    @RequestMapping(value = "/live", method = RequestMethod.GET)
    public String live() {
        log.error(">> live");
        log.warn(">> live");
        log.info(">> live");
        log.debug(">> live");
        return "ok";
    }

    @RequestMapping(value = "/ready", method = RequestMethod.GET)
    public String ready() {
        return "ok";
    }
}
