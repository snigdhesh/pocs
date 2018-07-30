package com.example.feigndemo.controllers;

import com.example.feigndemo.feignproxy.UserDetailsProxy;
import com.example.feigndemo.models.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDetailController {

    @Autowired
    private UserDetailsProxy userDetailsProxy;

    @RequestMapping("/users")
    public UserDetail getUsers(){
        return userDetailsProxy.getUsers();
    }
}
