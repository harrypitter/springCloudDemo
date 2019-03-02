package com.springcloudfeign.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "SPRING-CLIENT-01")
public interface FeignDemoService {

    @RequestMapping(value = "port" , method = RequestMethod.GET)
    String getPort();

    @RequestMapping(value = "getInfo/show" , method = RequestMethod.GET)
    String getPortTwo();
}
