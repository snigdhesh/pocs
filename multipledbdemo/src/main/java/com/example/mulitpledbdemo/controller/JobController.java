package com.example.mulitpledbdemo.controller;

import com.example.mulitpledbdemo.model.ScheduleJobHistory;
import com.example.mulitpledbdemo.repository.ScheduleJobHistroryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JobController {

    @Autowired
    private ScheduleJobHistroryRepository scheduleJobHistroryRepository;

    //private DataSource dataSource;

    @RequestMapping(value = "/jobs", method = RequestMethod.GET)
    public String getUsers() {
        scheduleJobHistroryRepository.createTable();
        return "Check h2 db for schedule_job_history table";
    }
}
