package com.selenium.TestFunctionality;

public class Dummy {

	public static void main(String[] args) {
		System.out.println("Hi, Thanks for supporting");
		
		
		/* Hard Assert
		 * 
		 * Assertion.verifyEquals("Hi", "Hi"); Assertion.verifyEquals("Hi", "Hi",
		 * "Miss match"); Assertion.verifyNotEquals("Hi", "Hi");
		 * Assertion.verifyNotEquals("Hi", "Hi", "OOPS the value matching");
		 * Assertion.verifyTrue(true); Assertion.verifyTrue(false, "It's False");
		 * Assertion.verifyFalse(true); Assertion.verifyFalse(true, "It's True");
		 */
		
		/* Soft Assert
		 * 
		 * SoftAssertion.verifyEquals("Hii", "Hi"); SoftAssertion.verifyEquals("Hii",
		 * "Hi","Miss match"); SoftAssertion.verifyNotEquals("Hi", "Hi");
		 * SoftAssertion.verifyNotEquals("Hi", "Hi", "OOPS the value matching");
		 * SoftAssertion.verifyTrue(false); SoftAssertion.verifyTrue(false,
		 * "It's False"); SoftAssertion.verifyFalse(true);
		 * SoftAssertion.verifyFalse(true, "It's True"); SoftAssertion.assertAll();
		 */
	}
}