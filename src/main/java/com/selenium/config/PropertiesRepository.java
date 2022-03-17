package com.selenium.config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public final class PropertiesRepository {

	private PropertiesRepository() {

	}

	public static Properties loadAllProperties()  {
		FileReader reader = null;
		try {
			reader = new FileReader("src\\main\\resources\\applicationConfig.properties");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		Properties propFilesList = new Properties();
		try {
			propFilesList.load(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return propFilesList;
	}
}