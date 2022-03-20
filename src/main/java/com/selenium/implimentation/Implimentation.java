package com.selenium.implimentation;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.selenium.webServices.ActionElementHandler;
import com.selenium.webServices.BaseHandler;
import com.selenium.webServices.JavaScriptElementHandler;

public class Implimentation {

	WebDriverWait webDriverWait;
	WebElementFactory webElementFactory;
	Implimentation referenceDataImpl;

	Map<String ,BaseHandler> webElementMap;
	Random objGenerator;
	StringBuilder stringBuilder;
	String ref;

	private static Logger LOG = LoggerFactory.getLogger(Implimentation.class);

	@FindBy(xpath = "//*[@id=\'block_top_menu\']/ul/li[1]/a")
	public WebElement a;

	@FindBy(xpath = "Xpath")
	public List<WebElement> b;

	@FindBy(id = "ID")   
	public WebElement c;

	@FindBy(linkText = "link Text")
	public WebElement d;

	public Implimentation() {
		webElementFactory = new WebElementFactory();
		objGenerator = new Random();
		stringBuilder = new StringBuilder();
		WebDriver webDriver = webElementFactory.webDriver;
		webDriverWait = new WebDriverWait(webDriver,60);
	}

	/***
	 * Method to scroll down the page
	 * 
	 * @param webDriver
	 */
	public void scrollDownThePage(WebDriver webDriver) throws InterruptedException {
		try {
			Thread.sleep(5000);
			WebElementFactory.globalscenario.embed(WebElementFactory.attachScreenshot(), WebElementFactory.imageType);
			PageFactory.initElements(webDriver, this);
			webElementMap = webElementFactory.getWebElementObj();
			ActionElementHandler actionElementHandler = (ActionElementHandler) webElementMap.get("actionElementHandler");
			
			JavaScriptElementHandler javaScriptElementHandler = (JavaScriptElementHandler) webElementMap.get("javaScriptElementHandler");
			
			javaScriptElementHandler.highlightElement(a);
			
			WebElementFactory.globalscenario.embed(WebElementFactory.attachScreenshot(), WebElementFactory.imageType);
			
			actionElementHandler.moveToElementAndClick(a);

			WebElementFactory.globalscenario.embed(WebElementFactory.attachScreenshot(), WebElementFactory.imageType);
		}
		catch (Exception e) {
			WebElementFactory.globalscenario.write("Details filled are not proper....");
			WebElementFactory.globalscenario.embed(WebElementFactory.attachScreenshot(), WebElementFactory.imageType);
			Assert.fail();
		}
	}

	/***
	 * Method to explicitly wait for the web element to be visible in the web driver
	 * 
	 * @param webElement
	 */
	public void explicitWait(WebElement webElement) {
		LOG.info("webDriverWait is: "+webDriverWait);
		LOG.info("webElement is: "+webElement);
		webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
	}
}