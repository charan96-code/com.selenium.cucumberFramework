package com.selenium.asserts;

import org.testng.asserts.SoftAssert;

public class SoftAssertion {

	private static SoftAssert softAssert = new SoftAssert();
	private static String assertionErrorConstant = "Assertion Error!!!! \n ";

	private SoftAssertion() {

	}

	public static void verifyEquals(Object actualValue, Object expectedValue) {
		try {
			softAssert.assertEquals(actualValue, expectedValue);
		} catch (AssertionError e) {
			throw new AssertionError(assertionErrorConstant + e);
		}
	}

	public static void verifyEquals(Object actualValue, Object expectedValue, String message) {
		try {
			softAssert.assertEquals(actualValue, expectedValue, message);
		} catch (AssertionError e) {
			throw new AssertionError(assertionErrorConstant + message + "\n " + e);
		}
	}

	public static void verifyNotEquals(Object actualValue, Object expectedValue) {
		try {
			softAssert.assertNotEquals(actualValue, expectedValue);
		} catch (AssertionError e) {
			throw new AssertionError(assertionErrorConstant + e);
		}
	}

	public static void verifyNotEquals(Object actualValue, Object expectedValue, String message) {
		try {
			softAssert.assertNotEquals(actualValue, expectedValue, message);
		} catch (AssertionError e) {
			throw new AssertionError(assertionErrorConstant + message + "\n " + e);
		}
	}

	public static void verifyTrue(boolean flag) {
		try {
			softAssert.assertTrue(flag);
		} catch (AssertionError e) {
			throw new AssertionError(assertionErrorConstant + e);
		}
	}

	public static void verifyFalse(boolean flag) {
		try {
			softAssert.assertFalse(flag);
		} catch (AssertionError e) {
			throw new AssertionError(assertionErrorConstant + e);
		}
	}

	public static void verifyTrue(boolean flag, String message) {
		try {
			softAssert.assertTrue(flag, message);
		} catch (AssertionError e) {
			throw new AssertionError(assertionErrorConstant + message + "\n " + e);
		}
	}

	public static void verifyFalse(boolean flag, String message) {
		try {
			softAssert.assertFalse(flag, message);
		} catch (AssertionError e) {
			throw new AssertionError(assertionErrorConstant + message + "\n " + e);
		}
	}

	public static void assertAll() {
		try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			throw new AssertionError(assertionErrorConstant + "\n " + e);
		}
	}
}