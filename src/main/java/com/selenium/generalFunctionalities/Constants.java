package com.selenium.generalFunctionalities;

import com.selenium.config.PropertiesRepository;

public class Constants {

	public static String featureName;
	public static String description;
	public static String executeStatus;

	public static int scenarioCount=1;
	public static String metaDataName = "metaData.xlsx";

	public static String project_path = System.getProperty("user.dir");

	public static String saveFile = PropertiesRepository.loadAllProperties().getProperty("test.filesave.path");
	public static String filePath = project_path+saveFile;

	public static String metaData = PropertiesRepository.loadAllProperties().getProperty("test.metadata.path");
	public static String dataPath = project_path+metaData;
}