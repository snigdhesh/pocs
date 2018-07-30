package com.example.feigndemo.feignproxy;

import com.example.feigndemo.models.UserDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="user-deatils-service",url = "https://api.myjson.com/bins/n8jrk") // I created my own json from 'myjson.com'
@Service
public interface UserDetailsProxy{
    @RequestMapping("")
    UserDetail getUsers();

}


//---- or you can also follow below method ------

/*

@FeignClient(name="user-deatils-service",url = "https://api.myjson.com/bins") // I created my own json from 'myjson.com'
@Service
public interface UserDetailsProxy{
    @RequestMapping("/n8jrk")
    UserDetail getUsers();

}

*/
