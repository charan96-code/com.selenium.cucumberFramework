package com.selenium.webServices;

import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PopupElementHandler extends BaseHandler{

	private static Logger LOG = LoggerFactory.getLogger(PopupElementHandler.class);
	
	Alert alert = null;

	public PopupElementHandler(WebDriver webDriver) {
		super(webDriver);
	}

	/**
	 * Method is used to switch to any alert pop up
	 * @param waitForElement
	 * @return
	 */
	public Alert switchToAlert() {

		try {
			if (isAlertPresent()) {
				alert = webDriver.switchTo().alert();
				LOG.info("Switching to Alert........");
			}
		} catch (UnhandledAlertException  e) {
			LOG.error("Unable to Switch to alert popup \n" + e.getMessage());
            throw new WebDriverException("Unable Switch to alert popup \n" + e);
		}
		return alert;
	}

	/**
	 * Method is used to verify presence of alert pop up
	 * @return
	 */
	public boolean isAlertPresent() {
		boolean foundAlert = false;

		try {
			webDriverWait = new WebDriverWait(webDriver,10);
			webDriverWait.until(ExpectedConditions.alertIsPresent());
			foundAlert = true;
			LOG.info("Alert is Present........");
		} catch (TimeoutException eTO) {
			foundAlert = false;
			LOG.error("Unable verify presence of alert popup \n" + eTO.getMessage());
            throw new WebDriverException("Unable verify presence of alert popup \n" + eTO);
		}
		return foundAlert;
	}

	/**
	 * Method is used to accept or click on OK on pop up
	 * @param waitForElement
	 */
	public void acceptAlert() {
		try {
			if (isAlertPresent()) {
				alert.accept();
				LOG.info("ALERT Accepted Successfully");
			}
		} catch (UnhandledAlertException e) {
			LOG.error("Unable Accept the Alert popup \n" + e.getMessage());
            throw new WebDriverException("Unable verify presence of alert popup \n" + e);
		}
	}

	/**
	 * Method is used to click on cancel on pop up
	 * @param waitForElement
	 */
	public void dismissAlert() {
		try {
			if (isAlertPresent()) {
				alert.dismiss();
				LOG.info("ALERT Dissmissed Successfully");
			}
		} catch (WebDriverException e) {
			LOG.error("Unable Reject the Alert popup \n" + e.getMessage());
            throw new WebDriverException("Unable verify presence of alert popup \n" + e);
		}
	}

	/**
	 * Method is used to get the text from pop up
	 * @param waitForElement
	 * @return
	 */
	public String getAlertText() {
		String alertText = null;
		try {
			if (isAlertPresent()) {
				alertText = alert.getText();
				LOG.info("Retreived ALERT Text Successfully and text is : "+"----"+alertText);
			}

		} catch (WebDriverException e) {
			LOG.error("Unable  get the text from the Alert popup \n" + e.getMessage());
            throw new WebDriverException("Unable get the text from the Alert popup \n" + e);
		}
		return alertText;
	}

	/**
	 * Method is used to write text in alert pop up input field
	 * @param text
	 */
	public void alertWritetext(String text) {
		try {
			if (isAlertPresent()) {
				alert.sendKeys(text);
				LOG.info("Text is sent to PROMPT Successfully");
			}
		}catch (WebDriverException e) {
			// TODO: handle exception
			LOG.error("Unable  Write the text Into the Prompt popup \n" + e.getMessage());
            throw new WebDriverException("Unable Write the text Into the Prompt popup \n" + e);
		}
	}
}