package com.selenium.webServices;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActionElementHandler extends BaseHandler{

	private static Logger LOG = LoggerFactory.getLogger(ActionElementHandler.class);

	public ActionElementHandler(WebDriver webDriver) {
		super(webDriver);
	}

	/**
	 * Method to move to element and will show the CSS property while hovering it.
	 * 
	 * @param element
	 * @param color
	 */
	public void moveToElement(WebElement element, String property) {	
		try {
			if (element != null) {
				Actions action = new Actions(webDriver);
				String cssValue = element.getCssValue(property);
				System.out.println("After hover: " + cssValue);
				action.moveToElement(element).perform();
				LOG.info("Moved to element : "+ element +"---Successfully");
			}
		} catch (WebDriverException e) {
			LOG.error("Unable to move to element: " + element + "\n" + e.getMessage());
			throw new WebDriverException("Unable to move to element: " + element + "\n" + e);
		}
	}

	/**
	 * Method to move to element
	 * 
	 * @param element
	 */
	public void moveToElement(WebElement element) {
		try {
			if (element != null) {
				Actions action = new Actions(webDriver);
				action.moveToElement(element).perform();
				LOG.info("Moved to element : "+ element +"---Successfully");
			}
		} catch (WebDriverException e) {
			LOG.error("Unable to move to element: " + element + "\n" + e.getMessage());
			throw new WebDriverException("Unable to move to element: " + element + "\n" + e);
		}
	}

	/**
	 * Method is used to move to web element and click on it
	 * @param elements
	 * @param waitForElement
	 */
	public void moveToElements(List<WebElement> elements) {
		try {
			if (elements.size() > 0) {
				for (WebElement element : elements) {
					Actions action = new Actions(webDriver);
					if (element != null) {
						action.moveToElement(element).perform();
					}
				}
			}
			LOG.info("Moved to elements : "+ elements +"---Successfully");
		} catch (WebDriverException e) {
			LOG.error("Unable to double click on the elements: " + elements + "\n" + e.getMessage());
			throw new WebDriverException("Unable to double click on the elements: " + elements + "\n" + e);
		}
	}

	/**
	 * Method to move to element and write text(like for textbox/textarea)
	 * @param element
	 * @param keysToSend
	 */
	public void moveToElementAndWriteText(WebElement element, String keysToSend) {
		try {
			if (element != null) {
				Actions action = new Actions(webDriver);
				action.moveToElement(element).click().sendKeys(keysToSend).perform();
				LOG.info("Moved to element : "+ element + "--"+"written text : "+keysToSend+"---Successfully");
			}
		} catch (WebDriverException e) {
			LOG.error("Unable to move to element: " + element + "\n" + e.getMessage());
			throw new WebDriverException("Unable to move to element: " + element + "\n" + e);

		}
	}

	/**
	 * Method to move to element and click the element
	 * @param element
	 */
	public void moveToElementAndClick(WebElement element) {
		try {
			if (element != null) {
				Actions action = new Actions(webDriver);
				action.moveToElement(element).click().perform();
				LOG.info("Moved to element : "+ element +"--and clicked Successfully");
			}
		} catch (WebDriverException e) {
			LOG.error("Unable to move to element and click on the element: " + element + "\n" + e.getMessage());
            throw new WebDriverException("Unable to move to element and click on the element: " + element + "\n" + e);
		}
	}

	public void moveToElementAndClickOffset(WebElement element) {
		try {
			if (element != null) {
				Actions action = new Actions(webDriver);
				// Instantiate Point class to get location of X and Y co-ordinates.

				Point point = element.getLocation();

				// Store value of elements as pixels in integers x and y

				int x = point.getX();

				System.out.println("Horizontal Position: " + x + " pixels");

				int y = point.getY();

				System.out.println("Vertical Position " + y + " pixels");

				action.moveToElement(element, x, y).perform();

				LOG.info("Moved to element : "+ element +"--and clicked Successfully with offset");
			}
		} catch (WebDriverException e) {
			LOG.error("Unable to move to element and click on the element with offset: " + element + "\n" + e.getMessage());
            throw new WebDriverException("Unable to move to element and click on the element: " + element + "\n" + e);

		}
	}


	public void moveToElementsAndClick(List<WebElement> elements) {
		try {
			if (elements.size() > 0) {
				for (WebElement element : elements) {
					Actions actions = new Actions(webDriver);
					if (element != null) {
						actions.moveToElement(element).build().perform();
						element.click();
					}
				}
			}
			LOG.info("Moved to elements : "+ elements +"--and clicked Successfully");
		} catch (WebDriverException e) {
			LOG.error("Unable to double click on the elements: " + elements + "\n" + e.getMessage());
			throw new WebDriverException("Unable to double click on the elements: " + elements + "\n" + e);
		}
	}


	/**
	 * Method to move to element, and then, click and hold the element.
	 * 
	 * @param element
	 */
	public void moveToElementAndHold(WebElement element) {
		try {
			if (element != null) {
				Actions action = new Actions(webDriver);
				action.moveToElement(element).clickAndHold().perform();
				LOG.info("Moved to element : "+ element +"--Hold Successfully");
			}
		} catch (WebDriverException e) {
			LOG.error("Unable to move to and hold the element: " + element + "\n" + e.getMessage());
            throw new WebDriverException("Unable to move to and hold the element: " + element + "\n" + e);
		}
	}


	/**
	 * Method to show contextMenu of an element using contextClick(Right Click Mouse
	 * Action).
	 * 
	 * @param element
	 */
	public void contextClick(WebElement element) {
		try {
			if (element != null) {
				Actions action = new Actions(webDriver);
				action.moveToElement(element).click().contextClick().perform();
				
				LOG.info("Context clicked Successfully");
			}
		} catch (WebDriverException e) {
			LOG.error("Unable to move and context click on the element: " + element + "\n" + e.getMessage());
            throw new WebDriverException("Unable to move and context click on the element: " + element + "\n" + e);
		}
	}

	/**
	 * Method to show contextMenu using contextClick(Right Click Mouse Action).
	 */
	public void contextClick() {
		try {
			Actions action = new Actions(webDriver);
			action.contextClick().perform();
			LOG.info("Context clicked Successfully");
		} catch (WebDriverException e) {
			LOG.error("Unable to context click on page: " + "\n" + e.getMessage());
            throw new WebDriverException("Unable to context click on page: " + "\n" + e);
		}
	}

	/**
	 * Method to doubleClick an element.
	 * @param element
	 */
	public void doubleClickOnElement(WebElement element) {
		try {
			if (element != null) {
				Actions action = new Actions(webDriver);
				action.doubleClick().perform();
				LOG.info("Double clicked to element : "+ element + "--clicked Successfully");
			}
		} catch (WebDriverException e) {
			LOG.error("Unable to double click on the element: " + element + "\n" + e.getMessage());
            throw new WebDriverException("Unable to double click on the element: " + element + "\n" + e);
		}
	}

	/**
	 * This method performs a key press on an element
	 * and does not release modifier key - subsequent interactions may assume it's kept pressed.
	 * @param element
	 * @param modifier_key
	 * @throws AWTException
	 */
	public void keyPressOnElement(WebElement element, Keys modifier_key) throws AWTException
	{
		try {
			String pressKey = Keys.chord(modifier_key);
			Actions action = new Actions(webDriver);
			action.moveToElement(element).sendKeys(pressKey).click().perform();
			LOG.info("Key Pressed "+modifier_key+" "+pressKey+"----Successfully");
		}
		catch (WebDriverException e) {
			LOG.error("Unable do the " + modifier_key + " key actions \n" + e.getMessage());
            throw new WebDriverException("Unable do the " + modifier_key + " key actions \n" + e);
		}
	}

	/**
	 * Releases the depressed left mouse button at the current mouse location.
	 * @param element
	 */
	public void releaseElement(WebElement element) {
		try {
			if (element != null) {
				Actions action = new Actions(webDriver);
				action.release().perform();
				LOG.info("Released an element : "+element +"----Successfully");
			}
		} catch (WebDriverException e) {
			LOG.error("Unable do release the depressed left mouse button at the current mouse location \n" + e.getMessage());
            throw new WebDriverException("Unable do release the depressed left mouse button at the current mouse location \n" + e);
		}
	}

	/**
	 * Method to Drag And Drop an element from source element location, moves to the location of the target element,
	 * and then releases the mouse. 
	 * @param source
	 * @param target
	 */
	public void dragAndDropElement(WebElement source, WebElement target) {
		try {
			if (source != null) {
				Actions action = new Actions(webDriver);
				action.dragAndDrop(source, target).perform();
				LOG.info("Dragged element : " + source + "----And Dropped to : "+target+"----Successfully");
			}
		} catch (WebDriverException e) {
			LOG.error("Unable do Drag And Drop an element from source element location \n" + e.getMessage());
            throw new WebDriverException("Unable do Drag And Drop an element from source element location \n" + e);
		}
	}

	/**
	 * Method to Drag And Drop an element from source element location, moves by a given offset,
	 * and then releases the mouse. 
	 * @param source
	 * @param x_offset
	 * @param y_offset
	 */
	public void dragAndDropElement(WebElement source, int x_offset, int y_offset) {
		try {
			if (source != null) {
				Actions action = new Actions(webDriver);
				action.dragAndDropBy(source, x_offset, y_offset).perform();
				LOG.info("Element is dragged from "+source+" and dropped at "+x_offset+","+y_offset);
			}
		} catch (WebDriverException e) {
			LOG.error("Unable do Drag And Drop an element from source element location with offset values \n" + e.getMessage());
            throw new WebDriverException("Unable do Drag And Drop an element from source element location with offset values \n" + e);
		}
	}
}