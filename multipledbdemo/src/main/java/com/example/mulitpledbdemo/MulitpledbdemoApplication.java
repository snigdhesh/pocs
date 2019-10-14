package com.example.mulitpledbdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.mulitpledbdemo.repository")
public class MulitpledbdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MulitpledbdemoApplication.class, args);
    }

}

