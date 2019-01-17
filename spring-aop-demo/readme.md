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
In above code `execution(* com.in28minutes.springboot.tutorial.basics.example.aop.data.*.*(..))` is point-cut.

### What is an Advice?
Statements you want to execute, are collective called as Advice. Advice is what you want to execute at point-cut.
If you want to log something like below in all the methods in a package, these logging statements becomes Advice.
```
  logger.info(" Check for user access ");
          logger.info(" Allowed execution for {}", joinPoint);
```
### What is aspect?
Combination of point-cut and advice, is called aspect.
``` 
//Aspect (this whole piece of code below, is called aspect)
      @Before("execution(* com.in28minutes.springboot.tutorial.basics.example.aop.data.*.*(..))") // this package name is called point-cut
        public void before(JoinPoint joinPoint){
          //Advice (this whole piece of code below, is called advice)
          logger.info(" Check for user access ");
          logger.info(" Allowed execution for {}", joinPoint);
        }
      } 
``` 
