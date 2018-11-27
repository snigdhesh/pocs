package com.example.aopdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class UserAccessAspect {
    private static final Logger log=LoggerFactory.getLogger(UserAccessAspect.class);

    @Before("within(com.example.aopdemo.controller.*)")
    public void beforeAdvice(JoinPoint joinPoint){
        log.info("Entry: {}",joinPoint.getStaticPart());
    }

    @After("within(com.example.aopdemo.controller.*)")
    public void afterAdvice(JoinPoint joinPoint){
        log.info("Exit: {}",joinPoint.getSignature().getName());
    }



}
