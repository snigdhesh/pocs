# Source
http://www.springboottutorial.com/spring-boot-and-aop-with-spring-boot-starter-aop


### What are cross-cutting concerns?
Every part of application we develop, will have some common functionalities like Logging and security. These are also called as aspects (Logging aspect and Security Aspect). These aspects are also called as *cross-cutting concerns*

### What is a point-cut?
It's an expression, which indicates packages/classses. 
We can define point-cuts on methods, and those methods can be executed at particular pointcuts.
**Example** 
``` 
      @Before("execution(* com.in28minutes.springboot.tutorial.basics.example.aop.data.*.*(..))")
        public void before(JoinPoint joinPoint){
          //Advice
          logger.info(" Check for user access ");
          logger.info(" Allowed execution for {}", joinPoint);
        }
      } 
``` 
In above code **execution(* com.in28minutes.springboot.tutorial.basics.example.aop.data.*.*(..))** is point-cut.
