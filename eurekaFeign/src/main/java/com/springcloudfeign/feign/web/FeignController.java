package com.springcloudfeign.feign.web;

import com.springcloudfeign.feign.service.FeignDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class FeignController {

    @Autowired
    FeignDemoService feignDemoService ;

    @GetMapping("getInfo")
    public String getInfo()
    {
        return feignDemoService.getPort();
    }

    @GetMapping("getInfoTwo")
    public String getInfoTwo()
    {
        return feignDemoService.getPortTwo();
    }

}
