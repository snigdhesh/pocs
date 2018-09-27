package com.example.aopdemo.services;

import com.example.aopdemo.dao.Dao2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Business2 {
    Logger log=LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Dao2 dao2;

    public int caculateSomething(){
        int value=dao2.returnSomething();
        log.info("From Business layer 2: "+value);
        return value;
    }
}
