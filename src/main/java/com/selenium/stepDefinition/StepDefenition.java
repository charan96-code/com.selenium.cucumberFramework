package com.selenium.stepDefinition;

import com.selenium.implementation.Implementation;
import com.selenium.implementation.WebElementFactory;

import cucumber.api.java.en.When;

public class StepDefenition {

	WebElementFactory webElementFactory;
	Implementation implementation;

	public StepDefenition() {
		webElementFactory = new WebElementFactory();
		implementation = new Implementation();
	}
	
	@When("^User scroll down the page$")
	public void userScrollDownThePage() throws InterruptedException{
		implementation.scrollDownThePage(webElementFactory.getWebDriver());
	}
}