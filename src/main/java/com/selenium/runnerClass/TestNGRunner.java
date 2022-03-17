package com.selenium.runnerClass;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.selenium.generalFunctionalities.Constants;
import com.selenium.generalFunctionalities.ExcelUtils;
import com.selenium.generalFunctionalities.GlobalProperties;
import com.selenium.generalFunctionalities.PropertiesRepository;
import com.selenium.implimentation.WebElementFactory;
import com.selenium.reports.CucumberReport;
import com.selenium.webServices.BaseHandler;
import com.selenium.webServices.SimpleWebElementHandler;

import cucumber.api.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/Feature",
		glue={"com.selenium.stepDefinition","com.selenium.implimentation"},

		plugin = {"pretty", "html:target/cucumber-reports/cucumber-pretty",
				"json:target/cucumber-reports/CucumberTestReport.json", 
				"rerun:target/cucumber-reports/rerun.txt",
		"junit:target/cucumber-reports/Cucumber.xml" },  
		monochrome = true
		)
public class TestNGRunner extends TestNGCucumberTests{

	private static Logger LOG = LoggerFactory.getLogger(SimpleWebElementHandler.class);
	Map<String ,BaseHandler> webElementMap;
	WebElementFactory webElementFactory;

	static {
		try {
			ExcelUtils.setExcel(Constants.dataPath+Constants.metaDataName);
			PropertiesRepository.loadAllProperties();
			LOG.info("Property Files Loaded Successfully");
		} catch (Exception e) {
			LOG.error("Unable to load properties files", e);
		}
	}

	@AfterSuite
	public void generateReport() {
		WebElementFactory.webDriver.quit();
		if (PropertiesRepository.loadAllProperties().getProperty("automation.type").equalsIgnoreCase(GlobalProperties.WEBDRIVERAUTOMATION)) {
			webElementFactory = new WebElementFactory();
			webElementMap = webElementFactory.getWebElementObj();
			CucumberReport cucumberReports= (CucumberReport)webElementMap.get("cucumberReports");
			cucumberReports.generateCucumberReport();	
		}
	}

	@Parameters({ "browser", "testtype", "suitename", "environment", "application" })
	@BeforeSuite
	public void setUp(@Optional String browserType, @Optional String testType, @Optional String suiteName,
			@Optional String environment, @Optional String application) {
		GlobalProperties.BrowserType = browserType;
		GlobalProperties.TestType = testType;
		GlobalProperties.SuiteName = suiteName;
		GlobalProperties.Environment = environment;
		GlobalProperties.Application = application;
	}
}