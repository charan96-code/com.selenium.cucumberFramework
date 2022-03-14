package com.selenium.generalFunctionalities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;

import com.selenium.implimentation.WebElementFactory;

public final class PropertiesRepository {

	private PropertiesRepository() {

	}

	public static Properties loadAllProperties()  {

		FileReader reader = null;
		try {	
			reader = new FileReader(System.getProperty("user.dir")+"/src/main/resources/applicationConfig.properties");
		} catch (FileNotFoundException e1) {
			WebElementFactory.globalscenario.write("Unable to take input from meta-data file due to slowmess of server.");
			WebElementFactory.globalscenario.write("Please execute this scenario again");
			Assert.fail();
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