package com.example.mulitpledbdemo.model;

import javax.persistence.*;

@Entity
public class ScheduleJobHistory {
    @Id
    @GeneratedValue
    private Long id;

    //@Column(nullable = false)
    private String name;

    //@Column(nullable = true)
    private String jobStatus;

    //@Column(nullable = true)
    private String executionStatus;

    //@Column(nullable = true)
    private String executionLog;

    private String start_time;
    private String end_time;

    public ScheduleJobHistory(String name, String start_time, String end_time,
                              String jobStatus, String executionStatus,
                              String executionLog) {
        //this.id = id;
        this.name = name;
        this.start_time = start_time;
        this.end_time = end_time;
        this.jobStatus = jobStatus;
        this.executionStatus = executionStatus;
        this.executionLog = executionLog;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getExecutionStatus() {
        return executionStatus;
    }

    public void setExecutionStatus(String executionStatus) {
        this.executionStatus = executionStatus;
    }

    public String getExecutionLog() {
        return executionLog;
    }

    public void setExecutionLog(String executionLog) {
        this.executionLog = executionLog;
    }

}