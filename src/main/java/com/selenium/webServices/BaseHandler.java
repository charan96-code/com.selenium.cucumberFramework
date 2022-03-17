package com.selenium.webServices;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Parameters;

public class BaseHandler{

	protected WebDriver webDriver;
	
	private static Logger LOG = LoggerFactory.getLogger(SimpleWebElementHandler.class);

	WebDriverWait webDriverWait;

	public BaseHandler(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	@Parameters({"browser"})
	public void launchBrowser(String browser) {
		switch (browser) {
		case "chrome": 

			break;

		default:
			break;
		}
	}

	/**
	 * Method is to use EXPLICIT WAIT for an element
	 */
	public void setupConfigValue() {
		webDriverWait = new WebDriverWait(webDriver, 10);
	}

	public void setWebDriverWait(WebElement element) {
		try {
			webDriverWait.until(ExpectedConditions.visibilityOf(element));
		} catch (StaleElementReferenceException e) {
			webDriverWait.until(ExpectedConditions.not(ExpectedConditions.stalenessOf(element)));
		} catch (WebDriverException e) {
			LOG.error("Element : " + element + "not under viewport"+"\n " + e.getMessage());
			throw new WebDriverException("Element : " + element + "not under viewport" +"\n " + e);
		}
	}
	
	public void setWebDriverWait(List<WebElement> elements) {
		try {
			webDriverWait.until(ExpectedConditions.visibilityOf((WebElement) elements));
		} catch (StaleElementReferenceException e) {
			webDriverWait.until(ExpectedConditions.not(ExpectedConditions.stalenessOf((WebElement) elements)));
		} catch (WebDriverException e) {
			LOG.error("Element : " + elements + "not under viewport"+"\n " + e.getMessage());
			throw new WebDriverException("Element : " + elements + "not under viewport" +"\n " + e);
		}
	}

	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	/**
	 * Method to use IMPLICIT WAIT
	 */
	public void waitForPageToLoad() {
		webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	/**
	 * Method to capture screenshot of failed test.
	 * 
	 * @param driver
	 * @param name
	 */
	public String getScreenShot(WebDriver driver, String screenShotName) {
		long currentDate = System.currentTimeMillis();
		//System.out.println("current Date " + System.currentTimeMillis());
		String destDir = System.getProperty("user.dir") + "\\screenshots\\";
		File destination = new File(destDir + "_" + screenShotName + "_" + currentDate+".jpg");
		
		TakesScreenshot ts = (TakesScreenshot) driver;

		byte[] source = ts.getScreenshotAs(OutputType.BYTES);
		try {
			//destination.createNewFile();
			FileOutputStream fileOutputStream = new FileOutputStream(destination);
			fileOutputStream.write(source);
			fileOutputStream.flush();
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			LOG.error("File not Found"+"\n " + e.getMessage());
			throw new WebDriverException("File not Found" +"\n " + e);
		}
		catch (IOException e) {
			LOG.error("Input Output Exception"+"\n " + e.getMessage());
			throw new WebDriverException("Input Output Exception" +"\n " + e);
		}
		return destDir;
	}

	public void waitForElementTobeLoaded(WebElement element) {
		webDriverWait.until(ExpectedConditions.not(ExpectedConditions.stalenessOf(element)));
	}

	public String displayDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
		return dateFormat.format(date);
	}

	public void waitForSomeTime(long millisec) throws InterruptedException {
		Thread.sleep(millisec);
	}
}