package com.selenium.webServices;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WindowElementHandler extends BaseHandler{

	private static Logger LOG = LoggerFactory.getLogger(WindowElementHandler.class);
	
	BaseHandler baseHandler;
	public WindowElementHandler(WebDriver webDriver) {
		super(webDriver);
	}

	/**
	 * Return all the window's handles that are opened.
	 * @return Iterator<String> 
	 */
	public Iterator<String> getAllWindowHandle()
	{
		Iterator<String> i2 = null;
		try{
			// To handle all new opened window.				
			Set<String> s1 = webDriver.getWindowHandles();		
			Iterator<String> i1 = s1.iterator();
			i2 = i1;	
		}
		catch(Exception e){
			LOG.error("Unable to get the window handles \n" + e.getMessage());
            throw new WebDriverException("Unable to get the window handles \n" + e);
		}
		return i2;
	}

	/**
	 * Return the current window handle.
	 * @return String
	 */
	public String getCurrentWindowHandle()
	{
		String currentWindow=null;
		try{
			currentWindow = webDriver.getWindowHandle();
		}
		catch(Exception e) {
			LOG.error("Unable to get current window handle \n" + e.getMessage());
            throw new WebDriverException("Unable to get current window handle \n" + e);
		}
		
		return currentWindow;
	}

	/**
	 * Method is used to Switch to recently opened window.  
	 * @param currentWindowHandle
	 */
	public void switchToLatestWindow(String desiredWindowHandle)
	{
		try{
			if(isWindowPresent(desiredWindowHandle)){
				webDriver.switchTo().window(desiredWindowHandle);
				LOG.info("Switched to latest");
			}
		}
		catch(Exception e) {
			LOG.error("Unable to switch to Latest window handle \n" + e.getMessage());
            throw new WebDriverException("Unable to switch to Latest window handle \n" + e);
		}
	}

	/**
	 * This method is used to check that Window is present or not.
	 * @return boolean
	 */
	public boolean isWindowPresent(String parentWindowHandle)
	{
		boolean windowFound = false;
		try{
			if(!webDriver.getWindowHandle().equals(parentWindowHandle))
				windowFound = true;
		} 
		catch(Exception e){
			windowFound = false;
			LOG.error("Window is not present \n" + e.getMessage());
            throw new WebDriverException("Window is not present \n" + e);
		}
		return windowFound;
	}
}
