package com.selenium.reports;

import java.io.File;
import java.io.FilenameFilter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.selenium.config.PropertiesRepository;
import com.selenium.webServices.BaseHandler;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;


public class CucumberReport extends BaseHandler{
		
	public CucumberReport(WebDriver webDriver) {
		super(webDriver);
		
	}

	/***
	 * Method to generate Cucumber Report
	 */
	public void generateCucumberReport() {

		String filePath = System.getProperty("user.dir") + PropertiesRepository.loadAllProperties().getProperty("jsonfile.path");
		List<String> jsonFiles = new ArrayList<>();

		File[] fileList = getFileList(filePath);

		for (File file : fileList) {
			jsonFiles.add(file.getPath());
		}

		SimpleDateFormat timeFormat = new SimpleDateFormat("hhmmss");
		DateFormat dateFormat = new SimpleDateFormat("YYYY_MM_dd");
		Calendar cal = Calendar.getInstance();

		String reportsPath = System.getProperty("user.dir") + PropertiesRepository.loadAllProperties().getProperty("reports.path");
		String outputDirPath = reportsPath + "/" + "Report" + "_" + dateFormat.format(cal.getTime())+"-"+timeFormat.format(cal.getTime());

		
		File reportOutputDirectory = new File(outputDirPath);
		String buildNumber = PropertiesRepository.loadAllProperties().getProperty("report.project.buildnumber");
		String projectName = PropertiesRepository.loadAllProperties().getProperty("report.project.name");

		//modified below one to true
		//boolean parallelTesting = true;
		Capabilities capabilities = ((RemoteWebDriver) webDriver).getCapabilities();
		Configuration configuration = new Configuration(reportOutputDirectory, projectName);

		// optional configuration
		configuration.setBuildNumber(buildNumber);

		// Additional meta data presented on main page
		configuration.addClassifications("Browser", capabilities.getBrowserName().toUpperCase());
		configuration.addClassifications("Browser Version", capabilities.getVersion());
		configuration.addClassifications("Java Version", System.getProperty("java.version").toUpperCase());
		configuration.addClassifications("Platform", System.getProperty("os.name").toUpperCase());
		configuration.addClassifications("Host Name", System.getenv("COMPUTERNAME").toUpperCase());
		
		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		Reportable result = reportBuilder.generateReports();
	}

	private static File[] getFileList(String dirPath) {
		File dir = new File(dirPath);

		File[] fileList = dir.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(".json");
			}
		});
		return fileList;
	}

	public static void setDriver(WebDriver webDriver) {
		webDriver = webDriver;
	}

	public WebDriver getDriver() {
		return webDriver;
	}
}