package com.home.thymeleafdemo.model;

public class Environment {
    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Environment{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
