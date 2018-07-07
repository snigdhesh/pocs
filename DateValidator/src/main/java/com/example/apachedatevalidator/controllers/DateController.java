package com.example.apachedatevalidator.controllers;

import com.example.apachedatevalidator.util.DateValidator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DateController {

    @RequestMapping("/date")
    public boolean isValidDate(@RequestParam String date){
        return DateValidator.isValidDate(date);
    }
}
