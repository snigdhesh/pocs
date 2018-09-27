package com.example.aopdemo.services;

import com.example.aopdemo.dao.Dao1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Business1 {

    @Autowired
    private Dao1 dao1;

    Logger log=LoggerFactory.getLogger(this.getClass());

    public int calculateSomething(){
        int value= dao1.returnSomething();
        log.info("From Business layer 1: "+value);
        return value;
    }
}
