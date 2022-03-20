package com.selenium.config;

public final class GlobalProperties {

	private GlobalProperties() {

	}
	
	public static final String PROPERTIESEXCEPTION = "Properties Exception : There was an error processing properties";
	public static final String SCREENSHOTPATH = System.getProperty("user.dir")
			+ PropertiesRepository.loadAllProperties().getProperty("screenshot.path");
	public static final String WEBDRIVERAUTOMATION = "webdriver";

	public static String BrowserType;
	public static String SuiteName;
	public static String Environment;
	public static String TestType;
	public static final String FIREFOX = "firefox";
	public static final String CHROME = "chrome";
	public static final String IE = "internet explorer";
	public static final String MICROSOFTEDGE = "edge";

	public static String Application;
	public static final long THREESECONDS= Long.parseLong(PropertiesRepository.loadAllProperties().getProperty("global.driver.wait_for_3000ms"));
	public static final long EIGHTSECONDS= Long.parseLong(PropertiesRepository.loadAllProperties().getProperty("global.driver.wait_for_8000ms"));
	public static final long FIFTEENSECONDS= Long.parseLong(PropertiesRepository.loadAllProperties().getProperty("global.driver.wait_for_15000ms"));
	public static final long THIRTYSECONDS= Long.parseLong(PropertiesRepository.loadAllProperties().getProperty("global.driver.wait_for_30000ms"));
	public static final long ONEMINUTE= Long.parseLong(PropertiesRepository.loadAllProperties().getProperty("global.driver.wait_for_60000ms"));
	public static final long TWOMINUTES= Long.parseLong(PropertiesRepository.loadAllProperties().getProperty("global.driver.wait_for_120000ms"));
	public static final long THREEMINUTES= Long.parseLong(PropertiesRepository.loadAllProperties().getProperty("global.driver.wait_for_180000ms"));
	public static final long FIVEMINUTES= Long.parseLong(PropertiesRepository.loadAllProperties().getProperty("global.driver.wait_for_300000ms"));
}