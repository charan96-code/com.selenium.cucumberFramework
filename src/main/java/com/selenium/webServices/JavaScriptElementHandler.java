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

	public void scrollUp() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) webDriver;
			js.executeScript("window.scrollBy(0,-2000)");
		}catch(WebDriverException e) {
			LOG.error("Unable to Scroll by " + "\n" + e.getMessage());
			throw new WebDriverException("Unable to Scroll by " + "\n" + e);
		}
	}

	public void scrollIntoView(WebElement element) {
		try {
			JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) webDriver;
			javaScriptExecutor.executeScript("arguments[0].scrollIntoView(true)", element);
			LOG.info("Scrolled on an element "+element+"---Successfully");
		}catch(WebDriverException e) {
			LOG.error("Unable to Scroll In to view on and element : "+element + "\n" + e.getMessage());
			throw new WebDriverException("Unable to Scroll In to view on element : "+element + "\n" + e);
		}
	}

	public void javaScriptClick(WebElement element) {
		try {
			JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) webDriver;;
			javaScriptExecutor.executeScript("arguments[0].click();", element);
			LOG.info("Javascript clicked on an element "+element+"---Successfully");
		}catch(WebDriverException e) {
			LOG.error("Unable to do javascript Click on an element : "+element + "\n" + e.getMessage());
			throw new WebDriverException("Unable to do javascript Click on an element : "+element + "\n" + e);
		}
	}

	public void scrollToElementAndClick(WebElement element) {
		try {
			if (element != null) {
				JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) webDriver;
				javaScriptExecutor.executeScript("arguments[0].scrollIntoView(true)", element);
				javaScriptExecutor.executeScript("arguments[0].click();", element);
			}
			LOG.info("Scrolled to an element and click on an element "+element+"---Successfully");
		} catch (WebDriverException e) {
			LOG.error("Unable to scroll and javascript Click on an element : "+element + "\n" + e.getMessage());
			throw new WebDriverException("Unable to scroll and javascript Click on an element : "+element + "\n" + e);
		}
	}

	public void highlightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
				"color: red; border: 5px solid yellow;");
	}
}