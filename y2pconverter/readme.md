# How to setup thymeleaf for spring boot ?

##### step1:
Add following dependecies to your pom.xml

```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>

        <!-- Optional, for bootstrap -->
        <dependency>
            <groupId>org.webjars</groupId>
            <artifactId>bootstrap</artifactId>
            <version>3.3.7</version>
        </dependency>
        
        <!-- Optional for extra end points like /actuator/health -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
```
##### step2:
Folder structure is very important, if it's not correct you may not see expected screens.

- Always put `main.css` file under src > resources > static > css.
- Always put `index.html` file under src > resources > templates. (You can add any number of such files.) Refer to `welcome.html` file in current project.
##### step3:

Now in controller, add model and return html page as show below.  
**NOTE**: Make sure you have `@Controller` annotation instead of `@RestController`, because `@RestController` annotation will convert the responses returning from methods as JSON types.

    @RequestMapping("/")
    public String greeting(Map<String,Object> model){
        model.put("appDeveloper",appDeveloper);
        model.put("appName",appName);
        model.put("appVersion",appVersion);
        return "welcome";
    }
