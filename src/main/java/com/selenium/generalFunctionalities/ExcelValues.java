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

	/***
	 * Method to get Test Case Name
	 */
	public String getTestCaseName() {
		return testCaseName;
	}

	/***
	 * Method to set Test Case Name
	 * 
	 * @param testCaseName
	 */
	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}
	
	/***
	 * Method to get Description
	 */
	public String getDescription() {
		return testCaseName;
	}

	/***
	 * Method to set Description
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/***
	 * Method to get Execute status
	 */
	public String getExecuteStatus() {
		return executeStatus;
	}

	/***
	 * Method to set Execute status
	 * 
	 * @param executeStatus
	 */
	public void setExecuteStatus(String executeStatus) {
		this.executeStatus = executeStatus;
	}

	@Override
	public String toString() {
		return "Feature: "+testCaseName+" Description: "+description+ " and Execute status: "+executeStatus;
	}
}