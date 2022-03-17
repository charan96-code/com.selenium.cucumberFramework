package com.selenium.webServices;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleWebElementHandler extends BaseHandler{

	private static Logger LOG = LoggerFactory.getLogger(SimpleWebElementHandler.class);

	public SimpleWebElementHandler(WebDriver webDriver) {
		super(webDriver);	
	}
	
	/**
	 * Method is used to click on any WebElement
	 * @param element
	 * @param waitForElement
	 */
	public void clickElement(WebElement element) {
		try {
			if(element!=null) {
				element.click();
				LOG.info("Clicked on element Successfully");
			}
		}catch(WebDriverException e) {
			LOG.error("Unable to click on the element: " + element + "\n " + e.getMessage());
			throw new WebDriverException("Unable to click on the element: " + element + "\n " + e);

		}
	}

	/**
	 * Method to check if we are on expected page, so that further validation can be performed.
	 * @param eTitle
	 */
	public void verifyTitle(String eTitle)
	{
		try
		{
			webDriverWait.until(ExpectedConditions.titleIs(eTitle));
		}
		catch(Exception e)
		{
			LOG.error("Unable to verify Page title \n " + e.getMessage());
			throw new WebDriverException("Unable to verify Page title \n " + e);

		}
	}

	/**
	 * Method is used to send text to any textbox
	 * @param element
	 * @param text
	 * @param waitForElement
	 * @throws InterruptedException 
	 */
	public void writeText(WebElement element,String text){
		try {
			if(element!=null) {
				element.click();
				element.clear();
				element.sendKeys(text);
				LOG.info("Text is entered");
			}
		}catch(WebDriverException e) {
			LOG.error("Unable to enter text on the element: " + element + "\n " + e.getMessage());
			throw new WebDriverException("Unable to enter text on the element: " + element + "\n " + e);

		}
	}

	/**
	 * To Verify Display of an Element
	 * @param element
	 */
	public void isElementDisplayed(WebElement element) {
		try {
			if (element != null) {
				element.isDisplayed();
			}
		}catch(WebDriverException e) {
			LOG.error("Element is not displayed \n " + e.getMessage());
			throw new WebDriverException("Dropdown is not displayed \n " + e);
		}
	}
	
	/**
	 * Method to get attribute value of the element
	 * @param element
	 * @param value
	 */
	public String getTextFromValueAttribute(WebElement element, String attribute) {
		String text = null;

		try {
			text = element.getAttribute(attribute);
			System.out.println("text of element" + text);
		} catch (Exception e) {
			LOG.error("Unable to get the text from Value attribute of an element: " + element + "\n " + e.getMessage());
			throw new WebDriverException("Unable to get the text from Value attribute of an element: " + element + "\n " + e);
		}

		return text.trim();
	} 

	/**
	 * Method to get CssValue of the element
	 * @param element
	 * @param value
	 */
	public String getCSSValue(WebElement element, String propertyName) {
		String cssValue = null;

		try {
			if (element != null) {
				cssValue = element.getCssValue(propertyName);
			}
		} catch (Exception e) {
			LOG.error("Unable to get the css value from the element: " + element + "\n " + e.getMessage());
			throw new WebDriverException("Unable to get the css vlaue from the element: " + element + "\n " + e);
		}
		return cssValue;

	}

	/***
	 * Method is used to get the visible (i.e. not hidden by CSS) innerText of
	 * element, including sub-elements, without any leading or trailing whitespace
	 * 
	 * @param element From which you gets the text
	 * @return The innerText of this element
	 */
	public String getText(WebElement element) {
		String text = null;
		try {
			if (element != null) {
				//waitForElementTobeLoaded(element);
				text = element.getText();
			}
		} catch (WebDriverException e) {
			LOG.error("Unable to get the text from element: " + element + "\n " + e.getMessage());
			throw new WebDriverException("Unable to get the text from element: " + element + "\n " + e);

		}
		return text.trim();
	}

	/***
	 * Method is used to get the visible (i.e. not hidden by CSS) innerText of
	 * element, including sub-elements, without any leading or trailing whitespace
	 * 
	 * @param element From which you gets the text
	 * @return The innerText of this element
	 */
	public List<String> getText(List<WebElement> element) {
		List<String> text = new ArrayList<String>();
		for (int i = 0; i < element.size(); i++) {
			try {
				if (element != null) {
					waitForElementTobeLoaded(element.get(i));
					text.add(element.get(i).getText().trim());
				}
			} catch (WebDriverException e) {
				LOG.error("Unable to get the text from element: " + element + "\n " + e.getMessage());
				throw new WebDriverException("Unable to get the text from element: " + element + "\n " + e);
			}
		}
		return text;
	}

	/**
	 * Method is used to get dropdown. If it is not, then an
	 * UnexpectedTagNameException is thrown.
	 *
	 * @param element SELECT element to wrap
	 * @throws UnexpectedTagNameException when element is not a SELECT
	 * @return
	 */
	public Select getDropdown(WebElement element) {
		Select dropDown = null;
		try {
			if (element != null) {
				//waitForElementTobeLoaded(element);
				dropDown = new Select(element);
			}
		} catch (WebDriverException e) {
			LOG.error("Unable to get the dropdwon element: " + element + "\n " + e.getMessage());
			throw new WebDriverException("Unable to get the dropdwon element: " + element + "\n " + e);
		}
		return dropDown;
	}

	/**
	 * Method is used to select Drop down value with index
	 * @param element
	 * @param index
	 */
	public void selectByIndex(WebElement element, int i)
	{
		try {
			Select dropdown = getDropdown(element);
			if (dropdown != null) {
				dropdown.selectByIndex(i);
				System.out.println("Dropdown selected");
			}
		} catch (WebDriverException e) {
			LOG.error("Unable to select value from the dropdown:" + element + "\n " + e.getMessage());
			throw new WebDriverException("Unable to select value from the dropdown:" + element + "\n " + e);
		}
	}

	/**
	 * Method is used to select Drop down value with attribute value
	 * @param element
	 * @param value
	 */
	public void selectByValue(WebElement element, String value)
	{
		try {
			Select dropdown = getDropdown(element);
			if (dropdown != null) {
				dropdown.selectByValue(value);
			}
		} catch (WebDriverException e) {
			LOG.error("Unable to select value from the dropdown:" + element + "\n " + e.getMessage());
			throw new WebDriverException("Unable to select value from the dropdown:" + element + "\n " + e);
		}
	}

	/**
	 * Method is used to select Drop down value with visible text
	 * @param element
	 * @param textToSelect
	 * @param waitForElement
	 */
	public void selectByVisibleText(WebElement element, String textToSelect) {
		try {
			Select dropdown = getDropdown(element);
			if (dropdown != null) {
				dropdown.selectByVisibleText(textToSelect);
			}
		} catch (WebDriverException e) {
			LOG.error("Unable to select value from the dropdown:" + element + "\n " + e.getMessage());
			throw new WebDriverException("Unable to select value from the dropdown:" + element + "\n " + e);
		}
	}

	/**
	 * Method is used to get all options from drop down
	 * @param element
	 * @return
	 */
	public List<WebElement> getAllOptionsFromDropdown(WebElement element) {
		List<WebElement> allOptions = null;
		try {
			Select dropdown = getDropdown(element);
			if (dropdown != null) {
				allOptions = dropdown.getOptions();
			}
		} catch (WebDriverException e) {
			LOG.error("Unable to get all options from an element: " + element + "\n " + e.getMessage());
			throw new WebDriverException("Unable to get all options from an element: " + element + "\n " + e);
		}
		return allOptions;
	}

	/**
	 * Method to display the values selected from dropDown
	 * @param element
	 * @param text
	 */
	public List<String> getAllOptionsValuesFromDropdown(WebElement element) {
		List<String> allOptionValues = new ArrayList<String>();
		List<WebElement> allOptions = getAllOptionsFromDropdown(element);
		try {
			for (WebElement webElement : allOptions) {
				allOptionValues.add(getText(webElement));
			}
		} catch (WebDriverException e) {
			LOG.error("Unable to get selected values of an element: " + element + "\n " + e.getMessage());
			throw new WebDriverException("Unable to get selected values of an element: " + element + "\n " + e);
		}
		return allOptionValues;
	}

	/**
	 * Method is used to get the selected drop down text
	 * @param element
	 * @param waitForElement
	 * @return
	 */
	public String getSelectedValueFromDropDwon(WebElement element) {
		String selectedValue = null;
		try {
			Select dropdown = getDropdown(element);
			if (dropdown != null) {
				selectedValue = dropdown.getFirstSelectedOption().getText();
			}
			LOG.info("Selected drop down value : "+ selectedValue +"----is retrieved Successfully");
		} catch (WebDriverException e) {
			LOG.error("Unable to get selected value of an element: " + element + "\n " + e.getMessage());
			throw new WebDriverException("Unable to get selected value of an element: " + element + "\n " + e);
		}
		return selectedValue;
	}

	/**
	 * Method to select the last value from dropDown
	 * @param element
	 * @param text
	 */
	public void selectLastValue(WebElement element)
	{
		try {
			Select select = new Select(element);
			List<WebElement> allOptions = select.getOptions();
			int count = allOptions.size();
			System.out.println(count);	
			WebElement option = allOptions.get(count-1);
			String lastval = option.getText();
			LOG.info("Selected Last value : "+lastval+"----in the Drop Down");
		}
		catch (WebDriverException e) {
			LOG.error("Unable to select last value of an element: " + element + "\n " + e.getMessage());
			throw new WebDriverException("Unable to select last value of an element: " + element + "\n " + e);
		}
	}

	/**
	 * Method to select the first value from dropDown
	 * @param element
	 * @param FirstOptionValue
	 */
	public void selectFirstValue(WebElement element, String FirstOptionValue)
	{
		try {
			Select select = new Select(element);
			WebElement FirstOption = select.getFirstSelectedOption();
			FirstOptionValue = FirstOption.getText();
			LOG.info("Selected First value : "+FirstOptionValue+"----in the Drop Down");	
		}
		catch (WebDriverException e) {
			LOG.error("Unable to select first value of an element: " + element + "\n " + e.getMessage());
			throw new WebDriverException("Unable to select first value of an element: " + element + "\n " + e);
		}
	}

	/**
	 * Method to check the Listbox and deselect all selected values
	 * @param element
	 * @param index
	 */
	public void deselectAllValues(WebElement element, int index)
	{
		try {
			Select select = new Select(element);
			select.selectByIndex(index);	
			if(select.isMultiple()) 
			{
				select.deselectAll();
				LOG.info("Deselected all check boxes Successfully");
			}
			else
			{
				LOG.info("It is a Single Check box");
			}
		}
		catch (WebDriverException e) {
			LOG.error("Unable to deselect the values of an element: " + element + "\n " + e.getMessage());
			throw new WebDriverException("Unable to deselect the values of an element: " + element + "\n " + e);
		}
	}
}