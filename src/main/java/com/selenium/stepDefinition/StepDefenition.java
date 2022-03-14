package com.selenium.stepDefinition;

import com.selenium.implimentation.Implimentation;
import com.selenium.implimentation.WebElementFactory;

import cucumber.api.java.en.When;

public class StepDefenition {

	WebElementFactory webElementFactory;
	Implimentation referenceDataImpl;

	public StepDefenition() {
		webElementFactory = new WebElementFactory();
		referenceDataImpl = new Implimentation();
	}
	
	@When("^User scroll down the page$")
	public void userScrollDownThePage() throws InterruptedException{
		referenceDataImpl.scrollDownThePage(webElementFactory.getWebDriver());
	}
}