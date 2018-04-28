package com.home.hateoas.model;

public class ApplicationDetails {
	private String appName;

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	@Override
	public String toString() {
		return "ApplicationDetails [appName=" + appName + "]";
	}
	
	
	

}
