package com.selenium.webServices;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class RobotActionElementHandler extends BaseHandler {

	public RobotActionElementHandler(WebDriver webDriver) {
		super(webDriver);
	}

	/**
	 * Method to handle Keyboard action-UP
	 * @throws AWTException
	 */
	public void keyboardActionUp() throws AWTException
	{
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_UP);
			robot.keyRelease(KeyEvent.VK_UP);
		}
		catch (WebDriverException e) {
			throw new WebDriverException("Unable do the Keyboard Action \n" + e);
		}
	}

	/**
	 * Method to handle Keyboard action-DOWN
	 * @throws AWTException
	 */
	public void keyboardActionDown() throws AWTException
	{
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
		}
		catch (WebDriverException e) {
			throw new WebDriverException("Unable do the Keyboard Action \n" + e);
		}
	}

	/**
	 * Method to handle Keyboard action-UP
	 * @throws AWTException
	 */
	public void keyboardActionTAB() throws AWTException
	{
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
		}
		catch (WebDriverException e) {
			throw new WebDriverException("Unable do the Keyboard Action \n" + e);
		}
	}

	/**
	 * Method to handle Keyboard action-ENTER
	 * @throws AWTException
	 */
	public void keyboardActionEnter() throws AWTException
	{
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}
		catch (WebDriverException e) {
			throw new WebDriverException("Unable do the Keyboard Action \n" + e);
		}
	}

	/**
	 * Method to handle Keyboard action SelectAllAction, used before we paste text in textBox
	 * @throws AWTException
	 */
	public void SelectAllAction() throws AWTException
	{
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_A);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_A);
		}
		catch (WebDriverException e) {
			throw new WebDriverException("Unable do the Keyboard Action \n" + e);
		}
	}
}