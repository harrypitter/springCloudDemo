package com.cloud.servicethree.web;

import com.cloud.servicethree.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/")
public class MarketController {

    @Value("${server.port}")
    String port;

    @Value("${spring.application.name}")
    String serviceName;

    @Autowired
    DemoService demoService;

    @RequestMapping("show")
    public String getInfo(){
        return "I'm form service:"+serviceName+",port:"+port;
    }


    @RequestMapping(value = "proposalNo/{proposalNo}", method = RequestMethod.GET)
    public String getInfo(@PathVariable String proposalNo, HttpServletResponse httpServletResponse){

        try {
            String  ePolicyFile = "I'm form service:"+serviceName+",port:"+port;
            if (ePolicyFile == null || ePolicyFile.isEmpty()){
                httpServletResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return null;
            } else
                return ePolicyFile;
        } catch (Exception e) {
            e.printStackTrace();
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return e.getMessage();
        }

    }

    @RequestMapping("info")
    public String showInfo(){
        return demoService.getInfo();
    }

    @RequestMapping("getdata")
    public String showInfos(){
        return demoService.getdata();
    }

    @RequestMapping("getdatas")
    public String showInfosl(){
        return demoService.getdatas();
    }

}
