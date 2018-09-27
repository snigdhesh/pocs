package com.example.aopdemo;

import com.example.aopdemo.services.Business1;
import com.example.aopdemo.services.Business2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessAopSpringBootTest {

    Logger log=LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Business1 business1;

    @Autowired
    private Business2 business2;

    @Test
    public void printBusinessLayer(){
        log.info("Printing from business 1 test: "+business1.calculateSomething());
        log.info("Printing from business 2 test: "+business2.caculateSomething());


    }
}
