package com.selenium.implimentation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.selenium.generalFunctionalities.Constants;
import com.selenium.generalFunctionalities.GlobalProperties;
import com.selenium.generalFunctionalities.PropertiesRepository;
import com.selenium.reports.CucumberReport;
import com.selenium.webServices.ActionElementHandler;
import com.selenium.webServices.BaseHandler;
import com.selenium.webServices.JavaScriptElementHandler;
import com.selenium.webServices.PopupElementHandler;
import com.selenium.webServices.RobotActionElementHandler;
import com.selenium.webServices.SimpleWebElementHandler;
import com.selenium.webServices.WindowElementHandler;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class WebElementFactory{

	private static Logger LOG = LoggerFactory.getLogger(WebElementFactory.class);
	public static WebDriver webDriver;
	public static Scenario globalscenario;
	public static String browserType;
	public static String environment;
	public static String application;
	public static final String imageType = "image/png";
	public static long waitPeriod;

	WebDriverWait webDriverWait;
	Map<String ,BaseHandler> webElemntFactory;

	@Before
	public void setUp(Scenario scenario) {	

		if(Constants.scenarioCount==1) {
			Constants.scenarioCount++;
			LOG.info("---------LAUNCHING BROWSER---------");
			browserType = GlobalProperties.BrowserType;
			webDriver = launchBrowser(browserType);
			globalscenario = scenario;

			try {
				launchApplication();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@After
	public void tearDown(Scenario scenario) throws IOException {
		globalscenario = scenario;
		webDriver.get(PropertiesRepository.loadAllProperties().getProperty("test.test.application.url"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("Error in Thread Sleep Method");
			e.printStackTrace();
		}
	}

	public Map<String ,BaseHandler> getWebElementObj (){
		webElemntFactory = new HashMap<String ,BaseHandler>();

		webElemntFactory.put("baseHandler", new BaseHandler(webDriver));
		webElemntFactory.put("simpleWebElementHandler", new SimpleWebElementHandler(webDriver));
		webElemntFactory.put("actionElementHandler", new ActionElementHandler(webDriver));
		webElemntFactory.put("javaScriptElementHandler", new JavaScriptElementHandler(webDriver));
		webElemntFactory.put("popupElementHandler", new PopupElementHandler(webDriver));
		webElemntFactory.put("RobotActionElementHandler", new RobotActionElementHandler(webDriver));
		webElemntFactory.put("windowElementHandler", new WindowElementHandler(webDriver));
		webElemntFactory.put("cucumberReports", new CucumberReport(webDriver));

		return webElemntFactory;
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public void setWebDriver(WebDriver webDriver) {
		WebElementFactory.webDriver = webDriver;
	}

	public Map<String, BaseHandler> getWebElemntFactory() {
		return webElemntFactory;
	}


	public void setWebElemntFactory(Map<String, BaseHandler> webElemntFactory) {
		this.webElemntFactory = webElemntFactory;
	}

	public static WebDriver launchBrowser(String browser) {
		browserType = browser;
		try {
			switch (browserType.toLowerCase()) {
			case GlobalProperties.FIREFOX:
				System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, System.getProperty("user.dir")
						+ PropertiesRepository.loadAllProperties().getProperty("global.browser.firefox.gecko.driver.executable"));

				webDriver = new FirefoxDriver();
				break;
			case GlobalProperties.IE:
				System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY, System.getProperty("user.dir")
						+ PropertiesRepository.loadAllProperties().getProperty("global.browser.ie.driver.executable"));

				webDriver = new InternetExplorerDriver();
				break;
				
			case GlobalProperties.CHROME:
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
						+ PropertiesRepository.loadAllProperties().getProperty("global.browser.chrome.driver.executable"));
				webDriver = new ChromeDriver();
				System.out.println("WebDriver is: "+webDriver);

				break;

			default:
				throw new RuntimeException("Unsupported webdriver: " + browserType);
			}
		} catch (Exception e) {
			throw new RuntimeException("Error something went wrong!\n" + e.getMessage());
		}
		manageWebDriver();
		return webDriver;
	}

	public static void manageWebDriver() {
		webDriver.manage().window().maximize();
		webDriver.manage().deleteAllCookies();
		webDriver.manage().timeouts().implicitlyWait(Integer.parseInt(PropertiesRepository.loadAllProperties().getProperty("global.implicit.wait")),
				TimeUnit.SECONDS);
	}

	public void launchApplication() throws InterruptedException {
		LOG.info("Launching Application");
		webDriver.get(PropertiesRepository.loadAllProperties().getProperty("test.test.application.url"));
		webDriver.manage().timeouts().implicitlyWait(Integer.parseInt(PropertiesRepository.loadAllProperties().getProperty("global.implicit.wait")),
				TimeUnit.SECONDS);
	}

	public static byte[] attachScreenshot() {
		File screenshot;
		byte[] screenshotArray = null;
		try {
			screenshot = takeScreenShots("screenshot");
			InputStream screenshotStream = new FileInputStream(screenshot);
			screenshotArray = IOUtils.toByteArray(screenshotStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenshotArray;
	}

	public static File takeScreenShots(String picture) throws IOException {
		File temp = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(temp, new File(GlobalProperties.SCREENSHOTPATH + File.separator + picture));
		return temp;
	}

	public void explicitWait(WebElement webElement) {
		webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
	}
}