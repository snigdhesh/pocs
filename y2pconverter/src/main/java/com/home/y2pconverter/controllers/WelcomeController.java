package com.home.y2pconverter.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class WelcomeController {

    @Value("${welcome.message}")
    private String message;
    @Value("${info.app.name}")
    private String appName;
    @Value("${info.app.developer}")
    private String appDeveloper;
    @Value("${info.app.version}")
    private String appVersion;

    @RequestMapping("/")
    public String greeting(Map<String,Object> model){
        model.put("appDeveloper",appDeveloper);
        model.put("appName",appName);
        model.put("appVersion",appVersion);
        return "welcome";
    }
}
