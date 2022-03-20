package com.selenium.webServices;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaScriptElementHandler extends BaseHandler{

	private static Logger LOG = LoggerFactory.getLogger(ActionElementHandler.class);

	public JavaScriptElementHandler(WebDriver webDriver) {
		super(webDriver);
	}

	/***
	 * Method to scroll 100 pixels down on web page
	 */
	public void scrollDownBy100() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) webDriver;
			js.executeScript("window.scrollBy(0,100)");
			LOG.info("Scrolled down by 100px Successfully");
		}catch(WebDriverException e) {
			LOG.error("Unable to Scroll by 100xp" + "\n" + e.getMessage());
			throw new WebDriverException("Unable to Scroll by 100xp " + "\n" + e);
		}
	}

	/***
	 * Method to scroll 300 pixels down on web page
	 */
	public void scrollDownBy300Px() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) webDriver;
			js.executeScript("window.scrollBy(0,300)");
			LOG.info("Scrolled down by 300px Successfully");
		}catch(WebDriverException e) {
			LOG.error("Unable to Scroll by 300xp" + "\n" + e.getMessage());
			throw new WebDriverException("Unable to Scroll by 300xp " + "\n" + e);
		}
	}

	/***
	 * Method to scroll 2000 pixels top on web page
	 */
	public void scrollUp() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) webDriver;
			js.executeScript("window.scrollBy(0,-2000)");
		}catch(WebDriverException e) {
			LOG.error("Unable to Scroll by " + "\n" + e.getMessage());
			throw new WebDriverException("Unable to Scroll by " + "\n" + e);
		}
	}

	/***
	 * Method for scrolling the web page based on the web element
	 * 
	 * @param webElement
	 */
	public void scrollIntoView(WebElement webElement) {
		try {
			JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) webDriver;
			javaScriptExecutor.executeScript("arguments[0].scrollIntoView(true)", webElement);
			LOG.info("Scrolled on an element "+webElement+"---Successfully");
		}catch(WebDriverException e) {
			LOG.error("Unable to Scroll In to view on and element : "+webElement + "\n" + e.getMessage());
			throw new WebDriverException("Unable to Scroll In to view on element : "+webElement + "\n" + e);
		}
	}

	/***
	 * Method to move to web element and click
	 * 
	 * @param webElement
	 */
	public void javaScriptClick(WebElement webElement) {
		try {
			JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) webDriver;;
			javaScriptExecutor.executeScript("arguments[0].click();", webElement);
			LOG.info("Javascript clicked on an element "+webElement+"---Successfully");
		}catch(WebDriverException e) {
			LOG.error("Unable to do javascript Click on an element : "+webElement + "\n" + e.getMessage());
			throw new WebDriverException("Unable to do javascript Click on an element : "+webElement + "\n" + e);
		}
	}

	/***
	 * Method to scroll and move to web element and click
	 * 
	 * @param webElement
	 */
	public void scrollToElementAndClick(WebElement webElement) {
		try {
			if (webElement != null) {
				JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) webDriver;
				javaScriptExecutor.executeScript("arguments[0].scrollIntoView(true)", webElement);
				javaScriptExecutor.executeScript("arguments[0].click();", webElement);
			}
			LOG.info("Scrolled to an element and click on an element "+webElement+"---Successfully");
		} catch (WebDriverException e) {
			LOG.error("Unable to scroll and javascript Click on an element : "+webElement + "\n" + e.getMessage());
			throw new WebDriverException("Unable to scroll and javascript Click on an element : "+webElement + "\n" + e);
		}
	}

	/***
	 * Method to highlight a web element
	 * 
	 * @param webElement
	 */
	public void highlightElement(WebElement webElement) {
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", webElement,
				"color: red; border: 5px solid yellow;");
	}
}