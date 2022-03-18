package com.selenium.asserts;

import org.testng.Assert;

public class Assertion {
	private static String assertionErrorConstant = "Assertion Error!!!! \n ";

	private Assertion() {

	}
	
	/***
	 * Method to verify actual Value is same as expected value.
	 * 
	 * @param actualValue
	 * @param expectedValue
	 */
	public static void verifyEquals(Object actualValue, Object expectedValue) {
		try {
			Assert.assertEquals(actualValue, expectedValue);
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
			Assert.assertEquals(actualValue, expectedValue, message);
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
			Assert.assertNotEquals(actualValue, expectedValue);
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
			Assert.assertNotEquals(actualValue, expectedValue, message);
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
			Assert.assertTrue(flag);
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
			Assert.assertFalse(flag);
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
			Assert.assertTrue(flag, message);
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
			Assert.assertFalse(flag, message);
		} catch (AssertionError e) {

			throw new AssertionError(assertionErrorConstant + message + "\n " + e);
		}
	}
}