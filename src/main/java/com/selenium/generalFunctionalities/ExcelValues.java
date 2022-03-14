package com.selenium.generalFunctionalities;

public class ExcelValues {

	private String testCaseName;
	private String description;
	private String executeStatus;

	public ExcelValues(){}

	public ExcelValues(String testCaseName, String description, String executeStatus) {
		super();
		this.testCaseName = testCaseName;
		this.description = description;	
		this.executeStatus = executeStatus;
	}

	public String getTestCaseName() {
		return testCaseName;
	}

	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}
	
	public String getDescription() {
		return testCaseName;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExecuteStatus() {
		return executeStatus;
	}

	public void setExecuteStatus(String executeStatus) {
		this.executeStatus = executeStatus;
	}

	@Override
	public String toString() {
		return "Feature: "+testCaseName+" Description: "+description+ " and Execute status: "+executeStatus;
	}
}