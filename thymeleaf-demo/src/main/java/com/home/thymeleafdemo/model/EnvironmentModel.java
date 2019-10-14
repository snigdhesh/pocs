package com.home.thymeleafdemo.model;

import java.util.List;

public class EnvironmentModel {

    private List<Environment> environmentList;

    public List<Environment> getEnvironmentList() {
        return environmentList;
    }

    public void setEnvironmentList(List<Environment> environmentList) {
        this.environmentList = environmentList;
    }

    @Override
    public String toString() {
        return "EnvironmentModel{" +
                "environmentList=" + environmentList +
                '}';
    }
}
