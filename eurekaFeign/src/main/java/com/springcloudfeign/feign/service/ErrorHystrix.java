package com.springcloudfeign.feign.service;

import org.springframework.stereotype.Component;

@Component
public class ErrorHystrix implements FeignDemoService {

    @Override
    public String getPort() {
        return "sorry, it's error!";
    }

    @Override
    public String getPortTwo() {
        return "sorry, it's also error!";
    }


}
