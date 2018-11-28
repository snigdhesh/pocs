package com.example.demo.controller;

import com.example.demo.models.Courses;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/")
    public String getCourses() throws JsonProcessingException {

        ObjectMapper objectMapper = getObjectMapper();

        List<Courses> courseList = new ArrayList<>();

        Courses courses1 = new Courses();
        courses1.setAuthor("HeadFirst");
        courses1.setCourseName("Java desing patterns");
        courses1.setPrice("$45");

        courseList.add(courses1);

        Courses courses2 = new Courses();
        courses2.setAuthor("Dummies");
        courses2.setCourseName("Web Development for dummies");
        courses2.setPrice("$65");

        courseList.add(courses2);


        log.info("{},{}", System.lineSeparator(), objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(courseList));


        return "Check IDE console for pretty courses json..";

    }

    public ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }
}
