package com.selenium.asserts;

import org.testng.asserts.SoftAssert;

public class SoftAssertion {

	private static SoftAssert softAssert = new SoftAssert();
	private static String assertionErrorConstant = "Assertion Error!!!! \n ";

	private SoftAssertion() {

	}

	/***
	 * Method to verify actual Value is same as expected value.
	 * 
	 * @param actualValue
	 * @param expectedValue
	 */
	public static void verifyEquals(Object actualValue, Object expectedValue) {
		try {
			softAssert.assertEquals(actualValue, expectedValue);
		} catch (AssertionError e) {
			throw new AssertionError(assertionErrorConstant + e);
		}
	}

	/***
	 * Method to verify actual Value is same as expected value. If they are not, an AssertionError, with the given message,is thrown.
	 * 
	 * @param actualValue
	 * @param expectedValue
	 * @param message
	 */
	public static void verifyEquals(Object actualValue, Object expectedValue, String message) {
		try {
			softAssert.assertEquals(actualValue, expectedValue, message);
		} catch (AssertionError e) {
			throw new AssertionError(assertionErrorConstant + message + "\n " + e);
		}
	}

	/***
	 * Method to verify actual Value is not same as expected value.
	 * 
	 * @param actualValue
	 * @param expectedValue
	 */
	public static void verifyNotEquals(Object actualValue, Object expectedValue) {
		try {
			softAssert.assertNotEquals(actualValue, expectedValue);
		} catch (AssertionError e) {
			throw new AssertionError(assertionErrorConstant + e);
		}
	}

	/***
	 * Method to verify actual Value is not same as expected value. If they are not, an AssertionError, with the given message,is thrown.
	 * 
	 * @param actualValue
	 * @param expectedValue
	 * @param message
	 */
	public static void verifyNotEquals(Object actualValue, Object expectedValue, String message) {
		try {
			softAssert.assertNotEquals(actualValue, expectedValue, message);
		} catch (AssertionError e) {
			throw new AssertionError(assertionErrorConstant + message + "\n " + e);
		}
	}

	/***
	 * Method Asserts that a condition is true.
	 * 
	 * @param flag
	 */
	public static void verifyTrue(boolean flag) {
		try {
			softAssert.assertTrue(flag);
		} catch (AssertionError e) {
			throw new AssertionError(assertionErrorConstant + e);
		}
	}

	/***
	 * Method Asserts that a condition is false.
	 * 
	 * @param flag
	 */
	public static void verifyFalse(boolean flag) {
		try {
			softAssert.assertFalse(flag);
		} catch (AssertionError e) {
			throw new AssertionError(assertionErrorConstant + e);
		}
	}

	/***
	 * Method Asserts that a condition is true. If they are not, an AssertionError, with the given message,is thrown.
	 * 
	 * @param flag
	 * @param message
	 */
	public static void verifyTrue(boolean flag, String message) {
		try {
			softAssert.assertTrue(flag, message);
		} catch (AssertionError e) {
			throw new AssertionError(assertionErrorConstant + message + "\n " + e);
		}
	}

	/***
	 * Method Asserts that a condition is false. If they are not, an AssertionError, with the given message,is thrown.
	 * 
	 * @param flag
	 * @param message
	 */
	public static void verifyFalse(boolean flag, String message) {
		try {
			softAssert.assertFalse(flag, message);
		} catch (AssertionError e) {
			throw new AssertionError(assertionErrorConstant + message + "\n " + e);
		}
	}

	/***
	 * Method to perform soft Assert.
	 */
	public static void assertAll() {
		try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			throw new AssertionError(assertionErrorConstant + "\n " + e);
		}
	}
}