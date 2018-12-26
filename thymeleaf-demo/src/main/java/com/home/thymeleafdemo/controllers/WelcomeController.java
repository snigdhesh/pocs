package com.home.thymeleafdemo.controllers;

import com.home.thymeleafdemo.model.Environment;
import com.home.thymeleafdemo.model.EnvironmentModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class WelcomeController {

    @Value("${info.app.name}")
    private String appName;

    @Value("${info.developer.name}")
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

    @RequestMapping("/environments")
    public String getEnvs(Map<String,Object> model){



        Environment devEnvironment=new Environment();
        devEnvironment.setName("dev");
        devEnvironment.setUrl("dev.com");

        Environment testEnvironment=new Environment();
        testEnvironment.setUrl("test.com");
        testEnvironment.setName("test");

        List<Environment> environmentList=new ArrayList<>();
        environmentList.add(devEnvironment);
        environmentList.add(testEnvironment);

        EnvironmentModel environmentModel=new EnvironmentModel();
        environmentModel.setEnvironmentList(environmentList);

        model.put("environmentModel",environmentModel);


        return "environments";
    }

}
