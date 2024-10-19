package com.wcig.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @RequestMapping(value = "/live", method = RequestMethod.GET)
    public String live() {
        return "ok";
    }

    @RequestMapping(value = "/ready", method = RequestMethod.GET)
    public String ready() {
        return "ok";
    }
}
