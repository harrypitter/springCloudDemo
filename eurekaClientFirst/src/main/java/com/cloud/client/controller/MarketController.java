package com.cloud.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarketController {

    @Value("${server.port}")
    String port;

    @Value("${spring.application.name}")
    String serviceName;

    @RequestMapping("/port")
    public String findInfo(){
        return "I'm form service:"+serviceName+",port:"+port;
    }

}
