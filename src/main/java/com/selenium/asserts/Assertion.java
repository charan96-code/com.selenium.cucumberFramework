package com.selenium.asserts;

import org.testng.Assert;

public class Assertion {
	private static String assertionErrorConstant = "Assertion Error!!!! \n ";

	private Assertion() {

	}

	public static void verifyEquals(Object actualValue, Object expectedValue) {
		try {
			Assert.assertEquals(actualValue, expectedValue);
		} catch (AssertionError e) {
			throw new AssertionError(assertionErrorConstant + e);
		}
	}

	/***
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

	public static void verifyNotEquals(Object actualValue, Object expectedValue) {
		try {
			Assert.assertNotEquals(actualValue, expectedValue);
		} catch (AssertionError e) {

			throw new AssertionError(assertionErrorConstant + e);
		}
	}

	public static void verifyNotEquals(Object actualValue, Object expectedValue, String message) {
		try {
			Assert.assertNotEquals(actualValue, expectedValue, message);
		} catch (AssertionError e) {

			throw new AssertionError(assertionErrorConstant + message + "\n " + e);
		}
	}

	public static void verifyTrue(boolean flag) {
		try {
			Assert.assertTrue(flag);
		} catch (AssertionError e) {

			throw new AssertionError(assertionErrorConstant + e);
		}
	}

	public static void verifyFalse(boolean flag) {
		try {
			Assert.assertFalse(flag);
		} catch (AssertionError e) {

			throw new AssertionError(assertionErrorConstant + e);
		}
	}

	public static void verifyTrue(boolean flag, String message) {
		try {
			Assert.assertTrue(flag, message);
		} catch (AssertionError e) {

			throw new AssertionError(assertionErrorConstant + message + "\n " + e);
		}
	}

	public static void verifyFalse(boolean flag, String message) {
		try {
			Assert.assertFalse(flag, message);
		} catch (AssertionError e) {

			throw new AssertionError(assertionErrorConstant + message + "\n " + e);
		}
	}
}