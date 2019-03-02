package com.cloud.ribbonservice.controller;

import com.cloud.ribbonservice.service.RibbonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/getInfo")
public class Controller {

    @Autowired
    RibbonService ribbonService;

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);


    @Value("${server.port}")
    String port;

    @Value("${spring.application.name}")
    String serviceName;

    @RequestMapping("/show")
    public String getInfo(){
        return "I'm form service:"+serviceName+",port:"+port;
    }

    @RequestMapping("/hello")
    public String showInfo(){
        return ribbonService.portList();
    }

    @RequestMapping("/hellol")
    public String showInfol(){
        System.out.println("find port");
        logger.info("find port");
        return ribbonService.port();

    }


}
