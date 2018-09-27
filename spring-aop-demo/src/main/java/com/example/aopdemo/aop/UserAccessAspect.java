package com.example.aopdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class UserAccessAspect {
    Logger log=LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.example.aopdemo.dao.*.*(..))")
    public void beforeAdvice(JoinPoint joinPoint){
        log.info(" Check for user access");
        log.info(" Allow execution for {}",joinPoint);
    }

}
